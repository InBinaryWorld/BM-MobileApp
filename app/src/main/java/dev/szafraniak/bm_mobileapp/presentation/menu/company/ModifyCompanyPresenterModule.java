package dev.szafraniak.bm_mobileapp.presentation.menu.company;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ModifyCompanyPresenterModule {
    @Provides
    @Singleton
    public ModifyCompanyPresenter provideCompanyPresenter(Application app) {
        return new ModifyCompanyPresenter(app);
    }
}
