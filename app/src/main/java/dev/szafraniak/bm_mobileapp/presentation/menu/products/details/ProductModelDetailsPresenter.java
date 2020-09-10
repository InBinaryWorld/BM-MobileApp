package dev.szafraniak.bm_mobileapp.presentation.menu.products.details;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ProductModelService;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.BaseDetailsPresenter;

public class ProductModelDetailsPresenter extends BaseDetailsPresenter<ProductModelDetailsView, ProductModel> {

    @Inject
    UserPreferences userPreferences;

    @Inject
    ProductModelService productModelService;

    public ProductModelDetailsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(Long productModelId) {
        Long companyId = userPreferences.getCompanyId();
        productModelService.getProductModel(companyId, productModelId)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }
}
