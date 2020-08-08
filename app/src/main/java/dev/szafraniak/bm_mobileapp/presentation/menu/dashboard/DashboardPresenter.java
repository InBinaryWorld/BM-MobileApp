package dev.szafraniak.bm_mobileapp.presentation.menu.dashboard;

import android.app.Application;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import lombok.Setter;

public class DashboardPresenter {

    @Setter
    DashboardView view;

    public DashboardPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }
}
