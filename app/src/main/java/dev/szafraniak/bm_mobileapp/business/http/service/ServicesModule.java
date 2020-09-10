package dev.szafraniak.bm_mobileapp.business.http.service;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {

    @Provides
    @Singleton
    public UserService provideUserService(Application app) {
        return new UserService(app);
    }

    @Provides
    @Singleton
    public CompanyService provideCompanyService(Application app) {
        return new CompanyService(app);
    }

    @Provides
    @Singleton
    public ProductService provideProductService(Application app) {
        return new ProductService(app);
    }

    @Provides
    @Singleton
    public ContactsService provideContactService(Application app) {
        return new ContactsService(app);
    }

    @Provides
    @Singleton
    public ProductModelService provideProductModelService(Application app) {
        return new ProductModelService(app);
    }

    @Provides
    @Singleton
    public ServiceModelService provideServiceModelService(Application app) {
        return new ServiceModelService(app);
    }

}
