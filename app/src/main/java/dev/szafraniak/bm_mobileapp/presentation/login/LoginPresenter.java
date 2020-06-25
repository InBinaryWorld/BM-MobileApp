package dev.szafraniak.bm_mobileapp.presentation.login;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.auth.AuthorizationService;
import dev.szafraniak.bm_mobileapp.business.memory.SessionManager;
import lombok.Setter;

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

}
