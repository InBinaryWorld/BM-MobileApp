package dev.szafraniak.bm_mobileapp.presentation.menu.product.create;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.CreateProductRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.FormInterface;

@EFragment(R.layout.fragment_product_form)
public class ProductCreateFragment extends BaseFormFragment<CreateProductRequest, CreateProductFormConfig> implements ProductCreateView {

    public static final String KEY_WAREHOUSE = "KEY_WAREHOUSE";

    @ViewById(R.id.view_no_product_models)
    View noModelsView;

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
        return R.string.btn_save;
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
        if (models.size() == 0) {
            showOnNoModelsView();
            return;
        }
        CreateProductFormConfig config = presenter.createConfig(models);
        startForm(config);

    }

    @Override
    protected void showFirstProgress() {
        noModelsView.setVisibility(View.GONE);
        super.showFirstProgress();
    }

    protected void showOnNoModelsView() {
        errorView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        noModelsView.setVisibility(View.VISIBLE);
        dataContainerView.setVisibility(View.GONE);
        setRefreshEnabled(true);
        hideSRLRefreshing();
    }

    @Override
    protected void viewOnSRLRefresh() {
        noModelsView.setVisibility(View.GONE);
        super.viewOnSRLRefresh();
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
