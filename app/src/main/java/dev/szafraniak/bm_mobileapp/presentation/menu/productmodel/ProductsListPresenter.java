package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ProductModelService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import lombok.Setter;

public class ProductsListPresenter {

    @Setter
    ProductsListView view;

    @Inject
    ProductModelService productModelService;

    @Inject
    SessionManager sessionManager;

    public ProductsListPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        productModelService.getProductModels(sessionManager.getCompanyId())
                .compose(view.bindToLifecycle())
                .subscribe(view::setData, view::setError);
    }

}
