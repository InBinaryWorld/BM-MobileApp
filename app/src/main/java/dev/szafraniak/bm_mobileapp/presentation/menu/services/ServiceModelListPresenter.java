package dev.szafraniak.bm_mobileapp.presentation.menu.services;

import android.annotation.SuppressLint;
import android.app.Application;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ServiceModelService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.CurrencyWrapper;
import lombok.Setter;

public class ServiceModelListPresenter {

    @Setter
    ServiceModelListView view;

    @Inject
    ServiceModelService serviceModelService;

    @Inject
    SessionManager sessionManager;

    public ServiceModelListPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        serviceModelService.getServiceModels(sessionManager.getCompanyId())
            .map(this::appendCurrency)
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }


    private BMCollection<CurrencyWrapper<ServiceModel>> appendCurrency(BMCollection<ServiceModel> productModelsCollection) {
        String currency = sessionManager.getCompany().getCurrency();
        List<CurrencyWrapper<ServiceModel>> list = productModelsCollection.getItems().stream()
            .map(item -> new CurrencyWrapper<>(currency, item)).collect(Collectors.toList());
        BMCollection<CurrencyWrapper<ServiceModel>> collection = new BMCollection<>();
        collection.setItems(list);
        collection.setTotal(list.size());
        return collection;
    }

}
