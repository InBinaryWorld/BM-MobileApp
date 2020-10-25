package dev.szafraniak.bm_mobileapp.presentation.menu.resources;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.StatisticsService;
import dev.szafraniak.bm_mobileapp.business.http.service.api.WarehouseService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
import io.reactivex.ObservableSource;
import lombok.Setter;

public class ResourcesPresenter {

    @Setter
    ResourcesView view;

    @Inject
    WarehouseService warehouseService;

    @Inject
    StatisticsService statisticsService;

    @Inject
    SessionManager sessionManager;

    public ResourcesPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        Long companyId = sessionManager.getCompanyId();
        warehouseService.getWarehouses(companyId)
            .flatMap(collection -> appendStats(collection, companyId))
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }

    private ObservableSource<ResourcesDataModel> appendStats(BMCollection<Warehouse> collection, Long companyId) {
        collection.getItems().sort((a, b) -> a.getName().compareTo(b.getName()));
        return statisticsService.getResourcesStats(companyId).map(stats -> {
            ResourcesDataModel model = new ResourcesDataModel();
            model.setResourcesStats(stats);
            model.setWarehouses(collection);
            return model;
        });
    }

}
