package dev.szafraniak.bm_mobileapp.business.entity;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class AuthorizationResponse {
    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("expires_in")
    private Long expiresIn;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("refresh_expires_in")
    private String refreshTokenIn;

    @SerializedName("token_type")
    private String tokenType;
}
