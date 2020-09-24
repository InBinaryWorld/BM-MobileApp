package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.UpdateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormPresenter;

public class IndividualContactModifyPresenter extends BaseFormPresenter<IndividualContactModifyView, IndividualContact> {

    @Inject
    ContactsService contactsService;

    @Inject
    SessionManager sessionManager;

    public IndividualContactModifyPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void updateCompany(UpdateIndividualContactRequest object, Long contactId) {
        Long companyId = sessionManager.getCompanyId();
        contactsService.updateIndividualContact(companyId, contactId, object)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }

}
