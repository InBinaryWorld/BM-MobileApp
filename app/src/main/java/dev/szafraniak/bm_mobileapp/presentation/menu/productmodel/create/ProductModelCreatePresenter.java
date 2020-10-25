package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.create;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ProductModelService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.CreateProductModelRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormPresenter;

public class ProductModelCreatePresenter extends BaseFormPresenter<ProductModel, ProductModelCreateView, CreateProductModelFormConfig> {

    @Inject
    ProductModelService productModelService;

    @Inject
    SessionManager sessionManager;

    public ProductModelCreatePresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createProductModel(CreateProductModelRequest object) {
        productModelService.createProductModel(sessionManager.getCompanyId(), object)
            .compose(view.bindToLifecycle())
            .subscribe(this::onSuccess, this::onError);
    }

    @Override
    public CreateProductModelFormConfig createConfig() {
        CreateProductModelFormConfig config = new CreateProductModelFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getProductModelNameConfig());
        config.setBarcodeConfig(FormConfigurations.getBarcodeConfig(view.getActivity()));
        config.setQuantityUniteConfig(FormConfigurations.getQuantityUnitConfig());
        config.setPriceFormConfig(FormConfigurations.getPriceConfig());
        return config;
    }
}
