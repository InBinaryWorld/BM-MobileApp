package dev.szafraniak.bm_mobileapp.presentation.login;

import android.app.Application;
import android.content.Intent;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.auth.AuthorizationService;
import dev.szafraniak.bm_mobileapp.business.http.service.auth.LoginService;
import dev.szafraniak.bm_mobileapp.business.memory.SessionManager;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.business.models.auth.AuthorizationResponse;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.company.CompanyActivity_;
import lombok.Setter;
import timber.log.Timber;

public class LoginPresenter {
    @Setter
    LoginView view;

    @Inject
    AuthorizationService service;

    @Inject
    SessionManager session;

    @Inject
    UserPreferences userPreferences;

    private LoginService loginService;

    public LoginPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void initializePresenter(LoginView view) {
        this.view = view;
        this.loginService = new LoginService(view, new LoginCallbackImpl());
    }

    public void registerLoginService(int requestCode, int resultCode, Intent data) {
        loginService.onActivityResult(requestCode, resultCode, data);
    }

    public void performSilentLogin() {
        if (isFacebookSilentLoginEnabled()) {
            loginService.silentFacebookSignIn();
        }
        if (isGoogleSilentLoginEnabled()) {
            loginService.silentGoogleSignIn();
        }
    }

    public void signInWithFacebook() {
        loginService.signInWithFacebook();
    }

    public void signInWithGoogle() {
        loginService.signInWithGoogle();
    }

    public boolean isSilentLoginEnabled() {
        return isFacebookSilentLoginEnabled() || isGoogleSilentLoginEnabled();
    }

    private boolean isGoogleSilentLoginEnabled() {
        System.out.println("google silent: " + userPreferences.getGoogleSilentLoginEnabled());
        return userPreferences.getGoogleSilentLoginEnabled();
    }

    private boolean isFacebookSilentLoginEnabled() {
        return userPreferences.getFacebookSilentLoginEnabled();
    }

    private class LoginCallbackImpl implements LoginService.LoginCallback {
        @Override
        public void onSuccess(AuthorizationResponse response) {
            session.setSession(response);
            Navigator.startActivityOnEmptyStack(view.getContext(), CompanyActivity_.class);
        }

        @Override
        public void onFailed(Exception e) {
            Timber.e(e);
            view.onFailed();
        }

        @Override
        public void onSilentFailed(Exception e) {
            Timber.e(e);
            view.onSilentFailed();
        }
    }

}
