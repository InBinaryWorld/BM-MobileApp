package dev.szafraniak.bm_mobileapp.business.http.service.auth;

import android.content.Intent;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.auth.AuthorizationResponse;
import dev.szafraniak.bm_mobileapp.presentation.shared.base.BaseActivity;
import io.reactivex.observers.DisposableSingleObserver;

import static dev.szafraniak.bm_mobileapp.business.Constance.ACTIVITY_RESULT_CODE_FACEBOOK_LOGIN;
import static dev.szafraniak.bm_mobileapp.business.Constance.ACTIVITY_RESULT_CODE_GOOGLE_LOGIN;

public class LoginService {

    @Inject
    AuthorizationService authorizationService;

    @Inject
    GoogleSignInClient googleClient;

    private final BaseActivity activity;
    private final LoginCallback callback;
    private final LoginManager loginManager;
    private final CallbackManager callbackManager;

    public LoginService(BaseActivity activity, LoginCallback callback) {
        ((BMApplication) activity.getApplication()).getAppComponent().inject(this);
        this.callback = callback;
        this.activity = activity;
        callbackManager = CallbackManager.Factory.create();
        loginManager = LoginManager.getInstance();
        loginManager.registerCallback(callbackManager, new FacebookCallbackImpl());
    }

    public void silentFacebookSignIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if (accessToken != null && !accessToken.isExpired()) {
            exchangeFacebookToken(accessToken.getToken(), new SilentLoginObserver());
            return;
        }
        silentLoginFailed(new Exception("Facebook token is not active"));
    }

    public void silentGoogleSignIn() {
        googleClient.silentSignIn().addOnCompleteListener(activity, this::handleSilentGoogleLogin);
    }

    public void signInWithGoogle() {
        Intent signInIntent = googleClient.getSignInIntent();
        activity.startActivityForResult(signInIntent, ACTIVITY_RESULT_CODE_GOOGLE_LOGIN);
    }

    public void signInWithFacebook() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if (AccessToken.isCurrentAccessTokenActive()) {
            exchangeFacebookToken(accessToken.getToken(), new LoginObserver());
        } else {
            loginManager.logIn(activity, Collections.emptyList());
        }
    }

    private void exchangeGoogleToken(String idToken, DisposableSingleObserver<AuthorizationResponse> callback) {
        authorizationService.loginWithGoogle(idToken)
            .compose(activity.bindToLifecycle())
            .subscribe(callback);
    }

    private void exchangeFacebookToken(String token, DisposableSingleObserver<AuthorizationResponse> callback) {
        authorizationService.loginWithFacebook(token)
            .compose(activity.bindToLifecycle())
            .subscribe(callback);
    }

    private void loginSucceed(AuthorizationResponse authorizationResponse) {
        callback.onSuccess(authorizationResponse);
    }

    private void loginFailed(Exception e) {
        callback.onFailed(e);
    }

    private void silentLoginFailed(Exception e) {
        callback.onSilentFailed(e);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ACTIVITY_RESULT_CODE_GOOGLE_LOGIN) {
            handleGoogleActivityResult(data);
        } else if (requestCode == ACTIVITY_RESULT_CODE_FACEBOOK_LOGIN) {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void handleGoogleActivityResult(Intent data) {
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        try {
            String token = extractToken(task);
            exchangeGoogleToken(token, new LoginObserver());
        } catch (Exception e) {
            loginFailed(e);
        }
    }

    private void handleSilentGoogleLogin(Task<GoogleSignInAccount> task) {
        try {
            String token = extractToken(task);
            exchangeGoogleToken(token, new SilentLoginObserver());
        } catch (Exception e) {
            silentLoginFailed(e);
        }
    }

    private String extractToken(Task<GoogleSignInAccount> completedTask) throws Exception {
        GoogleSignInAccount account = completedTask.getResult(ApiException.class);
        if (account == null) {
            throw new Exception("Failed to get acoount");
        }
        return account.getIdToken();
    }


    class FacebookCallbackImpl implements FacebookCallback<LoginResult> {
        @Override
        public void onSuccess(LoginResult loginResult) {
            exchangeFacebookToken(loginResult.getAccessToken().getToken(), new LoginObserver());
        }

        @Override
        public void onCancel() {
            loginFailed(new Exception("Login canceled"));
        }

        @Override
        public void onError(FacebookException exception) {
            loginFailed(exception);
        }
    }

    private class LoginObserver extends DisposableSingleObserver<AuthorizationResponse> {
        @Override
        public void onSuccess(@NotNull AuthorizationResponse response) {
            loginSucceed(response);
        }

        @Override
        public void onError(Throwable t) {
            loginFailed(new Exception(t.getMessage(), t.getCause()));
        }
    }

    private class SilentLoginObserver extends DisposableSingleObserver<AuthorizationResponse> {
        @Override
        public void onSuccess(@NotNull AuthorizationResponse response) {
            loginSucceed(response);
        }

        @Override
        public void onError(Throwable t) {
            silentLoginFailed(new Exception(t.getMessage(), t.getCause()));
        }
    }

    public interface LoginCallback {
        void onSuccess(AuthorizationResponse authorizationResponse);

        void onFailed(Exception e);

        void onSilentFailed(Exception e);
    }


}
