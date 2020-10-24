package dev.szafraniak.bm_mobileapp.presentation.menu.product.create;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.List;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.CreateProductRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class ProductCreateFragment extends BaseFormFragment<CreateProductRequest, CreateProductFormConfig> implements ProductCreateView {

    public static final String KEY_WAREHOUSE = "KEY_WAREHOUSE";

    @Inject
    ProductCreatePresenter presenter;

    @Inject
    Gson gson;

    private Warehouse warehouse;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        fetchArgumentsData();
        presenter.setView(this);
    }

    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_WAREHOUSE)) {
            Navigator.back(this);
            return;
        }
        String companyJSON = args.getString(KEY_WAREHOUSE);
        warehouse = gson.fromJson(companyJSON, Warehouse.class);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_create_form;
    }

    @Override
    protected FormInterface<CreateProductRequest> createForm(LayoutInflater inflater, ViewGroup linearLayout, CreateProductFormConfig config) {
        return new CreateProductForm(inflater, linearLayout, config);
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    public void setData(List<ProductModel> models) {
        CreateProductFormConfig config = presenter.createConfig(models);
        startForm(config);
    }

    @Override
    public void onError(Throwable throwable) {
        setError(throwable);
    }

    @Override
    protected void onSubmit(CreateProductRequest object) {
        object.setWarehouseId(warehouse.getId());
        presenter.createProduct(object);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_product_create;
    }
}
