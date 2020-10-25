package dev.szafraniak.bm_mobileapp.presentation.menu.product;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ProductService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
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
            .map(this::sort)
            .compose(view.bindToLifecycle())
            .subscribe(view::setData, view::setError);
    }

    private BMCollection<Product> sort(BMCollection<Product> collection) {
        collection.getItems().sort((a, b) ->
            a.getProductModel().getName().compareTo(b.getProductModel().getName()));
        return collection;
    }

}
