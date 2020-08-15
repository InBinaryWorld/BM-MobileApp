package dev.szafraniak.bm_mobileapp.business.http.api;


import dev.szafraniak.bm_mobileapp.business.models.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import dev.szafraniak.bm_mobileapp.business.models.entity.user.User;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BmResourcesApi {

    @GET("/api/user")
    Observable<User> getUser();

    @GET("/api/companies")
    Observable<BMCollection<Company>> getCompanies();

    @POST("/api/companies")
    Observable<Company> createCompany(@Body CreateCompanyRequest requestBody);

    @GET("/api/companies/{companyId}/products")
    Observable<BMCollection<Product>> getProducts(@Path("companyId") Long companyId);

}
