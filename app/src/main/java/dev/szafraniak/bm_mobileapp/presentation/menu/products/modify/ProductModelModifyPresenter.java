package dev.szafraniak.bm_mobileapp.presentation.menu.products.modify;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ProductModelService;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.UpdateProductModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormPresenter;

public class ProductModelModifyPresenter extends BaseFormPresenter<ProductModelModifyView, ProductModel> {

    @Inject
    ProductModelService productModelService;

    @Inject
    UserPreferences userPreferences;

    public ProductModelModifyPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void modifyProductModel(UpdateProductModelRequest object, Long productModelId) {
        Long companyId = userPreferences.getCompanyId();
        productModelService.modifyProductModel(companyId, productModelId, object)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }
}
