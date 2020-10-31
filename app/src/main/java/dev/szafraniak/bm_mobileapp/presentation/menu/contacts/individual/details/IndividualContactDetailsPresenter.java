package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment.BaseDetailsPresenter;
import retrofit2.Response;

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

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void deleteContact(Long contactId) {
        Long companyId = sessionManager.getCompanyId();
        contactsService.deleteIndividualContact(companyId, contactId)
            .compose(view.bindToLifecycle())
            .subscribe(this::onDeleteSucceed, view::setActionFailed);
    }

    private void onDeleteSucceed(Response<Void> voidResponse) {
        Navigator.back(view);
    }

    @Override
    public IndividualContactDetailsConfig createConfig() {
        return DetailsConfigurations.getIndividualContactDetailsConfig(view.getContext());
    }

}
