package dev.szafraniak.bm_mobileapp.business.memory.settings;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;

import static android.content.Context.MODE_PRIVATE;
import static dev.szafraniak.bm_mobileapp.business.Constance.PREFERENCES_USER_PREFIX;

public class SettingsPreferences {
    
    private final SharedPreferences preferences;
    private final static String GOOGLE_SILENT_LOGIN_ENABLED = "google.silent.login.enabled";
    private final static String FACEBOOK_SILENT_LOGIN_ENABLED = "facebook.silent.login.enabled";

    @Inject
    Gson gson;

    public SettingsPreferences(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
        preferences = app.getSharedPreferences(PREFERENCES_USER_PREFIX, MODE_PRIVATE);
    }

    public void setGoogleSilentLoginEnabled(boolean state) {
        preferences.edit().putBoolean(GOOGLE_SILENT_LOGIN_ENABLED, state).apply();
    }

    public boolean getGoogleSilentLoginEnabled() {
        return preferences.getBoolean(GOOGLE_SILENT_LOGIN_ENABLED, false);
    }

    public void setFacebookSilentLoginEnabled(boolean state) {
        preferences.edit().putBoolean(FACEBOOK_SILENT_LOGIN_ENABLED, state).apply();
    }

    public boolean getFacebookSilentLoginEnabled() {
        return preferences.getBoolean(FACEBOOK_SILENT_LOGIN_ENABLED, false);
    }

}
