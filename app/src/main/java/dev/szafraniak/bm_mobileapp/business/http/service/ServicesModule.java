package dev.szafraniak.bm_mobileapp.business.http.service;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {

    @Provides
    @Singleton
    public HelloService provideHelloService(Application app) {
        return new HelloService(app);
    }

    @Provides
    @Singleton
    public AuthorizationService provideAuthorizationService(Application app) {
        return new AuthorizationService(app);
    }
}
