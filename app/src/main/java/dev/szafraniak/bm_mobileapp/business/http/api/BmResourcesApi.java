package dev.szafraniak.bm_mobileapp.business.http.api;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BmResourcesApi {

    @GET("hello")
    Observable<String> getHello();


    @GET("api/v1/hello")
    Observable<String> getSecuredHello();

}
