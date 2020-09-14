package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.create;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.WarehouseService;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.CreateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormPresenter;

public class WarehouseCreatePresenter extends BaseFormPresenter<WarehouseCreateView, Warehouse> {

    @Inject
    WarehouseService warehouseService;

    @Inject
    UserPreferences userPreferences;

    public WarehouseCreatePresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createWarehouse(CreateWarehouseRequest object) {
        warehouseService.createWarehouse(userPreferences.getCompanyId(), object)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }

}
