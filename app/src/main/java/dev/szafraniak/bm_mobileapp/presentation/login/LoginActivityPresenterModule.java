package dev.szafraniak.bm_mobileapp.presentation.login;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityPresenterModule {

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter(Application app) {
        return new LoginPresenter(app);
    }
}
