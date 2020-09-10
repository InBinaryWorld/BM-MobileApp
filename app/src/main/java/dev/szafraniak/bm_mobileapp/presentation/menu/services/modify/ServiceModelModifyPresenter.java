package dev.szafraniak.bm_mobileapp.presentation.menu.services.modify;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ServiceModelService;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.UpdateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormPresenter;

public class ServiceModelModifyPresenter extends BaseFormPresenter<ServiceModelModifyView, ServiceModel> {

    @Inject
    ServiceModelService serviceModelService;

    @Inject
    UserPreferences userPreferences;

    public ServiceModelModifyPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void modifyServiceModel(UpdateServiceModelRequest object, Long serviceModelId) {
        Long companyId = userPreferences.getCompanyId();
        serviceModelService.modifyServiceModel(companyId, serviceModelId, object)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }
}
