package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.BaseDetailsPresenter;

public class IndividualContactDetailsPresenter extends BaseDetailsPresenter<IndividualContactDetailsView, IndividualContact> {

    @Inject
    ContactsService contactsService;

    @Inject
    UserPreferences userPreferences;


    public IndividualContactDetailsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(Long contactId) {
        Long companyId = userPreferences.getCompanyId();
        contactsService.getIndividualContact(companyId, contactId)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }
}
