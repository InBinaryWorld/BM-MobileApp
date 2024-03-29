package dev.szafraniak.bm_mobileapp.business.http.api;


import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.CreateBankAccountRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.UpdateBankAccountRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.UpdateCompanyRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.UpdateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.CreateFinancialRowRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.FinancialRow;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.UpdateFinancialRowRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.UpdateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.CreateInvoiceRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.CreateProductRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.UpdateProductRequest;
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
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.stats.CompanyStatsModel;
import dev.szafraniak.bm_mobileapp.business.models.stats.FinancesStatsModel;
import dev.szafraniak.bm_mobileapp.business.models.stats.InvoicesStatsModel;
import dev.szafraniak.bm_mobileapp.business.models.stats.ResourcesStatsModel;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

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

    @DELETE("/api/companies/{companyId}")
    Observable<Response<Void>> deleteCompany(@Path("companyId") Long companyId);


    //    ###########  PRODUCT  ##########

    @GET("/api/companies/{companyId}/products")
    Observable<BMCollection<Product>> getProducts(@Path("companyId") Long companyId,
                                                  @Query("warehouseId") Long warehouseId,
                                                  @Query("productModelId") Long productModelId);

    @GET("/api/companies/{companyId}/products/{productId}")
    Observable<Product> getProduct(@Path("companyId") Long companyId, @Path("productId") Long productId);

    @POST("/api/companies/{companyId}/products")
    Observable<Product> createProduct(@Path("companyId") Long companyId, @Body CreateProductRequest request);

    @PUT("/api/companies/{companyId}/products/{productId}")
    Observable<Product> modifyProduct(@Path("companyId") Long companyId,
                                      @Path("productId") Long productId,
                                      @Body UpdateProductRequest request);

    @DELETE("/api/companies/{companyId}/products/{productId}")
    Observable<Response<Void>> deleteProduct(@Path("companyId") Long companyId,
                                             @Path("productId") Long productId);


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

    @DELETE("/api/companies/{companyId}/products/models/{productModelId}")
    Observable<Response<Void>> deleteProductModel(@Path("companyId") Long companyId,
                                                  @Path("productModelId") Long productModelId);


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

    @DELETE("/api/companies/{companyId}/services/models/{serviceModelId}")
    Observable<Response<Void>> deleteServiceModel(@Path("companyId") Long companyId,
                                                  @Path("serviceModelId") Long serviceModelId);

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

    @DELETE("/api/companies/{companyId}/contacts/company/{contactId}")
    Observable<Response<Void>> deleteCompanyContact(@Path("companyId") Long companyId,
                                                    @Path("contactId") Long contactId);

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

    @DELETE("/api/companies/{companyId}/contacts/individual/{contactId}")
    Observable<Response<Void>> deleteIndividualContact(@Path("companyId") Long companyId,
                                                       @Path("contactId") Long contactId);

    //    ###########  WAREHOUSE  ##########

    @GET("/api/companies/{companyId}/warehouses")
    Observable<BMCollection<Warehouse>> getWarehouses(@Path("companyId") Long companyId);

    @GET("/api/companies/{companyId}/warehouses/{warehouseId}")
    Observable<Warehouse> getWarehouse(@Path("companyId") Long companyId,
                                       @Path("warehouseId") Long warehouseId);

    @DELETE("/api/companies/{companyId}/warehouses/{warehouseId}")
    Observable<Response<Void>> deleteWarehouse(@Path("companyId") Long companyId,
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

    @PUT("/api/companies/{companyId}/invoices/{invoiceId}/action/paid")
    Observable<Invoice> paidOffAction(@Path("companyId") Long companyId,
                                      @Path("invoiceId") Long invoiceId);

    @DELETE("/api/companies/{companyId}/invoices/{invoiceId}")
    Observable<Response<Void>> deleteInvoice(@Path("companyId") Long companyId,
                                             @Path("invoiceId") Long invoiceId);


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

    @DELETE("/api/companies/{companyId}/bank/accounts/{accountId}")
    Observable<Response<Void>> deleteBankAccount(@Path("companyId") Long companyId,
                                                 @Path("accountId") Long accountId);

    //    ###########  FINANCES  ##########

    @GET("/api/companies/{companyId}/finances")
    Observable<BMCollection<FinancialRow>> getFinancialEvents(@Path("companyId") Long companyId);

    @GET("/api/companies/{companyId}/finances/{eventId}")
    Observable<FinancialRow> getFinancialEvent(@Path("companyId") Long companyId,
                                               @Path("eventId") Long eventId);

    @DELETE("/api/companies/{companyId}/finances/{eventId}")
    Observable<Response<Void>> deleteFinancialEvent(@Path("companyId") Long companyId,
                                                    @Path("eventId") Long eventId);

    @PUT("/api/companies/{companyId}/finances/{eventId}")
    Observable<FinancialRow> modifyFinancialEvent(@Path("companyId") Long companyId,
                                                  @Path("eventId") Long eventId,
                                                  @Body UpdateFinancialRowRequest request);

    @POST("/api/companies/{companyId}/finances")
    Observable<FinancialRow> createFinancialEvent(@Path("companyId") Long companyId,
                                                  @Body CreateFinancialRowRequest request);

    //    ###########  STATISTICS  ##########

    @GET("/api/stats/company/{companyId}")
    Observable<CompanyStatsModel> getCompanyStats(@Path("companyId") Long companyId);

    @GET("/api/stats/company/{companyId}/finances")
    Observable<FinancesStatsModel> getFinancesStats(@Path("companyId") Long companyId);

    @GET("/api/stats/company/{companyId}/invoices")
    Observable<InvoicesStatsModel> getInvoicesStats(@Path("companyId") Long companyId);

    @GET("/api/stats/company/{companyId}/resources")
    Observable<ResourcesStatsModel> getResourcesStats(@Path("companyId") Long companyId);

}
