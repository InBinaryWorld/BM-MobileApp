package dev.szafraniak.bm_mobileapp.presentation.menu.services.create;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ServiceModelService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.CreateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormPresenter;

public class ServiceModelCreatePresenter extends BaseFormPresenter<ServiceModel, ServiceModelCreateView, CreateServiceFormConfig> {

    @Inject
    ServiceModelService serviceModelService;

    @Inject
    SessionManager sessionManager;

    public ServiceModelCreatePresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createServiceModel(CreateServiceModelRequest object) {
        serviceModelService.createServiceModel(sessionManager.getCompanyId(), object)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }

    @Override
    public CreateServiceFormConfig createConfig() {
        CreateServiceFormConfig config = new CreateServiceFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getProductModelNameConfig());
        config.setQuantityUniteConfig(FormConfigurations.getQuantityUnitConfig());
        config.setPriceFormConfig(FormConfigurations.getPriceConfig());
        return config;
    }
}
