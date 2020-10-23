package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.create;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormPresenter;

public class ContactCreatePresenter extends BaseFormPresenter<Contact,
    ContactCreateView, ContactCreateFormConfig> {

    @Inject
    ContactsService contactsService;

    @Inject
    SessionManager sessionManager;

    public ContactCreatePresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createCompany(CreateCompanyContactRequest object) {
        contactsService.createCompanyContact(sessionManager.getCompanyId(), object)
            .compose(view.bindToLifecycle())
            .subscribe(this::onSuccess, this::onError);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createIndividual(CreateIndividualContactRequest object) {
        contactsService.createIndividualContact(sessionManager.getCompanyId(), object)
            .compose(view.bindToLifecycle())
            .subscribe(this::onSuccess, this::onError);
    }

    @Override
    public ContactCreateFormConfig createConfig() {
        ContactCreateFormConfig config = new ContactCreateFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setCompanyConfig(FormConfigurations.getCompanyContactCreateConfig());
        config.setIndividualConfig(FormConfigurations.getIndividualContactCreateConfig());
        config.setContactTypeForm(FormConfigurations.getContactTypeConfig());
        return config;
    }

}
