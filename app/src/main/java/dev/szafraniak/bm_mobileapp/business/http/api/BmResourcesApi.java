package dev.szafraniak.bm_mobileapp.business.http.api;


import dev.szafraniak.bm_mobileapp.business.models.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.user.User;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface BmResourcesApi {

    @GET("user")
    Observable<User> getUser();

    @GET("companies")
    Observable<BMCollection<Company>> getCompanies();

}
