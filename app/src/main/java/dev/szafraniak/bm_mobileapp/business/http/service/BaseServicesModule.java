package dev.szafraniak.bm_mobileapp.business.http.service;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BaseServicesModule {

    @Provides
    @Singleton
    public BaseUserService provideBaseUserService(Application app) {
        return new BaseUserService(app);
    }

    @Provides
    @Singleton
    public BaseCompanyService provideBaseCompanyService(Application app) {
        return new BaseCompanyService(app);
    }

    @Provides
    @Singleton
    public BaseProductService provideBaseProductService(Application app) {
        return new BaseProductService(app);
    }

}
