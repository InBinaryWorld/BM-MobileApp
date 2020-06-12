package dev.szafraniak.bm_mobileapp.business.http.service;

import android.app.Application;
import android.util.ArrayMap;

import java.util.Map;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.BuildConfig;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.entity.AuthorizationResponse;
import dev.szafraniak.bm_mobileapp.business.http.HttpUtils;
import dev.szafraniak.bm_mobileapp.business.http.api.AuthorizationServerApi;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AuthorizationService {
    private final static String FIELD_CLIENT_ID = "client_id";
    private final static String FIELD_GRANT_TYPE = "grant_type";
    private final static String FIELD_USERNAME = "username";
    private final static String FIELD_PASSWORD = "password";
    private final static String FIELD_SUBJECT_TOKEN = "subject_token";
    private final static String FIELD_SUBJECT_TOKEN_TYPE = "subject_token_type";
    private final static String FIELD_SUBJECT_ISSUER = "subject_issuer";
    private final static String FIELD_REFRESH_TOKEN = "refresh_token";
    private final static String GRANT_TYPE_PASSWORD = "password";
    private final static String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";
    private final static String GRANT_TYPE_TOKEN_EXCHANGE = "urn:ietf:params:oauth:grant-type:token-exchange";
    private final static String SUBJECT_ISSUER_GOOGLE = "google";
    private final static String SUBJECT_ISSUER_FACEBOOK = "facebook";
    private final static String SUBJECT_TOKEN_TYPE_ACCESS_TOKEN = "urn:ietf:params:oauth:token-type:access_token";

    @Inject
    AuthorizationServerApi serverApi;

    public AuthorizationService(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public Single<AuthorizationResponse> loginWithCredentials(String username, String password) {
        Map<String, String> fields = new ArrayMap<>();
        fields.put(FIELD_CLIENT_ID, BuildConfig.AUTHORIZATION_CLIENT_ID);
        fields.put(FIELD_GRANT_TYPE, GRANT_TYPE_PASSWORD);
        fields.put(FIELD_USERNAME, username);
        fields.put(FIELD_PASSWORD, password);
        return serverApi.tokenEndpoint(fields)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public AuthorizationResponse refreshToken(String refreshToken) {
        Map<String, String> fields = new ArrayMap<>();
        fields.put(FIELD_CLIENT_ID, BuildConfig.AUTHORIZATION_CLIENT_ID);
        fields.put(FIELD_GRANT_TYPE, GRANT_TYPE_REFRESH_TOKEN);
        fields.put(FIELD_REFRESH_TOKEN, refreshToken);
        return HttpUtils.executeCall(serverApi.syncTokenEndpoint(fields));
    }

    public Single<AuthorizationResponse> loginWithGoogle(String token) {
        return socialLogin(token, SUBJECT_ISSUER_GOOGLE);
    }

    public Single<AuthorizationResponse> loginWithFacebook(String token) {
        return socialLogin(token, SUBJECT_ISSUER_FACEBOOK);
    }

    private Single<AuthorizationResponse> socialLogin(String token, String issuer) {
        Map<String, String> fields = new ArrayMap<>();
        fields.put(FIELD_CLIENT_ID, BuildConfig.AUTHORIZATION_CLIENT_ID);
        fields.put(FIELD_GRANT_TYPE, GRANT_TYPE_TOKEN_EXCHANGE);
        fields.put(FIELD_SUBJECT_ISSUER, issuer);
        fields.put(FIELD_SUBJECT_TOKEN_TYPE, SUBJECT_TOKEN_TYPE_ACCESS_TOKEN);
        fields.put(FIELD_SUBJECT_TOKEN, token);
        return serverApi.tokenEndpoint(fields)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Completable logout(String refresh_token) {
        Map<String, String> fields = new ArrayMap<>();
        fields.put(FIELD_CLIENT_ID, BuildConfig.AUTHORIZATION_CLIENT_ID);
        fields.put(FIELD_REFRESH_TOKEN, refresh_token);
        return serverApi.logout(fields)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
