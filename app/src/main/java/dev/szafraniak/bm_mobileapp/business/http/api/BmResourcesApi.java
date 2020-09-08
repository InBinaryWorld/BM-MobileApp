package dev.szafraniak.bm_mobileapp.business.http.api;


import dev.szafraniak.bm_mobileapp.business.models.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.UpdateCompanyRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.UpdateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.UpdateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import dev.szafraniak.bm_mobileapp.business.models.entity.user.User;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BmResourcesApi {

    @GET("/api/user")
    Observable<User> getUser();

    @GET("/api/companies")
    Observable<BMCollection<Company>> getCompanies();

    @POST("/api/companies")
    Observable<Company> createCompany(@Body CreateCompanyRequest requestBody);

    @PUT("/api/companies/{companyId}")
    Observable<Company> modifyCompany(@Path("companyId") Long companyId,
                                      @Body UpdateCompanyRequest requestBody);

    @GET("/api/companies/{companyId}/products")
    Observable<BMCollection<Product>> getProducts(@Path("companyId") Long companyId);

    @GET("/api/companies/{companyId}/contacts/company")
    Observable<BMCollection<CompanyContact>> getCompanyContacts(@Path("companyId") Long companyId);

    @POST("/api/companies/{companyId}/contacts/company")
    Observable<CompanyContact> createCompanyContact(@Path("companyId") Long companyId,
                                                    @Body CreateCompanyContactRequest requestBody);

    @PUT("/api/companies/{companyId}/contacts/company/{contactId}")
    Observable<CompanyContact> updateCompanyContact(@Path("companyId") Long companyId,
                                                    @Path("contactId") Long contactId,
                                                    @Body UpdateCompanyContactRequest requestBody);

    @GET("/api/companies/{companyId}/contacts/individual")
    Observable<BMCollection<IndividualContact>> getIndividualContacts(@Path("companyId") Long companyId);

    @POST("/api/companies/{companyId}/contacts/individual")
    Observable<IndividualContact> createIndividualContact(@Path("companyId") Long companyId,
                                                          @Body CreateIndividualContactRequest request);

    @PUT("/api/companies/{companyId}/contacts/individual/{contactId}")
    Observable<IndividualContact> updateIndividualContact(@Path("companyId") Long companyId,
                                                          @Path("contactId") Long contactId,
                                                          @Body UpdateIndividualContactRequest requestBody);

}
