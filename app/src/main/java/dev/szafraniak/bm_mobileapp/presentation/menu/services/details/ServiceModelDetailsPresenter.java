package dev.szafraniak.bm_mobileapp.presentation.menu.services.details;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ServiceModelService;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.BaseDetailsPresenter;

public class ServiceModelDetailsPresenter extends BaseDetailsPresenter<ServiceModelDetailsView, ServiceModel> {

    @Inject
    ServiceModelService serviceModelService;

    @Inject
    UserPreferences userPreferences;

    public ServiceModelDetailsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(Long serviceModelId) {
        Long companyId = userPreferences.getCompanyId();
        serviceModelService.getServiceModel(companyId, serviceModelId)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }
}
