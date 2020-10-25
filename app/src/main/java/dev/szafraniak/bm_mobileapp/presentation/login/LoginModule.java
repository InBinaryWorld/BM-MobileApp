package dev.szafraniak.bm_mobileapp.presentation.login;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.szafraniak.bm_mobileapp.presentation.login.activity.LoginPresenter;

@Module
public class LoginModule {

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter(Application app) {
        return new LoginPresenter(app);
    }
}
