package dev.szafraniak.bm_mobileapp.presentation.company.activity;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CompanyActivityPresenterModule {

    @Provides
    @Singleton
    public CompanyActivityPresenter provideLoginPresenter(Application app) {
        return new CompanyActivityPresenter(app);
    }
}
