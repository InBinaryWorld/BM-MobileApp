package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.details;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ProductModelService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment.BaseDetailsPresenter;

public class ProductModelDetailsPresenter extends BaseDetailsPresenter<ProductModel, ProductModelDetailsView, ProductModelDetailsConfig> {

    @Inject
    SessionManager sessionManager;

    @Inject
    ProductModelService productModelService;

    public ProductModelDetailsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(Long productModelId) {
        Long companyId = sessionManager.getCompanyId();
        productModelService.getProductModel(companyId, productModelId)
                .compose(view.bindToLifecycle())
                .subscribe(view::setData, view::setError);
    }

    @Override
    public ProductModelDetailsConfig createConfig() {
        ProductModelDetailsConfig config = new ProductModelDetailsConfig();
        config.setVisibleOnSetValueNull(false);
        config.setDefaultValue(null);
        config.setProductModelNameConfig(DetailsConfigurations.getProductNameConfig());
        config.setBareCodeConfig(DetailsConfigurations.getBareCodeConfig());
        config.setQuantityUnitConfig(DetailsConfigurations.getQuantityUnitConfig());
        config.setProductGroupNameConfig(DetailsConfigurations.getProductGroupNameConfig());
        config.setPriceDetailsConfig(DetailsConfigurations.getPriceConfig());
        return config;
    }
}
