package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.WarehouseService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment.BaseDetailsPresenter;
import retrofit2.Response;

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

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void deleteWarehouse(Long warehouseId) {
        Long companyId = sessionManager.getCompanyId();
        warehouseService.deleteWarehouse(companyId, warehouseId)
            .compose(view.bindToLifecycle())
            .subscribe(this::onDeleteSucceed, view::setError);
    }

    private void onDeleteSucceed(Response<Void> voidResponse) {
        Navigator.back(view);
    }

    @Override
    public WarehouseDetailsConfig createConfig() {
        return DetailsConfigurations.getWarehouseDetailsConfig(view.getContext());
    }

}
