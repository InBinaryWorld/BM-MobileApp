package dev.szafraniak.bm_mobileapp.business.http;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.szafraniak.bm_mobileapp.business.http.interceptors.AuthInterceptor;
import dev.szafraniak.bm_mobileapp.business.http.interceptors.LoggingInterceptor;
import dev.szafraniak.bm_mobileapp.business.http.interceptors.TokenAuthenticator;
import okhttp3.OkHttpClient;

@Module
public class OkHttpClientModule {

    @Provides
    @Singleton
    @Named("OkHttpClientWithAuth")
    OkHttpClient provideHttpClient(Application app) {
        return new OkHttpClient.Builder()
                .authenticator(new TokenAuthenticator(app))
                .addInterceptor(new AuthInterceptor(app))
                .addInterceptor(new LoggingInterceptor())
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }


    /**
     * Created second client because TokenAuthenticator use service
     * so dagger jump into loop and app crashed
     *
     * @param app
     * @return
     */
    @Provides
    @Singleton
    @Named("OkHttpClientWithoutAuth")
    OkHttpClient provideHttpClientWithoutAuth(Application app) {
        return new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }
}
