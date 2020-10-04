package dev.szafraniak.bm_mobileapp.presentation.menu;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.szafraniak.bm_mobileapp.presentation.menu.activity.MenuPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.company.modify.ModifyCompanyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.ContactsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.CompanyContactListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create.CompanyContactCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details.CompanyContactDetailsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify.CompanyContactModifyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.IndividualContactListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create.IndividualContactCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details.IndividualContactDetailsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify.IndividualContactModifyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.dashboard.DashboardPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.FinancesPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.InvoicesPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.CreateInvoiceBaseDataPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.InvoicePaymentPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.ProductsListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.create.ProductModelCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.details.ProductModelDetailsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.modify.ProductModelModifyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.resources.ResourcesPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.ServiceModelListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.create.ServiceModelCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.details.ServiceModelDetailsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.services.modify.ServiceModelModifyPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.settings.SettingsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.WarehouseListPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.create.WarehouseCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details.WarehouseDetailsPresenter;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify.WarehouseModifyPresenter;

@Module
public class MenuModule {

    @Provides
    @Singleton
    public MenuPresenter provideMenuPresenter(Application app) {
        return new MenuPresenter(app);
    }

    @Provides
    @Singleton
    public ModifyCompanyPresenter provideCompanyPresenter(Application app) {
        return new ModifyCompanyPresenter(app);
    }

    @Provides
    @Singleton
    public ContactsPresenter provideContactsPresenter(Application app) {
        return new ContactsPresenter(app);
    }

    @Provides
    @Singleton
    public DashboardPresenter provideDashboardPresenter(Application app) {
        return new DashboardPresenter(app);
    }

    @Provides
    @Singleton
    public FinancesPresenter provideFinancesPresenter(Application app) {
        return new FinancesPresenter(app);
    }

    @Provides
    @Singleton
    public ResourcesPresenter provideResourcesPresenter(Application app) {
        return new ResourcesPresenter(app);
    }

    @Provides
    @Singleton
    public SettingsPresenter provideSettingsPresenter(Application app) {
        return new SettingsPresenter(app);
    }

    @Provides
    @Singleton
    public IndividualContactListPresenter provideIndividualContactListPresenter(Application app) {
        return new IndividualContactListPresenter(app);
    }

    @Provides
    @Singleton
    public CompanyContactListPresenter provideCompanyContactListPresenter(Application app) {
        return new CompanyContactListPresenter(app);
    }

    @Provides
    @Singleton
    public CompanyContactCreatePresenter provideCompanyContactCreatePresenter(Application app) {
        return new CompanyContactCreatePresenter(app);
    }

    @Provides
    @Singleton
    public IndividualContactCreatePresenter provideIndividualContactCreatePresenter(Application app) {
        return new IndividualContactCreatePresenter(app);
    }

    @Provides
    @Singleton
    public CompanyContactModifyPresenter provideCompanyContactModifyPresenter(Application app) {
        return new CompanyContactModifyPresenter(app);
    }

    @Provides
    @Singleton
    public CompanyContactDetailsPresenter provideCompanyContactDetailsPresenter(Application app) {
        return new CompanyContactDetailsPresenter(app);
    }

    @Provides
    @Singleton
    public IndividualContactDetailsPresenter provideIndividualContactDetailsPresenter(Application app) {
        return new IndividualContactDetailsPresenter(app);
    }

    @Provides
    @Singleton
    public IndividualContactModifyPresenter provideIndividualContactModifyPresenter(Application app) {
        return new IndividualContactModifyPresenter(app);
    }

    @Provides
    @Singleton
    public ProductsListPresenter provideProductsListPresenter(Application app) {
        return new ProductsListPresenter(app);
    }

    @Provides
    @Singleton
    public ProductModelModifyPresenter provideProductModelModifyPresenter(Application app) {
        return new ProductModelModifyPresenter(app);
    }

    @Provides
    @Singleton
    public ProductModelCreatePresenter provideProductModelCreatePresenter(Application app) {
        return new ProductModelCreatePresenter(app);
    }

    @Provides
    @Singleton
    public ProductModelDetailsPresenter provideProductModelDetailsPresenter(Application app) {
        return new ProductModelDetailsPresenter(app);
    }

    @Provides
    @Singleton
    public ServiceModelListPresenter provideServiceModelListPresenter(Application app) {
        return new ServiceModelListPresenter(app);
    }

    @Provides
    @Singleton
    public ServiceModelDetailsPresenter provideServiceModelDetailsPresenter(Application app) {
        return new ServiceModelDetailsPresenter(app);
    }

    @Provides
    @Singleton
    public ServiceModelModifyPresenter provideServiceModelModifyPresenter(Application app) {
        return new ServiceModelModifyPresenter(app);
    }

    @Provides
    @Singleton
    public ServiceModelCreatePresenter provideServiceModelCreatePresenter(Application app) {
        return new ServiceModelCreatePresenter(app);
    }

    @Provides
    @Singleton
    public WarehouseListPresenter provideWarehouseListPresenter(Application app) {
        return new WarehouseListPresenter(app);
    }

    @Provides
    @Singleton
    public WarehouseCreatePresenter provideWarehouseCreatePresenter(Application app) {
        return new WarehouseCreatePresenter(app);
    }

    @Provides
    @Singleton
    public WarehouseModifyPresenter provideWarehouseModifyPresenter(Application app) {
        return new WarehouseModifyPresenter(app);
    }

    @Provides
    @Singleton
    public WarehouseDetailsPresenter provideWarehouseDetailsPresenter(Application app) {
        return new WarehouseDetailsPresenter(app);
    }

    @Provides
    @Singleton
    public InvoicesPresenter provideInvoicesPresenter(Application app) {
        return new InvoicesPresenter(app);
    }

    @Provides
    @Singleton
    public CreateInvoiceBaseDataPresenter provideCreateInvoiceBaseDataPresenter(Application app) {
        return new CreateInvoiceBaseDataPresenter(app);
    }

    @Provides
    @Singleton
    public InvoicePaymentPresenter provideInvoicePaymentPresenter(Application app) {
        return new InvoicePaymentPresenter(app);
    }

}
