package dev.szafraniak.bm_mobileapp.business.http;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class OkHttpClientModule {

    @Provides
    @Singleton
    OkHttpClient provideHttpClientWithoutAuth() {
        return new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }
}
