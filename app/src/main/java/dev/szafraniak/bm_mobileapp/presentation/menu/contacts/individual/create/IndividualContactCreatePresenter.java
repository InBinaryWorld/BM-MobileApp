package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormPresenter;

public class IndividualContactCreatePresenter extends BaseFormPresenter<IndividualContactCreateView, IndividualContact> {

    @Inject
    ContactsService contactsService;

    public IndividualContactCreatePresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createCompany(CreateIndividualContactRequest object) {
        contactsService.createIndividualContact(object)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }

}
