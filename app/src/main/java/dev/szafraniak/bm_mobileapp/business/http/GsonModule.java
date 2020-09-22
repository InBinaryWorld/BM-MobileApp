package dev.szafraniak.bm_mobileapp.business.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.szafraniak.bm_mobileapp.business.extras.RuntimeTypeAdapterFactory;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.InvoiceCompany;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.InvoiceContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.InvoiceIndividual;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class GsonModule {

    @Provides
    @Singleton
    public Gson provideGson() {
        RuntimeTypeAdapterFactory<InvoiceContact> factory = RuntimeTypeAdapterFactory
                .of(InvoiceContact.class, "type") // typeFieldName
                .registerSubtype(InvoiceIndividual.class, "individual")
                .registerSubtype(InvoiceCompany.class, "company");
        return new GsonBuilder().registerTypeAdapterFactory(factory).create();
    }

    @Provides
    @Singleton
    public GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

}
