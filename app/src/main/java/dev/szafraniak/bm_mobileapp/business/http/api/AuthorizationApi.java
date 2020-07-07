package dev.szafraniak.bm_mobileapp.business.http.api;

import java.util.Map;

import dev.szafraniak.bm_mobileapp.business.entity.AuthorizationResponse;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthorizationApi {

    @FormUrlEncoded
    @POST("/token/google/exchange")
    Single<AuthorizationResponse> exchangeGoogleToken(@FieldMap Map<String, String> fields);

    @FormUrlEncoded
    @POST("/token/facebook/exchange")
    Single<AuthorizationResponse> exchangeFacebookToken(@FieldMap Map<String, String> fields);

    @FormUrlEncoded
    @POST("/token/refresh")
    Call<AuthorizationResponse> refreshToken(@FieldMap Map<String, String> fields);

}
