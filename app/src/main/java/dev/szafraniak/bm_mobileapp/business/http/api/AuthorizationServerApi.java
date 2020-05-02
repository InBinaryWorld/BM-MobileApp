package dev.szafraniak.bm_mobileapp.business.http.api;

import java.util.Map;

import dev.szafraniak.bm_mobileapp.business.entity.AuthorizationResponse;
import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthorizationServerApi {

    @FormUrlEncoded
    @POST("/auth/realms/base/protocol/openid-connect/token")
    Single<AuthorizationResponse> tokenEndpoint(@FieldMap Map<String, String> fields);

    @FormUrlEncoded
    @POST("/auth/realms/base/protocol/openid-connect/token")
    Call<AuthorizationResponse> syncTokenEndpoint(@FieldMap Map<String, String> fields);

    @FormUrlEncoded
    @POST("/auth/realms/base/protocol/openid-connect/logout")
    Completable logout(@FieldMap Map<String, String> fields);

}
