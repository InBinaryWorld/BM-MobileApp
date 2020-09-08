package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormPresenter;

public class CompanyContactCreatePresenter extends BaseFormPresenter<CompanyContactCreateView, CompanyContact> {

    @Inject
    ContactsService contactsService;

    @Inject
    UserPreferences userPreferences;

    public CompanyContactCreatePresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createCompany(CreateCompanyContactRequest object) {
        contactsService.createCompanyContact(userPreferences.getCompanyId(), object)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }

}
