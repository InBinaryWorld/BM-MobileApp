package dev.szafraniak.bm_mobileapp.presentation.menu.company;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CompanyPresenterModule {
    @Provides
    @Singleton
    public CompanyPresenter provideCompanyPresenter(Application app) {
        return new CompanyPresenter(app);
    }
}
