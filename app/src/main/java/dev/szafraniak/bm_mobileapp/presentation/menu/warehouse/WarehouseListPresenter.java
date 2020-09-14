package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.WarehouseService;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import lombok.Setter;

public class WarehouseListPresenter {

    @Setter
    WarehouseListView view;

    @Inject
    WarehouseService warehouseService;

    @Inject
    UserPreferences userPreferences;

    public WarehouseListPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadListData() {
        warehouseService.getWarehouses(userPreferences.getCompanyId())
                .compose(view.bindToLifecycle())
                .subscribe(view::setData, view::setError);
    }

}