package dev.szafraniak.bm_mobileapp.business.http.api;

import java.util.Map;

import dev.szafraniak.bm_mobileapp.business.entity.AuthorizationResponse;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthorizationServerApi {

    @FormUrlEncoded
    @POST("/auth/realms/base/protocol/openid-connect/token")
    Observable<AuthorizationResponse> login(@FieldMap Map<String, String> fields);

}
