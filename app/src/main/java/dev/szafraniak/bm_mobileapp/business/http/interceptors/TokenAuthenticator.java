package dev.szafraniak.bm_mobileapp.business.http.interceptors;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.HttpUtils;
import dev.szafraniak.bm_mobileapp.business.http.service.auth.AuthorizationService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.auth.AuthorizationResponse;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import timber.log.Timber;

/**
 * Authenticator react on 401 response
 */
public class TokenAuthenticator implements okhttp3.Authenticator {

    @Inject
    SessionManager session;

    @Inject
    AuthorizationService service;

    @Inject
    Context context;

    public TokenAuthenticator(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @Override
    public synchronized Request authenticate(Route route, Response response) {
        AuthorizationResponse tokenResponse = service.refreshToken(session.getRefreshToken());
        if (tokenResponse == null) {
            Timber.e("Refreshing token failed!");
            Navigator.navigateToLoginActivity(context, session);
            return null;
        }

        session.setTokens(tokenResponse);
        return HttpUtils.addAuthToRequest(response.request(), session.getFullAuthToken());
    }
}
