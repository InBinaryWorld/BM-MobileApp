package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment.BaseDetailsPresenter;
import retrofit2.Response;

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

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void deleteContact(Long contactId) {
        Long companyId = sessionManager.getCompanyId();
        contactsService.deleteCompanyContact(companyId, contactId)
            .compose(view.bindToLifecycle())
            .subscribe(this::onDeleteSucceed, view::setActionFailed);
    }

    private void onDeleteSucceed(Response<Void> voidResponse) {
        Navigator.back(view);
    }


    @Override
    public CompanyContactDetailsConfig createConfig() {
        return DetailsConfigurations.getCompanyContactDetailsConfig(view.getContext());
    }
}
