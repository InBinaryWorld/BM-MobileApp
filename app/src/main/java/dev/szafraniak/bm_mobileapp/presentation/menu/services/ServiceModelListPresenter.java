package dev.szafraniak.bm_mobileapp.presentation.menu.services;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ServiceModelService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
import lombok.Setter;

public class ServiceModelListPresenter {

    @Setter
    ServiceModelListView view;

    @Inject
    ServiceModelService serviceModelService;

    @Inject
    SessionManager sessionManager;

    public ServiceModelListPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        serviceModelService.getServiceModels(sessionManager.getCompanyId())
            .map(this::sort)
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }

    private BMCollection<ServiceModel> sort(BMCollection<ServiceModel> collection) {
        collection.getItems().sort((a, b) -> a.getName().compareTo(b.getName()));
        return collection;
    }

}
