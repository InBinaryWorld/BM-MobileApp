package dev.szafraniak.bm_mobileapp.business.http.api;


import dev.szafraniak.bm_mobileapp.business.models.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.CreateBankAccountRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.UpdateBankAccountRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.UpdateCompanyRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.UpdateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.UpdateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.CreateInvoiceRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.UpdateInvoiceRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.CreateProductModelRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.UpdateProductModelRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.CreateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.UpdateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.user.User;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.CreateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.UpdateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BmResourcesApi {

    @GET("/api/user")
    Observable<User> getUser();

    //    ###########  COMPANY  ##########

    @GET("/api/companies")
    Observable<BMCollection<Company>> getCompanies();

    @GET("/api/companies/{companyId}")
    Observable<Company> getCompany(@Path("companyId") Long companyId);

    @POST("/api/companies")
    Observable<Company> createCompany(@Body CreateCompanyRequest requestBody);

    @PUT("/api/companies/{companyId}")
    Observable<Company> modifyCompany(@Path("companyId") Long companyId,
                                      @Body UpdateCompanyRequest requestBody);

    //    ###########  PRODUCT  ##########

    @GET("/api/companies/{companyId}/products")
    Observable<BMCollection<Product>> getProducts(@Path("companyId") Long companyId);

    //    ###########  PRODUCT MODEL  ##########

    @GET("/api/companies/{companyId}/products/models")
    Observable<BMCollection<ProductModel>> getProductModels(@Path("companyId") Long companyId);

    @GET("/api/companies/{companyId}/products/models/{productModelId}")
    Observable<ProductModel> getProductModel(@Path("companyId") Long companyId,
                                             @Path("productModelId") Long productModelId);

    @POST("/api/companies/{companyId}/products/models")
    Observable<ProductModel> createProductModel(@Path("companyId") Long companyId,
                                                @Body CreateProductModelRequest model);

    @PUT("/api/companies/{companyId}/products/models/{productModelId}")
    Observable<ProductModel> modifyProductModel(@Path("companyId") Long companyId,
                                                @Path("productModelId") Long productModelId,
                                                @Body UpdateProductModelRequest model);

    //    ###########  SERVICE MODEL  ##########

    @GET("/api/companies/{companyId}/services/models")
    Observable<BMCollection<ServiceModel>> getServiceModels(@Path("companyId") Long companyId);

    @GET("/api/companies/{companyId}/services/models/{serviceModelId}")
    Observable<ServiceModel> getServiceModel(@Path("companyId") Long companyId,
                                             @Path("serviceModelId") Long serviceModelId);

    @POST("/api/companies/{companyId}/services/models")
    Observable<ServiceModel> createServiceModel(@Path("companyId") Long companyId,
                                                @Body CreateServiceModelRequest model);

    @PUT("/api/companies/{companyId}/services/models/{serviceModelId}")
    Observable<ServiceModel> modifyServiceModel(@Path("companyId") Long companyId,
                                                @Path("serviceModelId") Long serviceModelId,
                                                @Body UpdateServiceModelRequest model);

    //    ###########  COMPANY CONTACT  ##########

    @GET("/api/companies/{companyId}/contacts/company")
    Observable<BMCollection<CompanyContact>> getCompanyContacts(@Path("companyId") Long companyId);

    @GET("/api/companies/{companyId}/contacts/company/{contactId}")
    Observable<CompanyContact> getCompanyContact(@Path("companyId") Long companyId,
                                                 @Path("contactId") Long contactId);

    @POST("/api/companies/{companyId}/contacts/company")
    Observable<CompanyContact> createCompanyContact(@Path("companyId") Long companyId,
                                                    @Body CreateCompanyContactRequest requestBody);

    @PUT("/api/companies/{companyId}/contacts/company/{contactId}")
    Observable<CompanyContact> updateCompanyContact(@Path("companyId") Long companyId,
                                                    @Path("contactId") Long contactId,
                                                    @Body UpdateCompanyContactRequest requestBody);

    //    ###########  INDIVIDUAL CONTACT  ##########

    @GET("/api/companies/{companyId}/contacts/individual")
    Observable<BMCollection<IndividualContact>> getIndividualContacts(@Path("companyId") Long companyId);

    @GET("/api/companies/{companyId}/contacts/individual/{contactId}")
    Observable<IndividualContact> getIndividualContact(@Path("companyId") Long companyId,
                                                       @Path("contactId") Long contactId);

    @POST("/api/companies/{companyId}/contacts/individual")
    Observable<IndividualContact> createIndividualContact(@Path("companyId") Long companyId,
                                                          @Body CreateIndividualContactRequest request);

    @PUT("/api/companies/{companyId}/contacts/individual/{contactId}")
    Observable<IndividualContact> updateIndividualContact(@Path("companyId") Long companyId,
                                                          @Path("contactId") Long contactId,
                                                          @Body UpdateIndividualContactRequest requestBody);

    //    ###########  WAREHOUSE  ##########

    @GET("/api/companies/{companyId}/warehouses")
    Observable<BMCollection<Warehouse>> getWarehouses(@Path("companyId") Long companyId);

    @GET("/api/companies/{companyId}/warehouses/{warehouseId}")
    Observable<Warehouse> getWarehouse(@Path("companyId") Long companyId,
                                       @Path("warehouseId") Long warehouseId);

    @POST("/api/companies/{companyId}/warehouses")
    Observable<Warehouse> createWarehouse(@Path("companyId") Long companyId,
                                          @Body CreateWarehouseRequest request);

    @PUT("/api/companies/{companyId}/warehouses/{warehouseId}")
    Observable<Warehouse> modifyWarehouse(@Path("companyId") Long companyId,
                                          @Path("warehouseId") Long warehouseId,
                                          @Body UpdateWarehouseRequest requestBody);

    //    ###########  INVOICE  ##########

    @GET("/api/companies/{companyId}/invoices")
    Observable<BMCollection<Invoice>> getInvoices(@Path("companyId") Long companyId);

    @GET("/api/companies/{companyId}/invoices/{invoiceId}")
    Observable<Invoice> getInvoice(@Path("companyId") Long companyId,
                                   @Path("invoiceId") Long invoiceId);

    @Headers("Accept: application/pdf")
    @GET("/api/companies/{companyId}/invoices/{invoiceId}/document")
    Observable<ResponseBody> getInvoiceDocument(@Path("companyId") Long companyId,
                                                @Path("invoiceId") Long invoiceId);

    @POST("/api/companies/{companyId}/invoices")
    Observable<Invoice> createInvoice(@Path("companyId") Long companyId,
                                      @Body CreateInvoiceRequest request);

    @PUT("/api/companies/{companyId}/invoices/{invoiceId}")
    Observable<Invoice> modifyInvoice(@Path("companyId") Long companyId,
                                      @Path("invoiceId") Long invoiceId,
                                      @Body UpdateInvoiceRequest requestBody);

    //    ###########  BANK ACCOUNT  ##########

    @GET("/api/companies/{companyId}/bank/accounts")
    Observable<BMCollection<BankAccount>> getBankAccounts(@Path("companyId") Long companyId);

    @GET("/api/companies/{companyId}/bank/accounts/{accountId}")
    Observable<BankAccount> getBankAccount(@Path("companyId") Long companyId,
                                           @Path("accountId") Long accountId);

    @PUT("/api/companies/{companyId}/bank/accounts/{accountId}")
    Observable<BankAccount> modifyBankAccount(@Path("companyId") Long companyId,
                                              @Path("accountId") Long accountId,
                                              @Body UpdateBankAccountRequest request);

    @POST("/api/companies/{companyId}/bank/accounts")
    Observable<BankAccount> createBankAccount(@Path("companyId") Long companyId,
                                              @Body CreateBankAccountRequest request);

}
