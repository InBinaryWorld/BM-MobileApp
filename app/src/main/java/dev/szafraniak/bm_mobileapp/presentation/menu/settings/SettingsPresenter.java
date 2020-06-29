package dev.szafraniak.bm_mobileapp.presentation.menu.settings;

import android.app.Application;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import lombok.Setter;

public class SettingsPresenter {

    @Setter
    SettingsView view;

    public SettingsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

}
