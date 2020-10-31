package dev.szafraniak.bm_mobileapp.presentation.menu.services.details;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ServiceModelService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment.BaseDetailsPresenter;
import retrofit2.Response;

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

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void deleteModel(Long modelId) {
        Long companyId = sessionManager.getCompanyId();
        serviceModelService.deleteServiceModel(companyId, modelId)
            .compose(view.bindToLifecycle())
            .subscribe(this::onDeleteSucceed, view::setError);
    }

    private void onDeleteSucceed(Response<Void> voidResponse) {
        Navigator.back(view);
    }

    @Override
    public ServiceModelDetailsConfig createConfig() {
        return DetailsConfigurations.getServiceModelDetailsConfig(view.getContext());
    }
}
