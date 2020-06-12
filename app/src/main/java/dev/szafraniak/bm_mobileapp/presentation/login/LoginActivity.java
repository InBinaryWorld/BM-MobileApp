package dev.szafraniak.bm_mobileapp.presentation.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.BuildConfig;
import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.presentation.BaseActivity;
import timber.log.Timber;

import static dev.szafraniak.bm_mobileapp.business.Constance.ACTIVITY_RESULT_CODE_FACEBOOK_LOGIN;
import static dev.szafraniak.bm_mobileapp.business.Constance.ACTIVITY_RESULT_CODE_GOOGLE_LOGIN;

@SuppressLint("Registered")
@EActivity(R.layout.login_activity)
public class LoginActivity extends BaseActivity implements LoginView {

    @Inject
    UserPreferences userPreferences;

    @Inject
    LoginPresenter presenter;

    private LoginManager loginManager;
    private CallbackManager callbackManager;
    private GoogleSignInClient googleClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BMApplication) getApplication()).getAppComponent().inject(this);
        presenter.setView(this);

        callbackManager = CallbackManager.Factory.create();
        loginManager = LoginManager.getInstance();
        loginManager.registerCallback(callbackManager, new FacebookCallbackImpl());

        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(BuildConfig.GOOGLE_CLIENT_ID)
                .build();
        googleClient = GoogleSignIn.getClient(this, gso);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (AccessToken.isCurrentAccessTokenActive() && !userPreferences.facebookSilentLogin()) {
            loginManager.logOut();
        }

        if (userPreferences.facebookSilentLogin() && AccessToken.isCurrentAccessTokenActive()) {
            showProgressBar();
            presenter.exchangeFacebookToken(AccessToken.getCurrentAccessToken().getToken());
        } else if (userPreferences.googleSilentLoginEnabled()) {
            showProgressBar();
            googleClient.silentSignIn().addOnCompleteListener(this, this::handleGoogleSignInResult);
        }
    }

    @Override
    public void showProgressBar() {
    }

    @Override
    public void showError() {
    }

    @Click(R.id.sign_in)
    public void credentialSignIn() {
        showProgressBar();
        presenter.signInWithCredentials("test", "test");
    }

    @Click(R.id.sign_in_google_button)
    protected void googleSignIn() {
        showProgressBar();
        Intent signInIntent = googleClient.getSignInIntent();
        startActivityForResult(signInIntent, ACTIVITY_RESULT_CODE_GOOGLE_LOGIN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ACTIVITY_RESULT_CODE_GOOGLE_LOGIN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleGoogleSignInResult(task);
        } else if (requestCode == ACTIVITY_RESULT_CODE_FACEBOOK_LOGIN) {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void handleGoogleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            if (account != null && account.getIdToken() != null) {
                presenter.exchangeGoogleToken(account.getIdToken());
            } else {
                showError();
            }
        } catch (ApiException e) {
            Timber.e("signInResult:failed code=%s", e.getStatusCode());
            showError();
        }
    }

    class FacebookCallbackImpl implements FacebookCallback<LoginResult> {
        @Override
        public void onSuccess(LoginResult loginResult) {
            showProgressBar();
            presenter.exchangeFacebookToken(loginResult.getAccessToken().getToken());
        }

        @Override
        public void onCancel() {
            showError();
        }

        @Override
        public void onError(FacebookException exception) {
            showError();
        }
    }
}
