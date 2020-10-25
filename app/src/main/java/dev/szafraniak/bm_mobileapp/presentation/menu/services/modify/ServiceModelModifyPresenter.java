package dev.szafraniak.bm_mobileapp.presentation.menu.services.modify;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ServiceModelService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.UpdateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormPresenter;

public class ServiceModelModifyPresenter extends BaseFormPresenter<ServiceModel, ServiceModelModifyView, ModifyServiceModelFormConfig> {

    @Inject
    ServiceModelService serviceModelService;

    @Inject
    SessionManager sessionManager;

    public ServiceModelModifyPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void modifyServiceModel(UpdateServiceModelRequest object, Long serviceModelId) {
        Long companyId = sessionManager.getCompanyId();
        serviceModelService.modifyServiceModel(companyId, serviceModelId, object)
            .compose(view.bindToLifecycle())
            .subscribe(this::onSuccess, this::onError);
    }

    @Override
    public ModifyServiceModelFormConfig createConfig() {
        ModifyServiceModelFormConfig config = new ModifyServiceModelFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getProductModelNameConfig());
        config.setQuantityUniteConfig(FormConfigurations.getQuantityUnitConfig());
        config.setPriceFormConfig(FormConfigurations.getPriceConfig());
        return config;
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(Long serviceModelId) {
        Long companyId = sessionManager.getCompanyId();
        serviceModelService.getServiceModel(companyId, serviceModelId)
            .compose(view.bindToLifecycle())
            .subscribe(view::setModifyModel, view::setError);
    }
}
