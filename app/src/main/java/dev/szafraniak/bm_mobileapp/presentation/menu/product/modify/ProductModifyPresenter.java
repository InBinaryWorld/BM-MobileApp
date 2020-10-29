package dev.szafraniak.bm_mobileapp.presentation.menu.product.modify;

import android.annotation.SuppressLint;
import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.api.ProductService;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.UpdateProductRequest;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.FormConfigurations;
import lombok.Setter;

public class ProductModifyPresenter {

    @Inject
    ProductService productService;

    @Inject
    SessionManager sessionManager;

    @Setter
    protected ProductModifyView view;

    public ProductModifyPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void modifyProduct(UpdateProductRequest object, Long productId) {
        Long companyId = sessionManager.getCompanyId();
        productService.modifyProduct(companyId, productId, object)
            .compose(view.bindToLifecycle())
            .subscribe(this::onSuccess, this::onError);
    }

    public ModifyProductFormConfig createConfig(Product product) {
        return FormConfigurations.getModifyProductFormConfig(view.getContext(), product);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(long productId) {
        Long companyId = sessionManager.getCompanyId();
        productService.getProduct(companyId, productId)
            .compose(view.bindToLifecycle())
            .subscribe(view::setModifyModel, view::setError);
    }

    protected void onError(Throwable throwable) {
        view.setActionFailed(throwable);
    }

    protected void onSuccess(Product object) {
        Navigator.back(view);
    }

}
