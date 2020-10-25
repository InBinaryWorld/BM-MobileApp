package dev.szafraniak.bm_mobileapp.business.memory;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsManager;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsPreferences;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionPreferences;
import dev.szafraniak.bm_mobileapp.business.memory.settings.SettingsManager;
import dev.szafraniak.bm_mobileapp.business.memory.settings.SettingsPreferences;

@Module
public class MemoryManagementModule {

    @Provides
    @Singleton
    public SessionPreferences provideSessionPreferences(Application app) {
        return new SessionPreferences(app);
    }

    @Provides
    @Singleton
    public SettingsPreferences provideUserPreferences(Application app) {
        return new SettingsPreferences(app);
    }

    @Provides
    @Singleton
    public FormsPreferences provideFormsPreferences(Application app) {
        return new FormsPreferences(app);
    }

    @Provides
    @Singleton
    public SessionManager provideSessionManager(Application app) {
        return new SessionManager(app);
    }

    @Provides
    @Singleton
    public FormsManager provideFormsManager(Application app) {
        return new FormsManager(app);
    }

    @Provides
    @Singleton
    public SettingsManager provideSettingsManager(Application app) {
        return new SettingsManager(app);
    }

}
