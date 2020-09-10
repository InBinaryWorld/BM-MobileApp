package dev.szafraniak.bm_mobileapp.presentation.menu.products.details;

import android.app.Application;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.BaseDetailsPresenter;

public class ProductModelDetailsPresenter extends BaseDetailsPresenter<ProductModelDetailsView, ProductModel> {

    public ProductModelDetailsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @Override
    public void loadData(ProductModel productModel) {
        view.setData(productModel);
    }
}
