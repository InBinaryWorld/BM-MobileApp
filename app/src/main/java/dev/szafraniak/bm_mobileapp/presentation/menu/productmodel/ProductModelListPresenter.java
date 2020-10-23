package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel;

import android.annotation.SuppressLint;
import android.app.Application;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ProductModelService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.BMCollection;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.CurrencyWrapper;
import lombok.Setter;

public class ProductModelListPresenter {

    @Setter
    ProductModelListView view;

    @Inject
    ProductModelService productModelService;

    @Inject
    SessionManager sessionManager;

    public ProductModelListPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        productModelService.getProductModels(sessionManager.getCompanyId())
            .map(this::appendCurrency)
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }

    private BMCollection<CurrencyWrapper<ProductModel>> appendCurrency(BMCollection<ProductModel> productModelsCollection) {
        String currency = sessionManager.getCompany().getCurrency();
        List<CurrencyWrapper<ProductModel>> list = productModelsCollection.getItems().stream()
            .map(item -> new CurrencyWrapper<>(currency, item)).collect(Collectors.toList());
        BMCollection<CurrencyWrapper<ProductModel>> collection = new BMCollection<>();
        collection.setItems(list);
        collection.setTotal(list.size());
        return collection;
    }

}
