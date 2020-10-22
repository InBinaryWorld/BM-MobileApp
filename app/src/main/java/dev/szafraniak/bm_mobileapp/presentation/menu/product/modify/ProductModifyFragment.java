package dev.szafraniak.bm_mobileapp.presentation.menu.product.modify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.UpdateProductRequest;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class ProductModifyFragment extends BaseFormFragment<UpdateProductRequest, ModifyProductFormConfig> implements ProductModifyView {

    public final static String KEY_PRODUCT = "PRODUCT_KEY";

    @Inject
    ProductModifyPresenter presenter;

    @Inject
    Gson gson;

    Product product;

    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_PRODUCT)) {
            Navigator.back(this);
            return;
        }
        String companyJSON = args.getString(KEY_PRODUCT);
        product = gson.fromJson(companyJSON, Product.class);
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
        return R.string.btn_product_modify;
    }

    @Override
    protected FormInterface<UpdateProductRequest> createForm(
        LayoutInflater inflater, ViewGroup linearLayout, ModifyProductFormConfig config) {
        return new ModifyProductForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(UpdateProductRequest object) {
        presenter.modifyProduct(object, product.getId());
    }

    protected int getHeaderTextResourceId() {
        return R.string.header_product_model_modify;
    }

    @Override
    protected void loadData() {
        presenter.loadData(product.getId());
    }

    @Override
    public void setModifyModel(Product product) {
        UpdateProductRequest model = new UpdateProductRequest();
        model.setQuantity(product.getQuantity());

        ModifyProductFormConfig config = presenter.createConfig(product);
        startForm(config, model);
    }
}
