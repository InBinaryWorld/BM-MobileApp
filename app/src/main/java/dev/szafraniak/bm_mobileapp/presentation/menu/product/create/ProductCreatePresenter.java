package dev.szafraniak.bm_mobileapp.presentation.menu.product.create;

import android.annotation.SuppressLint;
import android.app.Application;

import java.util.List;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ProductModelService;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ProductService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.CreateProductRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.FormConfigurations;
import lombok.Setter;

public class ProductCreatePresenter {

    @Inject
    ProductService productService;

    @Inject
    ProductModelService productModelService;

    @Inject
    SessionManager sessionManager;

    @Setter
    protected ProductCreateView view;

    public ProductCreatePresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createProduct(CreateProductRequest object) {
        productService.createProduct(sessionManager.getCompanyId(), object)
            .compose(view.bindToLifecycle())
            .subscribe(this::onSuccess, this::onError);
    }

    protected void onError(Throwable throwable) {
        view.setActionFailed(throwable);
    }

    protected void onSuccess(Product object) {
        Navigator.back(view);
    }

    public CreateProductFormConfig createConfig(List<ProductModel> models) {
        return FormConfigurations.getCreateProductFormConfig(view.getContext(), models);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData() {
        Long companyId = sessionManager.getCompanyId();
        productModelService.getProductModels(companyId)
            .compose(view.bindToLifecycle())
            .subscribe(result -> view.setData(result.getItems()), view::onError);
    }
}
