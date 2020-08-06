package dev.szafraniak.bm_mobileapp.business.http.api;


import dev.szafraniak.bm_mobileapp.business.models.User;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BmResourcesApi {

    @GET("user")
    Observable<User> getUser();

}
