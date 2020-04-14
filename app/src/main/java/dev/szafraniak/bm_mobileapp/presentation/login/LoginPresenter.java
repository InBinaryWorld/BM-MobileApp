package dev.szafraniak.bm_mobileapp.presentation.login;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.BMApplication;
import dev.szafraniak.bm_mobileapp.business.entity.AuthorizationResponse;
import dev.szafraniak.bm_mobileapp.business.http.service.AuthorizationService;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.annotations.NonNull;
import lombok.Setter;
import timber.log.Timber;

public class LoginPresenter {

    @Setter
    LoginView view;

    @Inject
    AuthorizationService service;

    public LoginPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    private void loginSuccesses(@NonNull AuthorizationResponse response) {
        Timber.d("!!!!!!!!!!!! Congratulations !!!!!!!!!!!");
    }


    public void signInWithCredentials(String userName, String password) {
        service.loginWithCredentials(userName, password)
                .compose(view.bindToLifecycle())
                .subscribe(new LoginObserver("Login Failed: wrong username or password"));
    }

    public void exchangeGoogleToken(String idToken) {
        service.loginWithGoogle(idToken)
                .compose(view.bindToLifecycle())
                .subscribe(new LoginObserver("Login Failed: internal error"));
    }

    private class LoginObserver implements Observer<AuthorizationResponse> {
        String errMsg;

        public LoginObserver(String errorMessage) {
            errMsg = errorMessage;
        }

        @Override
        public void onSubscribe(Disposable d) {
        }

        @Override
        public void onNext(@NonNull AuthorizationResponse response) {
            loginSuccesses(response);
        }

        @Override
        public void onError(Throwable t) {
            view.UIOnLoginFailed(errMsg);
        }

        @Override
        public void onComplete() {
        }
    }
}
