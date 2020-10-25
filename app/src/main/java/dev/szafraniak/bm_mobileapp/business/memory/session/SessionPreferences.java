package dev.szafraniak.bm_mobileapp.business.memory.session;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;

import static android.content.Context.MODE_PRIVATE;
import static dev.szafraniak.bm_mobileapp.business.Constance.PREFERENCES_SESSION_PREFIX;

public class SessionPreferences {

    private final SharedPreferences preferences;
    private final static String ACCESS_TOKEN = "session.access.token";
    private final static String REFRESH_TOKEN = "session.refresh.token";
    private final static String TOKEN_TYPE = "session.token.type";
    private final static String CURRENT_COMPANY_ID = "current.company.id";

    @Inject
    Gson gson;

    public SessionPreferences(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
        preferences = app.getSharedPreferences(PREFERENCES_SESSION_PREFIX, MODE_PRIVATE);
    }

    public void setAccessToken(String accessToken) {
        preferences.edit().putString(ACCESS_TOKEN, accessToken).apply();
    }

    public void setRefreshToken(String refreshToken) {
        preferences.edit().putString(REFRESH_TOKEN, refreshToken).apply();
    }

    public void setTokenType(String tokenType) {
        preferences.edit().putString(TOKEN_TYPE, tokenType).apply();
    }

    public String getAccessToken() {
        return preferences.getString(ACCESS_TOKEN, null);
    }

    public String getRefreshToken() {
        return preferences.getString(REFRESH_TOKEN, null);
    }

    public String getTokenType() {
        return preferences.getString(TOKEN_TYPE, null);
    }

    public void setCompanyId(Long companyId) {
        preferences.edit().putLong(CURRENT_COMPANY_ID, companyId).apply();
    }

    public Long getCompanyId() {
        return preferences.getLong(CURRENT_COMPANY_ID, -1);
    }
}
