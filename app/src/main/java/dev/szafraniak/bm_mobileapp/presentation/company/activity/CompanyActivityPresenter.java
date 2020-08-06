package dev.szafraniak.bm_mobileapp.presentation.company.activity;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import lombok.Setter;

public class CompanyActivityPresenter {

    @Setter
    CompanyActivity view;

    @Inject
    UserPreferences userPreferences;


    public CompanyActivityPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void initializePresenter(CompanyActivity view) {
        this.view = view;
    }

}
