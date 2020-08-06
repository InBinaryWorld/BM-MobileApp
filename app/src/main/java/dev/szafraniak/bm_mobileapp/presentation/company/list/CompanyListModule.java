package dev.szafraniak.bm_mobileapp.presentation.company.list;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CompanyListModule {

    @Provides
    @Singleton
    public CompanyListPresenter provideContactsPresenter(Application app) {
        return new CompanyListPresenter(app);
    }
}
