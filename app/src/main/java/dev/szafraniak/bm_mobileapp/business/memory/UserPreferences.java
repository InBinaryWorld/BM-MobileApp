package dev.szafraniak.bm_mobileapp.business.memory;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;
import static dev.szafraniak.bm_mobileapp.business.Constance.PREFERENCES_USER_PREFIX;

public class UserPreferences {
    private final SharedPreferences preferences;
    private final static String GOOGLE_SILENT_LOGIN_ENABLED = "google.silent.login.enabled";
    private final static String FACEBOOK_SILENT_LOGIN_ENABLED = "facebook.silent.login.enabled";

    public UserPreferences(Context ctx) {
        preferences = ctx.getSharedPreferences(PREFERENCES_USER_PREFIX, MODE_PRIVATE);
    }

    public void setGoogleSilentLoginEnabled(boolean state) {
        preferences.edit().putBoolean(GOOGLE_SILENT_LOGIN_ENABLED, state).apply();
    }

    public boolean googleSilentLoginEnabled() {
        return preferences.getBoolean(GOOGLE_SILENT_LOGIN_ENABLED, false);
    }

    public void setFacebookSilentLoginEnabled(boolean state) {
        preferences.edit().putBoolean(FACEBOOK_SILENT_LOGIN_ENABLED, state).apply();
    }

    public boolean facebookSilentLogin() {
        return preferences.getBoolean(FACEBOOK_SILENT_LOGIN_ENABLED, false);
    }

}
