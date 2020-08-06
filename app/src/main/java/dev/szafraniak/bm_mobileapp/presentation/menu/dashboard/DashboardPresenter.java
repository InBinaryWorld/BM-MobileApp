package dev.szafraniak.bm_mobileapp.presentation.menu.dashboard;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.UserService;
import lombok.Setter;

public class DashboardPresenter {

    @Setter
    DashboardView view;

    @Inject
    UserService userService;

    public DashboardPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }
}
