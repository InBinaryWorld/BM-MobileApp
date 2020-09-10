package dev.szafraniak.bm_mobileapp.business.http.service;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.api.BmResourcesApi;
import dev.szafraniak.bm_mobileapp.business.models.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.CreateProductModelRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.UpdateProductModelRequest;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ProductModelService {
    @Inject
    BmResourcesApi bmResourcesApi;

    public ProductModelService(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public Observable<BMCollection<ProductModel>> getProductModels(Long companyId) {
        return bmResourcesApi.getProductModels(companyId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ProductModel> getProductModel(Long companyId, Long productModelId) {
        return bmResourcesApi.getProductModel(companyId, productModelId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ProductModel> createProductModel(Long companyId,
                                                       CreateProductModelRequest model) {
        return bmResourcesApi.createProductModel(companyId, model)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ProductModel> modifyProductModel(Long companyId,
                                                       Long productModelId,
                                                       UpdateProductModelRequest model) {
        return bmResourcesApi.modifyProductModel(companyId, productModelId, model)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
