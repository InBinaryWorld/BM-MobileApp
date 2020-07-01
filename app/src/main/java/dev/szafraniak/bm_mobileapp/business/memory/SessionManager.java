package dev.szafraniak.bm_mobileapp.business.memory;

import android.app.Application;
import android.content.Context;

import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.entity.AuthorizationResponse;

public class SessionManager {

    @Inject
    GoogleSignInClient googleClient;

    @Inject
    SessionPreferences session;

    @Inject
    Context context;

    public SessionManager(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void clearSession() {
        session.setTokenType(null);
        session.setAccessToken(null);
        session.setRefreshToken(null);
    }

    public void setSession(AuthorizationResponse authorization) {
        session.setTokenType(authorization.getTokenType());
        session.setAccessToken(authorization.getAccessToken());
        session.setRefreshToken(authorization.getRefreshToken());
    }

    public String getFullAuthToken() {
        String type = session.getTokenType();
        String token = session.getAccessToken();
        if (type == null || token == null)
            return null;
        return String.format("%s %s", type, token);
    }

    public String getRefreshToken() {
        return session.getRefreshToken();
    }

    public void logout() {
        LoginManager.getInstance().logOut();
        googleClient.signOut();
        clearSession();
    }

}
