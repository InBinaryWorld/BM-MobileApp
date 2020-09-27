package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormPresenter;

public class IndividualContactCreatePresenter extends BaseFormPresenter<IndividualContact, IndividualContactCreateView, IndividualContactCreateFormConfig> {

    @Inject
    ContactsService contactsService;

    @Inject
    SessionManager sessionManager;

    public IndividualContactCreatePresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createContact(CreateIndividualContactRequest object) {
        contactsService.createIndividualContact(sessionManager.getCompanyId(), object)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }

    @Override
    public IndividualContactCreateFormConfig createConfig() {
        IndividualContactCreateFormConfig config = new IndividualContactCreateFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setFirstNameConfig(FormConfigurations.getFirstNameConfig());
        config.setLastNameConfig(FormConfigurations.getLastNameConfig());
        config.setPhoneConfig(FormConfigurations.getPhoneConfig());
        config.setAddressConfig(FormConfigurations.getAddressConfig());
        return config;
    }
}
