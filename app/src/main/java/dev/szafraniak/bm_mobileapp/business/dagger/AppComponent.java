package dev.szafraniak.bm_mobileapp.business.dagger;

import javax.inject.Singleton;

import dagger.Component;
import dev.szafraniak.bm_mobileapp.business.http.OkHttpClientModule;
import dev.szafraniak.bm_mobileapp.business.http.RetrofitModule;
import dev.szafraniak.bm_mobileapp.business.http.api.ServerApiModule;
import dev.szafraniak.bm_mobileapp.business.http.interceptors.AuthInterceptor;
import dev.szafraniak.bm_mobileapp.business.http.interceptors.TokenAuthenticator;
import dev.szafraniak.bm_mobileapp.business.http.service.HelloService;
import dev.szafraniak.bm_mobileapp.business.http.service.ServicesModule;
import dev.szafraniak.bm_mobileapp.business.http.service.auth.AuthModule;
import dev.szafraniak.bm_mobileapp.business.http.service.auth.AuthorizationService;
import dev.szafraniak.bm_mobileapp.business.http.service.auth.LoginService;
import dev.szafraniak.bm_mobileapp.business.memory.MemoryManagementModule;
import dev.szafraniak.bm_mobileapp.business.memory.SessionManager;
import dev.szafraniak.bm_mobileapp.presentation.BaseActivity;
import dev.szafraniak.bm_mobileapp.presentation.login.LoginActivity;
import dev.szafraniak.bm_mobileapp.presentation.login.LoginActivityPresenterModule;
import dev.szafraniak.bm_mobileapp.presentation.login.LoginPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.activity.MenuActivity;
import dev.szafraniak.bm_mobileapp.presentation.menu.activity.MenuPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.activity.MenuPresenterModule;
import dev.szafraniak.bm_mobileapp.presentation.menu.company.CompanyFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.company.CompanyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.company.CompanyPresenterModule;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.ContactsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.ContactsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.ContactsPresenterModule;
import dev.szafraniak.bm_mobileapp.presentation.menu.dashboard.DashboardFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.dashboard.DashboardPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.dashboard.DashboardPresenterModule;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.FinancesFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.FinancesPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.FinancesPresenterModule;
import dev.szafraniak.bm_mobileapp.presentation.menu.resources.ResourcesFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.resources.ResourcesPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.resources.ResourcesPresenterModule;
import dev.szafraniak.bm_mobileapp.presentation.menu.settings.SettingsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.settings.SettingsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.settings.SettingsPresenterModule;

@Singleton
@Component(modules = {
        AppModule.class, MemoryManagementModule.class, OkHttpClientModule.class,
        ServerApiModule.class, RetrofitModule.class, ServicesModule.class,
        LoginActivityPresenterModule.class, MenuPresenterModule.class,
        AuthModule.class, DashboardPresenterModule.class, SettingsPresenterModule.class,
        ContactsPresenterModule.class, ResourcesPresenterModule.class,
        FinancesPresenterModule.class, CompanyPresenterModule.class
})
public interface AppComponent {

    void inject(LoginActivity loginActivity);

    void inject(HelloService helloService);

    void inject(LoginPresenter loginPresenter);

    void inject(AuthorizationService authorizationService);

    void inject(TokenAuthenticator tokenAuthenticator);

    void inject(AuthInterceptor authenticationInterceptor);

    void inject(SessionManager sessionManager);

    void inject(MenuActivity menuActivity);

    void inject(MenuPresenter menuPresenter);

    void inject(DashboardPresenter dashboardPresenter);

    void inject(LoginService socialLoginService);

    void inject(DashboardFragment dashboardFragment);

    void inject(BaseActivity activity);

    void inject(SettingsFragment settingsFragment);

    void inject(SettingsPresenter settingsPresenter);

    void inject(ContactsPresenter contactsPresenter);

    void inject(ContactsFragment contactsFragment);

    void inject(ResourcesPresenter resourcesPresenter);

    void inject(ResourcesFragment resourcesFragment);

    void inject(FinancesPresenter financesPresenter);

    void inject(FinancesFragment financesFragment);

    void inject(CompanyFragment companyFragment);

    void inject(CompanyPresenter companyPresenter);
}
