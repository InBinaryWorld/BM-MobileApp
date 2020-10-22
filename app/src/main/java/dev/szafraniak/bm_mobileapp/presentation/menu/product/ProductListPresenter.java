package dev.szafraniak.bm_mobileapp.presentation.menu.product;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ProductService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import lombok.Setter;

public class ProductListPresenter {

    @Setter
    ProductListView view;

    @Inject
    ProductService productService;

    @Inject
    SessionManager sessionManager;

    public ProductListPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(Long warehouseId) {
        productService.getProducts(sessionManager.getCompanyId(), warehouseId, null)
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }

}
