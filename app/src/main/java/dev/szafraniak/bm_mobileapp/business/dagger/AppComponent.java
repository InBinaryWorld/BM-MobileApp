package dev.szafraniak.bm_mobileapp.business.dagger;

import javax.inject.Singleton;

import dagger.Component;
import dev.szafraniak.bm_mobileapp.business.http.OkHttpClientModule;
import dev.szafraniak.bm_mobileapp.business.http.RetrofitModule;
import dev.szafraniak.bm_mobileapp.business.http.api.ServerApiModule;
import dev.szafraniak.bm_mobileapp.business.http.service.AuthorizationService;
import dev.szafraniak.bm_mobileapp.business.http.service.HelloService;
import dev.szafraniak.bm_mobileapp.business.http.service.ServicesModule;
import dev.szafraniak.bm_mobileapp.business.memory.PreferencesModule;
import dev.szafraniak.bm_mobileapp.presentation.ViewPresenterModule;
import dev.szafraniak.bm_mobileapp.presentation.login.LoginActivity;
import dev.szafraniak.bm_mobileapp.presentation.login.LoginPresenter;

@Singleton
@Component(modules = {
        AppModule.class, PreferencesModule.class, OkHttpClientModule.class,
        ServerApiModule.class, RetrofitModule.class, ServicesModule.class,
        ViewPresenterModule.class
})
public interface AppComponent {

    void inject(LoginActivity loginActivity);

    void inject(HelloService helloService);

    void inject(LoginPresenter loginPresenter);

    void inject(AuthorizationService authorizationService);
}
