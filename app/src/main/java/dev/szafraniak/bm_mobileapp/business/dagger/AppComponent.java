package dev.szafraniak.bm_mobileapp.business.dagger;

import javax.inject.Singleton;

import dagger.Component;
import dev.szafraniak.bm_mobileapp.business.http.OkHttpClientModule;
import dev.szafraniak.bm_mobileapp.business.http.RetrofitModule;
import dev.szafraniak.bm_mobileapp.business.http.api.ServerApiModule;
import dev.szafraniak.bm_mobileapp.business.http.interceptors.AuthInterceptor;
import dev.szafraniak.bm_mobileapp.business.http.interceptors.TokenAuthenticator;
import dev.szafraniak.bm_mobileapp.business.http.service.AuthorizationService;
import dev.szafraniak.bm_mobileapp.business.http.service.HelloService;
import dev.szafraniak.bm_mobileapp.business.http.service.ServicesModule;
import dev.szafraniak.bm_mobileapp.business.memory.MemoryManagementModule;
import dev.szafraniak.bm_mobileapp.business.memory.SessionManager;
import dev.szafraniak.bm_mobileapp.presentation.login.LoginActivity;
import dev.szafraniak.bm_mobileapp.presentation.login.LoginActivityPresenterModule;
import dev.szafraniak.bm_mobileapp.presentation.login.LoginPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.activity.MenuActivity;
import dev.szafraniak.bm_mobileapp.presentation.menu.activity.MenuActivityPresenterModule;
import dev.szafraniak.bm_mobileapp.presentation.menu.activity.MenuPresenter;

@Singleton
@Component(modules = {
        AppModule.class, MemoryManagementModule.class, OkHttpClientModule.class,
        ServerApiModule.class, RetrofitModule.class, ServicesModule.class,
        LoginActivityPresenterModule.class, MenuActivityPresenterModule.class
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
}
