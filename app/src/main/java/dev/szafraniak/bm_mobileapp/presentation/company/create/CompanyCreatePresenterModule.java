package dev.szafraniak.bm_mobileapp.presentation.company.create;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CompanyCreatePresenterModule {

    @Provides
    @Singleton
    public CompanyCreatePresenter provideContactsPresenter(Application app) {
        return new CompanyCreatePresenter(app);
    }
}
