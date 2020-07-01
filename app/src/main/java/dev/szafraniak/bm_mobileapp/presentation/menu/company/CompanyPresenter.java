package dev.szafraniak.bm_mobileapp.presentation.menu.company;

import android.app.Application;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import lombok.Setter;

public class CompanyPresenter {

    @Setter
    CompanyView view;

    public CompanyPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

}
