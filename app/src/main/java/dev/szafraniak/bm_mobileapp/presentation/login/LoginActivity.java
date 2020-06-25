package dev.szafraniak.bm_mobileapp.presentation.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.facebook.AccessToken;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.entity.AuthorizationResponse;
import dev.szafraniak.bm_mobileapp.business.http.service.auth.LoginService;
import dev.szafraniak.bm_mobileapp.business.memory.SessionManager;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.business.models.LoginCallback;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.BaseActivity;
import dev.szafraniak.bm_mobileapp.presentation.menu.activity.MenuActivity_;

@SuppressLint("Registered")
@EActivity(R.layout.login_activity)
public class LoginActivity extends BaseActivity implements LoginView {

    @Inject
    UserPreferences userPreferences;

    @Inject
    LoginPresenter presenter;

    @Inject
    SessionManager session;

    LoginService loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BMApplication) getApplication()).getAppComponent().inject(this);
        loginService = new LoginService(this, new LoginCallbackImpl());
        presenter.setView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (userPreferences.facebookSilentLogin() && AccessToken.isCurrentAccessTokenActive()) {
            showProgressBar();
            loginService.silentFacebookSignIn();
        } else if (userPreferences.googleSilentLoginEnabled()) {
            showProgressBar();
            loginService.silentGoogleSignIn();
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
        loginService.signInWithCredentials("test", "test");
    }

    @Click(R.id.sign_in_google_button)
    protected void googleSignIn() {
        showProgressBar();
        loginService.signInWithGoogle();
    }

    @Click(R.id.sign_in_facebook_button)
    protected void facebookSignIn() {
        showProgressBar();
        loginService.signInWithFacebook();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        loginService.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private class LoginCallbackImpl implements LoginCallback {
        @Override
        public void onSuccess(AuthorizationResponse response) {
            session.setSession(response);
            Navigator.startActivity(getContext(), MenuActivity_.class);
        }

        @Override
        public void onFailed(Exception e) {
            showError();
        }

        @Override
        public void onSilentFailed(Exception e) {

        }
    }
}
