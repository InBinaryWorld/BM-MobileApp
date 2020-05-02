package dev.szafraniak.bm_mobileapp.presentation.login;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.entity.AuthorizationResponse;
import dev.szafraniak.bm_mobileapp.business.http.service.AuthorizationService;
import dev.szafraniak.bm_mobileapp.business.memory.SessionManager;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.activity.MenuActivity_;
import io.reactivex.observers.DisposableSingleObserver;
import lombok.Setter;
import timber.log.Timber;

public class LoginPresenter {
    @Setter
    LoginView view;

    @Inject
    AuthorizationService service;

    @Inject
    SessionManager session;

    public LoginPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void signInWithCredentials(String userName, String password) {
        service.loginWithCredentials(userName, password)
                .compose(view.bindToLifecycle())
                .subscribe(new LoginObserver());
    }

    public void exchangeGoogleToken(String idToken) {
        service.loginWithGoogle(idToken)
                .compose(view.bindToLifecycle())
                .subscribe(new LoginObserver());
    }

    private class LoginObserver extends DisposableSingleObserver<AuthorizationResponse> {
        @Override
        public void onSuccess(AuthorizationResponse response) {
            session.setSession(response);
            Navigator.startActivity(view.getContext(), MenuActivity_.class);
        }

        @Override
        public void onError(Throwable t) {
            view.showError();
            Timber.e(t);
        }
    }
}
