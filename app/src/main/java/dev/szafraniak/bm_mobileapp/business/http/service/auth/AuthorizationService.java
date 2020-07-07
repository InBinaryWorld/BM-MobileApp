package dev.szafraniak.bm_mobileapp.business.http.service.auth;

import android.app.Application;
import android.util.ArrayMap;

import java.util.Map;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.entity.AuthorizationResponse;
import dev.szafraniak.bm_mobileapp.business.http.HttpUtils;
import dev.szafraniak.bm_mobileapp.business.http.api.AuthorizationApi;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AuthorizationService {

    @Inject
    AuthorizationApi serverApi;

    public AuthorizationService(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public AuthorizationResponse refreshToken(String refreshToken) {
        Map<String, String> fields = new ArrayMap<>();
        fields.put("refreshToken", refreshToken);
        return HttpUtils.executeCall(serverApi.refreshToken(fields));
    }

    public Single<AuthorizationResponse> loginWithGoogle(String token) {
        Map<String, String> fields = new ArrayMap<>();
        fields.put("token", token);
        return serverApi.exchangeGoogleToken(fields)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<AuthorizationResponse> loginWithFacebook(String token) {
        Map<String, String> fields = new ArrayMap<>();
        fields.put("token", token);
        return serverApi.exchangeFacebookToken(fields)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
