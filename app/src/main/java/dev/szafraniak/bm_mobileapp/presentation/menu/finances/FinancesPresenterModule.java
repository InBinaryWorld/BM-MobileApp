package dev.szafraniak.bm_mobileapp.presentation.menu.finances;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FinancesPresenterModule {
    @Provides
    @Singleton
    public FinancesPresenter provideFinancesPresenter(Application app) {
        return new FinancesPresenter(app);
    }
}
