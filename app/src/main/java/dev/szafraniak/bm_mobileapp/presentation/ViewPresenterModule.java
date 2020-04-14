package dev.szafraniak.bm_mobileapp.presentation;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.szafraniak.bm_mobileapp.presentation.login.LoginPresenter;

@Module
public class ViewPresenterModule {

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter(Application app) {
        return new LoginPresenter(app);
    }
}
