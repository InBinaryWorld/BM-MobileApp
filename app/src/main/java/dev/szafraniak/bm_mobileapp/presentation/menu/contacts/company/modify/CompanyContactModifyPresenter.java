package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.UpdateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormPresenter;

public class CompanyContactModifyPresenter extends BaseFormPresenter<CompanyContactModifyView, CompanyContact> {

    @Inject
    ContactsService contactsService;

    @Inject
    UserPreferences userPreferences;

    public CompanyContactModifyPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void updateCompanyContact(UpdateCompanyContactRequest object, Long contactId) {
        Long companyId = userPreferences.getCompanyId();
        contactsService.updateCompanyContact(companyId, contactId, object)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }

}
