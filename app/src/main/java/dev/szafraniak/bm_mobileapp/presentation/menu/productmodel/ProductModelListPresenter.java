package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ProductModelService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
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
            .map(this::sort)
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }

    private BMCollection<ProductModel> sort(BMCollection<ProductModel> collection) {
        collection.getItems().sort((a, b) -> a.getName().compareTo(b.getName()));
        return collection;
    }

}
