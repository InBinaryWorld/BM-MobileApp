package dev.szafraniak.bm_mobileapp.presentation.menu.company;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.CompanyService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionPreferences;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.UpdateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormPresenter;

public class ModifyCompanyPresenter extends BaseFormPresenter<ModifyCompanyView, Company> {

    @Inject
    CompanyService companyService;

    @Inject
    SessionManager sessionManager;

    @Inject
    SessionPreferences sessionPreferences;

    public ModifyCompanyPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void modifyCompanyData(UpdateCompanyRequest request) {
        Long companyId = sessionManager.getCompanyId();
        companyService.modifyCompany(companyId, request)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);

    }

    public Company getActiveCompany() {
        return sessionPreferences.getCompany();
    }
}
