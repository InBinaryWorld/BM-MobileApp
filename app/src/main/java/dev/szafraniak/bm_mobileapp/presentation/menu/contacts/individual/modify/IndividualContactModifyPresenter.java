package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.UpdateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormPresenter;

public class IndividualContactModifyPresenter extends BaseFormPresenter<IndividualContactModifyView, IndividualContact> {

    @Inject
    ContactsService contactsService;

    @Inject
    UserPreferences userPreferences;

    public IndividualContactModifyPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void updateCompany(UpdateIndividualContactRequest object, Long contactId) {
        Long companyId = userPreferences.getCompanyId();
        contactsService.updateIndividualContact(companyId, contactId, object)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }

}
