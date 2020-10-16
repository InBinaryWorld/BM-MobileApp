package dev.szafraniak.bm_mobileapp.business.http;


import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import timber.log.Timber;

public class HttpUtils {
    private static final String AUTHORIZATION_KEY = "Authorization";

    public static Request addAuthToRequest(Request request, String authValue) {
        return request.newBuilder()
            .header(AUTHORIZATION_KEY, authValue)
            .build();
    }

    public static <T> T executeCall(Call<T> request) {
        try {
            Response<T> response = request.execute();
            if (response.isSuccessful())
                return response.body();
            Timber.e(String.valueOf(response.errorBody()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
