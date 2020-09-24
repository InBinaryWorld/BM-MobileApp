package dev.szafraniak.bm_mobileapp.presentation.menu.products.modify;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.UpdateProductModelRequest;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class ProductModelModifyFragment extends BaseFormFragment<UpdateProductModelRequest> implements ProductModelModifyView {

    public final static String KEY_PRODUCT_MODEL = "PRODUCT_MODEL_KEY";

    @Inject
    ProductModelModifyPresenter presenter;

    @Inject
    Gson gson;

    ProductModel productModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null || !getArguments().containsKey(KEY_PRODUCT_MODEL)) {
            Navigator.back(this);
        }
        String companyJSON = getArguments().getString(KEY_PRODUCT_MODEL);
        productModel = gson.fromJson(companyJSON, ProductModel.class);
    }

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        super.initialize();
    }

    @Override
    protected UpdateProductModelRequest getFormModel() {
        UpdateProductModelRequest model = new UpdateProductModelRequest();
        model.setPriceSuggestion(new Price());
        return model;
    }

    @Override
    protected void onSubmit(UpdateProductModelRequest object) {
        presenter.modifyProductModel(object, productModel.getId());
    }

    @Override
    protected FormConfig<UpdateProductModelRequest> createFormConfig() {
        return new ProductModelModifyFormConfig(inflater, formLayout, productModel);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_product_model_modify;
    }
}
