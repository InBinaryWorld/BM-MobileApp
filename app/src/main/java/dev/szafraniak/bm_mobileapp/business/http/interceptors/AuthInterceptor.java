package dev.szafraniak.bm_mobileapp.business.http.interceptors;

import android.app.Application;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.HttpUtils;
import dev.szafraniak.bm_mobileapp.business.memory.SessionManager;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    @Inject
    SessionManager sessionManager;

    public AuthInterceptor(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();

        String token = sessionManager.getFullAuthToken();
        if (token == null) {
            return chain.proceed(request);
        }

        request = HttpUtils.addAuthToRequest(request, token);
        return chain.proceed(request);
    }
}
