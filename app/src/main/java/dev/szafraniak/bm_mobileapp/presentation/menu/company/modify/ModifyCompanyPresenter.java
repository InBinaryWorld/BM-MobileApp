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
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.company.activity.CompanyActivity_;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormPresenter;
import retrofit2.Response;

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
        return FormConfigurations.getModifyCompanyFormConfig(view.getContext());
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        Long companyId = sessionManager.getCompanyId();
        companyService.getCompany(companyId)
            .compose(view.bindToLifecycle())
            .subscribe(view::setModifyModel, view::setError);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void deleteCompany() {
        Long companyId = sessionManager.getCompanyId();
        companyService.deleteCompany(companyId)
            .compose(view.bindToLifecycle())
            .subscribe(this::onCompanyDelete, view::setError);
    }

    private void onCompanyDelete(Response<Void> voidResponse) {
        Navigator.startActivityOnEmptyStack(view.getContext(), CompanyActivity_.class);
    }
}
