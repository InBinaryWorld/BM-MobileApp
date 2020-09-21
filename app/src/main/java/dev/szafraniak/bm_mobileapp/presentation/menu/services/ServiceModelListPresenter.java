package dev.szafraniak.bm_mobileapp.presentation.menu.services;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ServiceModelService;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import lombok.Setter;

public class ServiceModelListPresenter {

    @Setter
    ServiceModelListView view;

    @Inject
    ServiceModelService serviceModelService;

    @Inject
    UserPreferences userPreferences;

    public ServiceModelListPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        serviceModelService.getServiceModels(userPreferences.getCompanyId())
                .compose(view.bindToLifecycle())
                .subscribe(view::setData, view::setError);
    }

}
