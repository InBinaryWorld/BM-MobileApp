package dev.szafraniak.bm_mobileapp.business.dagger;

import javax.inject.Singleton;

import dagger.Component;
import dev.szafraniak.bm_mobileapp.business.http.OkHttpClientModule;
import dev.szafraniak.bm_mobileapp.business.http.RetrofitModule;
import dev.szafraniak.bm_mobileapp.business.http.api.ServerApiModule;
import dev.szafraniak.bm_mobileapp.business.http.interceptors.AuthInterceptor;
import dev.szafraniak.bm_mobileapp.business.http.interceptors.TokenAuthenticator;
import dev.szafraniak.bm_mobileapp.business.http.service.CompanyService;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.http.service.InvoiceService;
import dev.szafraniak.bm_mobileapp.business.http.service.ProductModelService;
import dev.szafraniak.bm_mobileapp.business.http.service.ProductService;
import dev.szafraniak.bm_mobileapp.business.http.service.ServiceModelService;
import dev.szafraniak.bm_mobileapp.business.http.service.ServicesModule;
import dev.szafraniak.bm_mobileapp.business.http.service.UserService;
import dev.szafraniak.bm_mobileapp.business.http.service.WarehouseService;
import dev.szafraniak.bm_mobileapp.business.http.service.auth.AuthModule;
import dev.szafraniak.bm_mobileapp.business.http.service.auth.AuthorizationService;
import dev.szafraniak.bm_mobileapp.business.http.service.auth.LoginService;
import dev.szafraniak.bm_mobileapp.business.memory.MemoryManagementModule;
import dev.szafraniak.bm_mobileapp.business.memory.SessionManager;
import dev.szafraniak.bm_mobileapp.presentation.company.CompanyActivityModule;
import dev.szafraniak.bm_mobileapp.presentation.company.activity.CompanyActivity;
import dev.szafraniak.bm_mobileapp.presentation.company.activity.CompanyActivityPresenter;
import dev.szafraniak.bm_mobileapp.presentation.company.create.CompanyCreateFragment;
import dev.szafraniak.bm_mobileapp.presentation.company.create.CompanyCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.company.list.CompanyListFragment;
import dev.szafraniak.bm_mobileapp.presentation.company.list.CompanyListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.login.LoginActivity;
import dev.szafraniak.bm_mobileapp.presentation.login.LoginActivityPresenterModule;
import dev.szafraniak.bm_mobileapp.presentation.login.LoginPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.MenuModule;
import dev.szafraniak.bm_mobileapp.presentation.menu.activity.MenuActivity;
import dev.szafraniak.bm_mobileapp.presentation.menu.activity.MenuPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.company.ModifyCompanyFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.company.ModifyCompanyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.ContactsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.ContactsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.CompanyContactListFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.CompanyContactListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create.CompanyContactCreateFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create.CompanyContactCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details.CompanyContactDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details.CompanyContactDetailsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify.CompanyContactModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify.CompanyContactModifyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.IndividualContactListFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.IndividualContactListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create.IndividualContactCreateFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create.IndividualContactCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details.IndividualContactDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details.IndividualContactDetailsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify.IndividualContactModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify.IndividualContactModifyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.dashboard.DashboardFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.dashboard.DashboardPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.FinancesFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.FinancesPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.InvoicesFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.InvoicesPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.products.ProductsListFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.products.ProductsListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.products.create.ProductModelCreateFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.products.create.ProductModelCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.products.details.ProductModelDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.products.details.ProductModelDetailsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.products.modify.ProductModelModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.products.modify.ProductModelModifyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.resources.ResourcesFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.resources.ResourcesPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.ServiceModelListFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.ServiceModelListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.create.ServiceModelCreateFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.create.ServiceModelCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.details.ServiceModelDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.details.ServiceModelDetailsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.modify.ServiceModelModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.modify.ServiceModelModifyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.settings.SettingsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.settings.SettingsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.WarehouseListFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.WarehouseListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.create.WarehouseCreateFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.create.WarehouseCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details.WarehouseDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details.WarehouseDetailsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify.WarehouseModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify.WarehouseModifyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.shared.result.ActionStatusFragment;

@Singleton
@Component(modules = {
        AppModule.class, MemoryManagementModule.class, OkHttpClientModule.class,
        ServerApiModule.class, RetrofitModule.class, ServicesModule.class,
        LoginActivityPresenterModule.class, MenuModule.class, AuthModule.class,
        CompanyActivityModule.class
})
public interface AppComponent {

    void inject(LoginActivity loginActivity);

    void inject(CompanyActivity companyActivity);

    void inject(MenuActivity menuActivity);

    void inject(UserService userService);

    void inject(LoginPresenter loginPresenter);

    void inject(AuthorizationService authorizationService);

    void inject(TokenAuthenticator tokenAuthenticator);

    void inject(AuthInterceptor authenticationInterceptor);

    void inject(SessionManager sessionManager);

    void inject(MenuPresenter menuPresenter);

    void inject(DashboardPresenter dashboardPresenter);

    void inject(LoginService socialLoginService);

    void inject(DashboardFragment dashboardFragment);

    void inject(SettingsFragment settingsFragment);

    void inject(SettingsPresenter settingsPresenter);

    void inject(ContactsPresenter contactsPresenter);

    void inject(ContactsFragment contactsFragment);

    void inject(ResourcesPresenter resourcesPresenter);

    void inject(ResourcesFragment resourcesFragment);

    void inject(FinancesPresenter financesPresenter);

    void inject(FinancesFragment financesFragment);

    void inject(ModifyCompanyFragment modifyCompanyFragment);

    void inject(ModifyCompanyPresenter modifyCompanyPresenter);

    void inject(CompanyActivityPresenter companyActivityPresenter);

    void inject(CompanyListPresenter companyListPresenter);

    void inject(CompanyListFragment companyListFragment);

    void inject(CompanyCreatePresenter companyCreatePresenter);

    void inject(CompanyCreateFragment companyCreateFragment);

    void inject(CompanyService companyService);

    void inject(ProductService productService);

    void inject(ActionStatusFragment actionStatusFragment);

    void inject(ContactsService contactsService);

    void inject(IndividualContactListPresenter individualContactListPresenter);

    void inject(IndividualContactListFragment individualContactListFragment);

    void inject(CompanyContactListFragment companyContactListFragment);

    void inject(CompanyContactListPresenter companyContactListPresenter);

    void inject(CompanyContactCreateFragment companyContactCreateFragment);

    void inject(CompanyContactCreatePresenter companyContactCreatePresenter);

    void inject(IndividualContactCreatePresenter individualContactCreatePresenter);

    void inject(IndividualContactCreateFragment individualContactCreateFragment);

    void inject(CompanyContactModifyPresenter companyContactModifyPresenter);

    void inject(CompanyContactModifyFragment companyContactModifyFragment);

    void inject(CompanyContactDetailsFragment companyContactDetailsFragment);

    void inject(CompanyContactDetailsPresenter companyContactDetailsPresenter);

    void inject(IndividualContactDetailsFragment individualContactDetailsFragment);

    void inject(IndividualContactDetailsPresenter individualContactDetailsPresenter);

    void inject(IndividualContactModifyFragment individualContactModifyFragment);

    void inject(IndividualContactModifyPresenter individualContactModifyPresenter);

    void inject(ProductsListFragment productsListFragment);

    void inject(ProductsListPresenter productsListPresenter);

    void inject(ProductModelModifyFragment productModelModifyFragment);

    void inject(ProductModelModifyPresenter productModelModifyPresenter);

    void inject(ProductModelService productModelService);

    void inject(ProductModelCreateFragment productModelCreateFragment);

    void inject(ProductModelCreatePresenter productModelCreatePresenter);

    void inject(ProductModelDetailsFragment productModelDetailsFragment);

    void inject(ProductModelDetailsPresenter productModelDetailsPresenter);

    void inject(ServiceModelListFragment serviceModelListFragment);

    void inject(ServiceModelService serviceModelService);

    void inject(ServiceModelListPresenter serviceModelListPresenter);

    void inject(ServiceModelDetailsFragment serviceModelDetailsFragment);

    void inject(ServiceModelDetailsPresenter serviceModelDetailsPresenter);

    void inject(ServiceModelModifyFragment serviceModelModifyFragment);

    void inject(ServiceModelModifyPresenter serviceModelModifyPresenter);

    void inject(ServiceModelCreateFragment serviceModelCreateFragment);

    void inject(ServiceModelCreatePresenter serviceModelCreatePresenter);

    void inject(WarehouseListFragment warehouseListFragment);

    void inject(WarehouseListPresenter warehouseListPresenter);

    void inject(WarehouseService warehouseService);

    void inject(WarehouseCreateFragment warehouseCreateFragment);

    void inject(WarehouseCreatePresenter warehouseCreatePresenter);

    void inject(WarehouseModifyFragment warehouseModifyFragment);

    void inject(WarehouseModifyPresenter warehouseModifyPresenter);

    void inject(WarehouseDetailsFragment warehouseDetailsFragment);

    void inject(WarehouseDetailsPresenter warehouseDetailsPresenter);

    void inject(InvoicesFragment invoicesFragment);

    void inject(InvoicesPresenter invoicesPresenter);

    void inject(InvoiceService invoiceService);
}
