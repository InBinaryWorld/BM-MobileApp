package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.modify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.UpdateProductModelRequest;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class ProductModelModifyFragment extends BaseFormFragment<UpdateProductModelRequest, ModifyProductModelFormConfig> implements ProductModelModifyView {

    public final static String KEY_PRODUCT_MODEL = "PRODUCT_MODEL_KEY";

    @Inject
    ProductModelModifyPresenter presenter;

    @Inject
    Gson gson;

    ProductModel productModel;

    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_PRODUCT_MODEL)) {
            Navigator.back(this);
            return;
        }
        String companyJSON = args.getString(KEY_PRODUCT_MODEL);
        productModel = gson.fromJson(companyJSON, ProductModel.class);
    }

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        fetchArgumentsData();
        presenter.setView(this);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.header_product_model_modify;
    }

    @Override
    protected FormInterface<UpdateProductModelRequest> createForm(
        LayoutInflater inflater, ViewGroup linearLayout, ModifyProductModelFormConfig config) {
        return new ModifyProductModelForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(UpdateProductModelRequest object) {
        presenter.modifyProductModel(object, productModel.getId());
    }

    protected int getHeaderTextResourceId() {
        return R.string.header_product_model_modify;
    }

    @Override
    protected void loadData() {
        presenter.loadData(productModel.getId());
    }

    @Override
    public void setModifyModel(ProductModel productModel) {
        UpdateProductModelRequest model = new UpdateProductModelRequest();
        model.setName(productModel.getName());
        model.setBarcode(productModel.getBarcode());
        model.setQuantityUnit(productModel.getQuantityUnit());
        model.setPriceSuggestion(productModel.getPriceSuggestion());

        ModifyProductModelFormConfig config = presenter.createConfig();
        startForm(config, model);
    }
}
