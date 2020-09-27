package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormPresenter;

public class CompanyContactCreatePresenter extends BaseFormPresenter<CompanyContact,
        CompanyContactCreateView, CompanyContactCreateFormConfig> {

    @Inject
    ContactsService contactsService;

    @Inject
    SessionManager sessionManager;

    public CompanyContactCreatePresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createCompany(CreateCompanyContactRequest object) {
        contactsService.createCompanyContact(sessionManager.getCompanyId(), object)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }

    @Override
    public CompanyContactCreateFormConfig createConfig() {
        CompanyContactCreateFormConfig config = new CompanyContactCreateFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getCompanyNameConfig());
        config.setPhoneConfig(FormConfigurations.getPhoneConfig());
        config.setTaxIdConfig(FormConfigurations.getTaxIdentityNumberConfig());
        config.setAddressConfig(FormConfigurations.getAddressConfig());
        return config;
    }
}
