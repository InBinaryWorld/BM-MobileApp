package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.WarehouseService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment.BaseDetailsPresenter;

public class WarehouseDetailsPresenter extends BaseDetailsPresenter<Warehouse, WarehouseDetailsView, WarehouseDetailsConfig> {

    @Inject
    WarehouseService warehouseService;

    @Inject
    SessionManager sessionManager;

    public WarehouseDetailsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(Long contactId) {
        Long companyId = sessionManager.getCompanyId();
        warehouseService.getWarehouse(companyId, contactId)
                .compose(view.bindToLifecycle())
                .subscribe(view::setData, view::setError);
    }

    @Override
    public WarehouseDetailsConfig createConfig() {
        WarehouseDetailsConfig config = new WarehouseDetailsConfig();
        config.setVisibleOnSetValueNull(true);
        config.setDefaultValue(null);
        config.setWarehouseNameConfig(DetailsConfigurations.getWarehouseName());
        config.setAddressDetailsConfig(DetailsConfigurations.getAddressConfig());
        return config;
    }
}
