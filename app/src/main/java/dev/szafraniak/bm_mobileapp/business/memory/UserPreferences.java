package dev.szafraniak.bm_mobileapp.business.memory;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import dev.szafraniak.bm_mobileapp.business.models.IdNameEntity;

import static android.content.Context.MODE_PRIVATE;
import static dev.szafraniak.bm_mobileapp.business.Constance.PREFERENCES_USER_PREFIX;

public class UserPreferences {
    private final SharedPreferences preferences;
    private final static String GOOGLE_SILENT_LOGIN_ENABLED = "google.silent.login.enabled";
    private final static String FACEBOOK_SILENT_LOGIN_ENABLED = "facebook.silent.login.enabled";
    private final static String CURRENT_COMPANY = "current.company";

    private final static Gson gson = new Gson();

    public UserPreferences(Context ctx) {
        preferences = ctx.getSharedPreferences(PREFERENCES_USER_PREFIX, MODE_PRIVATE);
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

    public void setCompany(IdNameEntity company) {
        String json = gson.toJson(company);
        preferences.edit().putString(CURRENT_COMPANY, json).apply();
    }

    public IdNameEntity getCompany() {
        String json = preferences.getString(CURRENT_COMPANY, null);
        return gson.fromJson(json, IdNameEntity.class);
    }

}
