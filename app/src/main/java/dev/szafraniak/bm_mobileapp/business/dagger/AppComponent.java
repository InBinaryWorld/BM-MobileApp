package dev.szafraniak.bm_mobileapp.business.dagger;

import javax.inject.Singleton;

import dagger.Component;
import dev.szafraniak.bm_mobileapp.business.http.GsonModule;
import dev.szafraniak.bm_mobileapp.business.http.OkHttpClientModule;
import dev.szafraniak.bm_mobileapp.business.http.RetrofitModule;
import dev.szafraniak.bm_mobileapp.business.http.api.ServerApiModule;
import dev.szafraniak.bm_mobileapp.business.http.interceptors.AuthInterceptor;
import dev.szafraniak.bm_mobileapp.business.http.interceptors.TokenAuthenticator;
import dev.szafraniak.bm_mobileapp.business.http.service.BankAccountService;
import dev.szafraniak.bm_mobileapp.business.http.service.CompanyService;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.http.service.FinancesService;
import dev.szafraniak.bm_mobileapp.business.http.service.InvoiceService;
import dev.szafraniak.bm_mobileapp.business.http.service.ProductModelService;
import dev.szafraniak.bm_mobileapp.business.http.service.ProductService;
import dev.szafraniak.bm_mobileapp.business.http.service.ServiceModelService;
import dev.szafraniak.bm_mobileapp.business.http.service.ServicesModule;
import dev.szafraniak.bm_mobileapp.business.http.service.StatisticsService;
import dev.szafraniak.bm_mobileapp.business.http.service.UserService;
import dev.szafraniak.bm_mobileapp.business.http.service.WarehouseService;
import dev.szafraniak.bm_mobileapp.business.http.service.auth.AuthModule;
import dev.szafraniak.bm_mobileapp.business.http.service.auth.AuthorizationService;
import dev.szafraniak.bm_mobileapp.business.http.service.auth.LoginService;
import dev.szafraniak.bm_mobileapp.business.memory.MemoryManagementModule;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsManager;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsPreferences;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionPreferences;
import dev.szafraniak.bm_mobileapp.business.memory.settings.SettingsPreferences;
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
import dev.szafraniak.bm_mobileapp.presentation.menu.bank.BankAccountListFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.bank.BankAccountListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.bank.create.BankAccountCreateFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.bank.create.BankAccountCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.bank.modify.BankAccountModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.bank.modify.BankAccountModifyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.company.modify.ModifyCompanyFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.company.modify.ModifyCompanyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.ContactListFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.ContactListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details.CompanyContactDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details.CompanyContactDetailsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify.CompanyContactModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify.CompanyContactModifyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.create.ContactCreateFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.create.ContactCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details.IndividualContactDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details.IndividualContactDetailsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify.IndividualContactModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify.IndividualContactModifyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.dashboard.DashboardFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.dashboard.DashboardPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.FinancialEventListFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.FinancialEventListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.create.FinancesEventCreateFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.create.FinancesEventCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.modify.FinancesEventModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.modify.FinancesEventModifyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.InvoicesFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.InvoicesPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.CreateInvoiceBaseDataFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.CreateInvoiceBaseDataPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact.InvoiceContactFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact.InvoiceContactPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.CreateInvoiceItemFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.InvoiceCreateItemFormPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.CreateInvoiceItemsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.CreateInvoicesItemsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.InvoicePaymentFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.InvoicePaymentPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details.InvoiceDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details.InvoiceDetailsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.product.ProductListFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.product.ProductListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.product.create.ProductCreateFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.product.create.ProductCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.product.modify.ProductModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.product.modify.ProductModifyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.ProductModelListFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.ProductModelListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.create.ProductModelCreateFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.create.ProductModelCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.details.ProductModelDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.details.ProductModelDetailsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.modify.ProductModelModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.modify.ProductModelModifyPresenter;
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
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.create.WarehouseCreateFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.create.WarehouseCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details.WarehouseDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details.WarehouseDetailsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify.WarehouseModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify.WarehouseModifyPresenter;

@Singleton
@Component(modules = {
    AppModule.class, MemoryManagementModule.class, OkHttpClientModule.class,
    ServerApiModule.class, RetrofitModule.class, ServicesModule.class, GsonModule.class,
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

    void inject(ContactListPresenter contactsPresenter);

    void inject(ResourcesPresenter resourcesPresenter);

    void inject(ResourcesFragment resourcesFragment);

    void inject(ModifyCompanyFragment modifyCompanyFragment);

    void inject(ModifyCompanyPresenter modifyCompanyPresenter);

    void inject(CompanyActivityPresenter companyActivityPresenter);

    void inject(CompanyListPresenter companyListPresenter);

    void inject(CompanyListFragment companyListFragment);

    void inject(CompanyCreatePresenter companyCreatePresenter);

    void inject(CompanyCreateFragment companyCreateFragment);

    void inject(CompanyService companyService);

    void inject(ProductService productService);

    void inject(ContactsService contactsService);

    void inject(CompanyContactModifyPresenter companyContactModifyPresenter);

    void inject(CompanyContactModifyFragment companyContactModifyFragment);

    void inject(CompanyContactDetailsFragment companyContactDetailsFragment);

    void inject(CompanyContactDetailsPresenter companyContactDetailsPresenter);

    void inject(IndividualContactDetailsFragment individualContactDetailsFragment);

    void inject(IndividualContactDetailsPresenter individualContactDetailsPresenter);

    void inject(IndividualContactModifyFragment individualContactModifyFragment);

    void inject(IndividualContactModifyPresenter individualContactModifyPresenter);

    void inject(ProductModelListFragment productsListFragment);

    void inject(ProductModelListPresenter productsListPresenter);

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

    void inject(FormsManager formsManager);

    void inject(FormsPreferences formsPreferences);

    void inject(SessionPreferences sessionPreferences);

    void inject(SettingsPreferences settingsPreferences);

    void inject(CreateInvoiceBaseDataFormFragment createInvoiceBaseDataFormFragment);

    void inject(CreateInvoiceBaseDataPresenter createInvoiceBaseDataPresenter);

    void inject(InvoicePaymentPresenter invoicePaymentPresenter);

    void inject(InvoicePaymentFormFragment invoicePaymentFormFragment);

    void inject(InvoiceContactFormFragment invoiceContactFormFragment);

    void inject(InvoiceContactPresenter invoiceContactPresenter);

    void inject(CreateInvoicesItemsFragment createInvoicesItemsFragment);

    void inject(CreateInvoiceItemsPresenter createInvoiceItemsPresenter);

    void inject(InvoiceCreateItemFormPresenter invoiceCreateItemFormPresenter);

    void inject(CreateInvoiceItemFormFragment createInvoiceItemFormFragment);

    void inject(InvoiceDetailsFragment invoiceDetailsFragment);

    void inject(InvoiceDetailsPresenter invoiceDetailsPresenter);

    void inject(BankAccountListFragment bankAccountsListFragment);

    void inject(BankAccountService bankAccountService);

    void inject(BankAccountListPresenter bankAccountListPresenter);

    void inject(BankAccountCreateFragment bankAccountCreateFragment);

    void inject(BankAccountCreatePresenter bankAccountCreatePresenter);

    void inject(BankAccountModifyFragment bankAccountModifyFragment);

    void inject(BankAccountModifyPresenter bankAccountModifyPresenter);

    void inject(FinancialEventListFragment financialEventListFragment);

    void inject(FinancesService financesService);

    void inject(FinancialEventListPresenter financialEventListPresenter);

    void inject(FinancesEventCreateFragment financesEventCreateFragment);

    void inject(FinancesEventCreatePresenter financesEventCreatePresenter);

    void inject(FinancesEventModifyFragment financialEventModifyFragment);

    void inject(FinancesEventModifyPresenter financialEventModifyPresenter);

    void inject(ProductListFragment productListFragment);

    void inject(ProductListPresenter productListPresenter);

    void inject(ProductCreateFragment productCreateFragment);

    void inject(ProductCreatePresenter productCreatePresenter);

    void inject(ProductModifyFragment productModifyFragment);

    void inject(ProductModifyPresenter productModifyPresenter);

    void inject(StatisticsService statisticsService);

    void inject(ContactListFragment contactListFragment);

    void inject(ContactCreateFragment contactCreateFragment);

    void inject(ContactCreatePresenter contactCreatePresenter);
}
