package dev.szafraniak.bm_mobileapp.business.memory.settings;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;

public class SettingsManager {

    @Inject
    SettingsPreferences preferences;

    public SettingsManager(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public boolean getFacebookSilentLoginEnabled() {
        return preferences.getFacebookSilentLoginEnabled();
    }

    public boolean getGoogleSilentLoginEnabled() {
        return preferences.getGoogleSilentLoginEnabled();
    }

    public void negateFacebookSilentSetting() {
        boolean facebookEnabled = getFacebookSilentLoginEnabled();
        preferences.setFacebookSilentLoginEnabled(!facebookEnabled);
        preferences.setGoogleSilentLoginEnabled(false);
    }

    public void negateGoogleSilentLoginEnabled() {
        boolean googleEnabled = getGoogleSilentLoginEnabled();
        preferences.setGoogleSilentLoginEnabled(!googleEnabled);
        preferences.setFacebookSilentLoginEnabled(false);
    }
}
