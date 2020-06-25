package dev.szafraniak.bm_mobileapp.business.models;

import dev.szafraniak.bm_mobileapp.business.entity.AuthorizationResponse;

public interface LoginCallback {
    void onSuccess(AuthorizationResponse authorizationResponse);

    void onFailed(Exception e);

    void onSilentFailed(Exception e);
}
