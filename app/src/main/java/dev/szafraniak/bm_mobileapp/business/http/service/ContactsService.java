package dev.szafraniak.bm_mobileapp.business.http.service;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.api.BmResourcesApi;
import dev.szafraniak.bm_mobileapp.business.models.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.UpdateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.UpdateIndividualContactRequest;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ContactsService {

    @Inject
    BmResourcesApi bmResourcesApi;

    public ContactsService(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public Observable<BMCollection<CompanyContact>> getCompanyContacts(Long companyId) {
        return bmResourcesApi.getCompanyContacts(companyId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<CompanyContact> getCompanyContact(Long companyId, Long contactId) {
        return bmResourcesApi.getCompanyContact(companyId, contactId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<CompanyContact> createCompanyContact(Long companyId,
                                                           CreateCompanyContactRequest request) {
        return bmResourcesApi.createCompanyContact(companyId, request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<CompanyContact> updateCompanyContact(Long companyId,
                                                           Long contactId,
                                                           UpdateCompanyContactRequest request) {
        return bmResourcesApi.updateCompanyContact(companyId, contactId, request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<BMCollection<IndividualContact>> getIndividualContacts(Long companyId) {
        return bmResourcesApi.getIndividualContacts(companyId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<IndividualContact> getIndividualContact(Long companyId, Long contactId) {
        return bmResourcesApi.getIndividualContact(companyId, contactId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<IndividualContact> createIndividualContact(Long companyId,
                                                                 CreateIndividualContactRequest request) {
        return bmResourcesApi.createIndividualContact(companyId, request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<IndividualContact> updateIndividualContact(Long companyId,
                                                                 Long contactId,
                                                                 UpdateIndividualContactRequest request) {
        return bmResourcesApi.updateIndividualContact(companyId, contactId, request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<BMCollection<Contact>> getContacts(Long companyId) {
        return bmResourcesApi.getCompanyContacts(companyId)
            .flatMap(companyContacts -> appendCompanyContacts(companyContacts, companyId))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    private Observable<BMCollection<Contact>> appendCompanyContacts(BMCollection<CompanyContact> companies, Long companyId) {
        return getIndividualContacts(companyId).map(individuals -> {
            List<Contact> contacts = new ArrayList<>();
            contacts.addAll(companies.getItems());
            contacts.addAll(individuals.getItems());
            BMCollection<Contact> contactsCollection = new BMCollection<>();
            contactsCollection.setItems(contacts);
            contactsCollection.setTotal(contacts.size());
            return contactsCollection;
        });
    }


}
