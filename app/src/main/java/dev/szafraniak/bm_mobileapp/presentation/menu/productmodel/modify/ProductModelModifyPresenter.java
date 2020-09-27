package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.modify;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ProductModelService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.UpdateProductModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormPresenter;

public class ProductModelModifyPresenter extends BaseFormPresenter<ProductModel, ProductModelModifyView, ModifyProductModelFormConfig> {

    @Inject
    ProductModelService productModelService;

    @Inject
    SessionManager sessionManager;

    public ProductModelModifyPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void modifyProductModel(UpdateProductModelRequest object, Long productModelId) {
        Long companyId = sessionManager.getCompanyId();
        productModelService.modifyProductModel(companyId, productModelId, object)
                .compose(view.bindToLifecycle())
                .subscribe(this::onSuccess, this::onError);
    }

    @Override
    public ModifyProductModelFormConfig createConfig() {
        ModifyProductModelFormConfig config = new ModifyProductModelFormConfig();
        config.setVisibleOnSetValueNull(true);
        config.setNameConfig(FormConfigurations.getProductModelNameConfig());
        config.setBareCodeConfig(FormConfigurations.getBareCodeConfig());
        config.setQuantityUniteConfig(FormConfigurations.getQuantityUnitConfig());
        config.setPriceFormConfig(FormConfigurations.getPriceConfig());
        return config;
    }

    public void loadData(long productModelId) {
        Long companyId = sessionManager.getCompanyId();
        productModelService.getProductModel(companyId, productModelId)
                .compose(view.bindToLifecycle())
                .subscribe(view::setModifyModel, view::setError);
    }
}
