package dev.szafraniak.bm_mobileapp.business.http.service.api;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.api.BmResourcesApi;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.CreateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.UpdateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class WarehouseService {
    @Inject
    BmResourcesApi bmResourcesApi;

    public WarehouseService(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public Observable<BMCollection<Warehouse>> getWarehouses(Long companyId) {
        return bmResourcesApi.getWarehouses(companyId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Warehouse> getWarehouse(Long companyId, Long warehouseId) {
        return bmResourcesApi.getWarehouse(companyId, warehouseId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Warehouse> createWarehouse(Long companyId, CreateWarehouseRequest request) {
        return bmResourcesApi.createWarehouse(companyId, request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Warehouse> modifyWarehouse(Long companyId, Long warehouseId, UpdateWarehouseRequest request) {
        return bmResourcesApi.modifyWarehouse(companyId, warehouseId, request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Response<Void>> deleteWarehouse(Long companyId, Long warehouseId) {
        return bmResourcesApi.deleteWarehouse(companyId, warehouseId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }
}
