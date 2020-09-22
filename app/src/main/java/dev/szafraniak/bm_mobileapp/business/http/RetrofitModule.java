package dev.szafraniak.bm_mobileapp.business.http;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.szafraniak.bm_mobileapp.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class RetrofitModule {

    @Provides
    @Singleton
    @Named("Retrofit")
    Retrofit provideResourceServerRetrofit(
            @Named("OkHttpClientWithAuth") OkHttpClient okHttpClient,
            GsonConverterFactory gsonConverterFactory
    ) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.RESOURCE_SERVER_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @Named("RetrofitWithoutAuth")
    Retrofit provideAuthorizationServerRetrofit(
            @Named("OkHttpClientWithoutAuth") OkHttpClient okHttpClient,
            GsonConverterFactory gsonConverterFactory
    ) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.RESOURCE_SERVER_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
