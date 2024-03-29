package dev.szafraniak.bm_mobileapp.business.http;

import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.szafraniak.bm_mobileapp.business.extras.RuntimeTypeAdapterFactory;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentCash;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentTransfer;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class GsonModule {

    @Provides
    @Singleton
    public Gson provideGson() {
        GsonBuilder builder = new GsonBuilder();

        Converters.registerAll(builder);
        RuntimeTypeAdapterFactory<Contact> contactFactory = RuntimeTypeAdapterFactory
                .of(Contact.class, "type") // typeFieldName
                .registerSubtype(IndividualContact.class, "individual")
                .registerSubtype(CompanyContact.class, "company");
        RuntimeTypeAdapterFactory<PaymentMethod> paymentFactory = RuntimeTypeAdapterFactory
                .of(PaymentMethod.class, "type") // typeFieldName
                .registerSubtype(PaymentCash.class, "cash")
                .registerSubtype(PaymentTransfer.class, "transfer");
        return builder
                .registerTypeAdapterFactory(contactFactory)
                .registerTypeAdapterFactory(paymentFactory)
                .create();
    }

    @Provides
    @Singleton
    public GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

}
