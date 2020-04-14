package dev.szafraniak.bm_mobileapp.business.memory;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PreferencesModule {

    @Provides
    @Singleton
    public SessionPreferences provideSessionPreferences(Context ctx){
        return new SessionPreferences(ctx);
    }
    @Provides
    @Singleton
    public UserPreferences provideUserPreferences(Context ctx){
        return new UserPreferences(ctx);
    }
}
