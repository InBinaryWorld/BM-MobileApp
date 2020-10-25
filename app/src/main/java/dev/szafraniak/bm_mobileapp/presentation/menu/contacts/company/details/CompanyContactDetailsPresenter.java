package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment.BaseDetailsPresenter;

public class CompanyContactDetailsPresenter extends BaseDetailsPresenter<CompanyContact, CompanyContactDetailsView, CompanyContactDetailsConfig> {

    @Inject
    ContactsService contactsService;

    @Inject
    SessionManager sessionManager;

    public CompanyContactDetailsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(Long contactId) {
        Long companyId = sessionManager.getCompanyId();
        contactsService.getCompanyContact(companyId, contactId)
                .compose(view.bindToLifecycle())
                .subscribe(view::setData, view::setError);
    }

    @Override
    public CompanyContactDetailsConfig createConfig() {
        CompanyContactDetailsConfig config = new CompanyContactDetailsConfig();
        config.setDefaultValue(null);
        config.setVisibleOnSetValueNull(true);
        config.setCompanyNameConfig(DetailsConfigurations.getCompanyNameConfig());
        config.setTaxIdConfig(DetailsConfigurations.getTaxIdConfig());
        config.setPhoneConfig(DetailsConfigurations.getPhoneConfig());
        config.setAddressConfig(DetailsConfigurations.getAddressConfig());
        return config;
    }
}
