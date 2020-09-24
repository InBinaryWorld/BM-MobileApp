package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment.BaseDetailsPresenter;

public class IndividualContactDetailsPresenter extends BaseDetailsPresenter<IndividualContact,
        IndividualContactDetailsView, IndividualContactDetailsConfig> {

    @Inject
    ContactsService contactsService;

    @Inject
    SessionManager sessionManager;


    public IndividualContactDetailsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(Long contactId) {
        Long companyId = sessionManager.getCompanyId();
        contactsService.getIndividualContact(companyId, contactId)
                .compose(view.bindToLifecycle())
                .subscribe(view::setData, view::setError);
    }

    @Override
    public IndividualContactDetailsConfig createConfig() {
        IndividualContactDetailsConfig config = new IndividualContactDetailsConfig();
        config.setDefaultValue(null);
        config.setVisibleOnSetValueNull(true);
        config.setFirstNameConfig(DetailsConfigurations.getFirstNameConfig());
        config.setLastNameConfig(DetailsConfigurations.getLastNameConfig());
        config.setPhoneConfig(DetailsConfigurations.getPhoneConfig());
        config.setAddressConfig(DetailsConfigurations.getAddressConfig());
        return config;
    }
}
