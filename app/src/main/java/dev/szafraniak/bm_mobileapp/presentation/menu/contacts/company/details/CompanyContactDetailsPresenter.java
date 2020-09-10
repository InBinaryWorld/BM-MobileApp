package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.BaseDetailsPresenter;

public class CompanyContactDetailsPresenter extends BaseDetailsPresenter<CompanyContactDetailsView, CompanyContact> {

    @Inject
    ContactsService contactsService;

    @Inject
    UserPreferences userPreferences;

    public CompanyContactDetailsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(Long contactId) {
        Long companyId = userPreferences.getCompanyId();
        contactsService.getCompanyContact(companyId, contactId)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }
}
