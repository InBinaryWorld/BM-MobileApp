package dev.szafraniak.bm_mobileapp.presentation.menu.services.details;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ServiceModelService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment.BaseDetailsPresenter;

public class ServiceModelDetailsPresenter extends BaseDetailsPresenter<ServiceModel, ServiceModelDetailsView, ServiceModelDetailsConfig> {

    @Inject
    ServiceModelService serviceModelService;

    @Inject
    SessionManager sessionManager;

    public ServiceModelDetailsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(Long serviceModelId) {
        Long companyId = sessionManager.getCompanyId();
        serviceModelService.getServiceModel(companyId, serviceModelId)
                .compose(view.bindToLifecycle())
                .subscribe(view::setData, view::setError);
    }

    @Override
    public ServiceModelDetailsConfig createConfig() {
        ServiceModelDetailsConfig config = new ServiceModelDetailsConfig();
        config.setVisibleOnSetValueNull(true);
        config.setDefaultValue(null);
        config.setServiceModelNameConfig(DetailsConfigurations.getServiceNameConfig());
        config.setQuantityUnitConfig(DetailsConfigurations.getQuantityUnitConfig());
        config.setPriceDetailsConfig(DetailsConfigurations.getPriceConfig());
        return config;
    }
}
