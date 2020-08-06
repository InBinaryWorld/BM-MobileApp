package dev.szafraniak.bm_mobileapp.presentation.company.create;

import android.app.Application;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import lombok.Setter;

public class CompanyCreatePresenter {

    @Setter
    CompanyCreateView view;

    public CompanyCreatePresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }
}
