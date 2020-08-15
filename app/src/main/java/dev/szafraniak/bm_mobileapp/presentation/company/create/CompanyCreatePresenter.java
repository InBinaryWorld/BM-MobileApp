package dev.szafraniak.bm_mobileapp.presentation.company.create;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.BaseCompanyService;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.result.ActionStatusFragment;
import lombok.Setter;

public class CompanyCreatePresenter {

    @Setter
    CompanyCreateView view;

    @Inject
    BaseCompanyService companyService;

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

    private void onError(Throwable throwable) {
        view.errorToast();
        view.stopProgress();
    }

    private void onSuccess(Company company) {
        Bundle bundle = new Bundle();
        String buttonText = view.getContext().getString(R.string.action_status_back_to_home);
        bundle.putString(ActionStatusFragment.BUTTON_TEXT_KEY, buttonText);
        bundle.putString(ActionStatusFragment.STATE_KEY, ActionStatusFragment.STATE_SUCCEEDED);
        Navigator.backToStartAndNavigateTo(view, FragmentFactory.FRAGMENT_ACTION_STATUS, bundle);
    }
}
