package dev.szafraniak.bm_mobileapp.presentation.company;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.szafraniak.bm_mobileapp.presentation.company.activity.CompanyActivityPresenter;
import dev.szafraniak.bm_mobileapp.presentation.company.create.CompanyCreatePresenter;
import dev.szafraniak.bm_mobileapp.presentation.company.list.CompanyListPresenter;

@Module
public class CompanyActivityModule {

    @Provides
    @Singleton
    public CompanyActivityPresenter provideCompanyActivityPresenter(Application app) {
        return new CompanyActivityPresenter(app);
    }

    @Provides
    @Singleton
    public CompanyCreatePresenter provideCompanyCreatePresenter(Application app) {
        return new CompanyCreatePresenter(app);
    }

    @Provides
    @Singleton
    public CompanyListPresenter provideCompanyListPresenter(Application app) {
        return new CompanyListPresenter(app);
    }
}
