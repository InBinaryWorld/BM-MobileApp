package dev.szafraniak.bm_mobileapp.business.http.service.api;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.api.BmResourcesApi;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.CreateProductRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.UpdateProductRequest;
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ProductService {
    @Inject
    BmResourcesApi bmResourcesApi;

    public ProductService(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public Observable<BMCollection<Product>> getProducts(Long companyId, Long warehouseId, Long productModelId) {
        return bmResourcesApi.getProducts(companyId, warehouseId, productModelId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Product> getProduct(Long companyId, Long productId) {
        return bmResourcesApi.getProduct(companyId, productId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Product> createProduct(Long companyId, CreateProductRequest request) {
        return bmResourcesApi.createProduct(companyId, request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Product> modifyProduct(Long companyId, Long productId, UpdateProductRequest request) {
        return bmResourcesApi.modifyProduct(companyId, productId, request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Response<Void>> deleteProduct(Long companyId, Long productId) {
        return bmResourcesApi.deleteProduct(companyId, productId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }
}
