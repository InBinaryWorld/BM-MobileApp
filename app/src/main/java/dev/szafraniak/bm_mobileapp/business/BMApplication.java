package dev.szafraniak.bm_mobileapp.business;

import android.app.Application;

import dev.szafraniak.bm_mobileapp.BuildConfig;
import dev.szafraniak.bm_mobileapp.business.dagger.AppComponent;
import dev.szafraniak.bm_mobileapp.business.dagger.AppModule;
import dev.szafraniak.bm_mobileapp.business.dagger.DaggerAppComponent;
import lombok.Getter;
import timber.log.Timber;


public class BMApplication extends Application {

    @Getter
    AppComponent appComponent;

    public BMApplication() {
        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
