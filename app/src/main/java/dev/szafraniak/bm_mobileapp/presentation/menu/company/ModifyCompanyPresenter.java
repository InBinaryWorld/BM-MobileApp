package dev.szafraniak.bm_mobileapp.presentation.menu.company;

import android.app.Application;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import lombok.Setter;

public class ModifyCompanyPresenter {

    @Setter
    ModifyCompanyView view;

    public ModifyCompanyPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

}
