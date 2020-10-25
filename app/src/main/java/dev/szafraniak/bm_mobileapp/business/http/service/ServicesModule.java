package dev.szafraniak.bm_mobileapp.business.http.service;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.szafraniak.bm_mobileapp.business.http.service.api.BankAccountService;
import dev.szafraniak.bm_mobileapp.business.http.service.api.CompanyService;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ContactsService;
import dev.szafraniak.bm_mobileapp.business.http.service.api.FinancesService;
import dev.szafraniak.bm_mobileapp.business.http.service.api.InvoiceService;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ProductModelService;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ProductService;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ServiceModelService;
import dev.szafraniak.bm_mobileapp.business.http.service.api.StatisticsService;
import dev.szafraniak.bm_mobileapp.business.http.service.api.UserService;
import dev.szafraniak.bm_mobileapp.business.http.service.api.WarehouseService;

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

    @Provides
    @Singleton
    public WarehouseService provideWarehouseService(Application app) {
        return new WarehouseService(app);
    }

    @Provides
    @Singleton
    public InvoiceService provideInvoiceService(Application app) {
        return new InvoiceService(app);
    }

    @Provides
    @Singleton
    public BankAccountService provideBankAccountService(Application app) {
        return new BankAccountService(app);
    }

    @Provides
    @Singleton
    public FinancesService provideFinancesService(Application app) {
        return new FinancesService(app);
    }

    @Provides
    @Singleton
    public StatisticsService provideStatisticsService(Application app) {
        return new StatisticsService(app);
    }

}
