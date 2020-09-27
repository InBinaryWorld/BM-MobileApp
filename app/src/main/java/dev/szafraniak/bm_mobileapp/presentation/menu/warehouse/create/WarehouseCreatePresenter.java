package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.create;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.WarehouseService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.CreateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormPresenter;

public class WarehouseCreatePresenter extends BaseFormPresenter<Warehouse, WarehouseCreateView, CreateWarehouseFormConfig> {

    @Inject
    WarehouseService warehouseService;

    @Inject
    SessionManager sessionManager;

    public WarehouseCreatePresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createWarehouse(CreateWarehouseRequest object) {
        warehouseService.createWarehouse(sessionManager.getCompanyId(), object)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }

    @Override
    public CreateWarehouseFormConfig createConfig() {
        CreateWarehouseFormConfig config = new CreateWarehouseFormConfig();
        config.setNameConfig(FormConfigurations.getWarehouseName());
        config.setAddressConfig(FormConfigurations.getAddressConfig());
        return config;
    }
}
