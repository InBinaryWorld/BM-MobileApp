package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.UpdateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormPresenter;

public class CompanyContactModifyPresenter extends BaseFormPresenter<CompanyContact, CompanyContactModifyView, CompanyContactModifyFormConfig> {

    @Inject
    ContactsService contactsService;

    @Inject
    SessionManager sessionManager;

    public CompanyContactModifyPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void updateCompanyContact(UpdateCompanyContactRequest object, Long contactId) {
        Long companyId = sessionManager.getCompanyId();
        contactsService.updateCompanyContact(companyId, contactId, object)
            .compose(view.bindToLifecycle())
            .subscribe(this::onSuccess, this::onError);
    }

    @Override
    public CompanyContactModifyFormConfig createConfig() {
        return FormConfigurations.getCompanyContactModifyFormConfig(view.getContext());
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(Long contactId) {
        Long companyId = sessionManager.getCompanyId();
        contactsService.getCompanyContact(companyId, contactId)
            .compose(view.bindToLifecycle())
            .subscribe(view::setModifyModel, view::setError);
    }
}
