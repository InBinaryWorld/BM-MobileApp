package dev.szafraniak.bm_mobileapp.business.http.api;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ServerApiModule {

    @Provides
    @Singleton
    public BmResourcesApi provideBmResourcesServerApi(
            @Named("Retrofit") Retrofit retrofit) {
        return retrofit.create(BmResourcesApi.class);
    }

    @Provides
    @Singleton
    public AuthorizationApi provideAuthorizationServerRetrofit(
            @Named("RetrofitWithoutAuth") Retrofit retrofit) {
        return retrofit.create(AuthorizationApi.class);
    }

}
