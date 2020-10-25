package dev.szafraniak.bm_mobileapp.presentation.menu.company.modify;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.CompanyService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionPreferences;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.UpdateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormPresenter;

public class ModifyCompanyPresenter extends BaseFormPresenter<Company, ModifyCompanyView, ModifyCompanyFormConfig> {

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

    @Override
    public ModifyCompanyFormConfig createConfig() {
        ModifyCompanyFormConfig config = new ModifyCompanyFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getCompanyNameConfig());
        config.setInvoicePrefixConfig(FormConfigurations.getInvoicePrefixConfig());
        config.setTaxIdentityConfig(FormConfigurations.getTaxIdentityNumberConfig());
        config.setAddressConfig(FormConfigurations.getAddressConfig());
        return config;
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        Long companyId = sessionManager.getCompanyId();
        companyService.getCompany(companyId)
            .compose(view.bindToLifecycle())
            .subscribe(view::setModifyModel, view::setError);
    }
}
