package dev.szafraniak.bm_mobileapp.presentation.menu.resources;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.WarehouseService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import lombok.Setter;

public class ResourcesPresenter {

    @Setter
    ResourcesView view;

    @Inject
    WarehouseService warehouseService;

    @Inject
    SessionManager sessionManager;

    public ResourcesPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        warehouseService.getWarehouses(sessionManager.getCompanyId())
                .compose(view.bindToLifecycle())
                .subscribe(view::setData, view::setError);
    }

}
