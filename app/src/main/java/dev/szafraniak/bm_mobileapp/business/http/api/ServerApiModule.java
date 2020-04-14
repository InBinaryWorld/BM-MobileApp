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
    public BmResourcesServerApi provideBmResourcesServerApi(
            @Named("ResourceServerRetrofit") Retrofit retrofit) {
        return retrofit.create(BmResourcesServerApi.class);
    }

    @Provides
    @Singleton
    public AuthorizationServerApi provideAuthorizationServerRetrofit(
            @Named("AuthorizationServerRetrofit") Retrofit retrofit) {
        return retrofit.create(AuthorizationServerApi.class);
    }

}
