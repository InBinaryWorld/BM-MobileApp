package dev.szafraniak.bm_mobileapp.business.memory;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;
import static dev.szafraniak.bm_mobileapp.business.Constance.PREFERENCES_SESSION_PREFIX;

public class SessionPreferences {
    private final SharedPreferences preferences;
    private final static String ACCESS_TOKEN = "session.access.token";
    private final static String REFRESH_TOKEN = "session.refresh.token";
    private final static String TOKEN_TYPE = "session.token.type";


    public SessionPreferences(Context ctx) {
        preferences = ctx.getSharedPreferences(PREFERENCES_SESSION_PREFIX, MODE_PRIVATE);
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
}
