package dev.szafraniak.bm_mobileapp.business.http.service;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.api.BmResourcesApi;
import dev.szafraniak.bm_mobileapp.business.models.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.CreateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.UpdateServiceModelRequest;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ServiceModelService {
    @Inject
    BmResourcesApi bmResourcesApi;

    public ServiceModelService(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public Observable<BMCollection<ServiceModel>> getServiceModels(Long companyId) {
        return bmResourcesApi.getServiceModels(companyId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ServiceModel> getServiceModel(Long companyId, Long serviceModelId) {
        return bmResourcesApi.getServiceModel(companyId, serviceModelId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ServiceModel> createServiceModel(Long companyId,
                                                       CreateServiceModelRequest model) {
        return bmResourcesApi.createServiceModel(companyId, model)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ServiceModel> modifyServiceModel(Long companyId,
                                                       Long serviceModelId,
                                                       UpdateServiceModelRequest model) {
        return bmResourcesApi.modifyServiceModel(companyId, serviceModelId, model)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
