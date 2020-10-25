package dev.szafraniak.bm_mobileapp.presentation.company.create;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.CompanyService;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.company.create.form.CreateCompanyFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormPresenter;

public class CompanyCreatePresenter extends BaseFormPresenter<Company, CompanyCreateView, CreateCompanyFormConfig> {

    @Inject
    CompanyService companyService;

    public CompanyCreatePresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createCompany(CreateCompanyRequest object) {
        companyService.createCompany(object)
            .compose(view.bindToLifecycle())
            .subscribe(this::onSuccess, this::onError);
    }

    @Override
    public CreateCompanyFormConfig createConfig() {
        CreateCompanyFormConfig config = new CreateCompanyFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getCompanyNameConfig());
        config.setInvoicePrefixConfig(FormConfigurations.getInvoicePrefixConfig());
        config.setTaxIdentityConfig(FormConfigurations.getTaxIdentityNumberConfig());
        config.setAddressConfig(FormConfigurations.getAddressConfig());
        return config;
    }
}
