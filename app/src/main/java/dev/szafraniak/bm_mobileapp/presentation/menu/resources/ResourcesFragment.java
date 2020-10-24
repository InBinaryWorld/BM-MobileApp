package dev.szafraniak.bm_mobileapp.presentation.menu.resources;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.business.models.stats.ResourcesStatsModel;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.product.ProductListFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details.WarehouseDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragmentWithBtn;

import static dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory.FRAGMENT_PRODUCT_MODEL_LIST;
import static dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory.FRAGMENT_SERVICE_MODEL_LIST;

@EFragment(R.layout.fragment_resources)
public class ResourcesFragment extends BaseListFragmentWithBtn<Warehouse, ResourcesListAdapter> implements ResourcesView, ResourcesListAdapter.WarehouseDetailsListener {

    @ViewById(R.id.tv_product_models)
    TextView productModels;

    @ViewById(R.id.tv_service_models)
    TextView serviceModels;


    @Inject
    ResourcesPresenter presenter;

    @Inject
    Gson gson;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_resources;
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_resources_list;
    }

    @Override
    protected void onButtonClick(View view) {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_WAREHOUSE_CREATE);
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    @SuppressLint("SetTextI18n")
    public void setData(ResourcesDataModel data) {
        ResourcesStatsModel stats = data.getResourcesStats();
        productModels.setText(Integer.toString(stats.getProductModelsNumber()));
        serviceModels.setText(Integer.toString(stats.getServiceModelsNumber()));
        setData(data.warehouses);
    }

    @Override
    protected ResourcesListAdapter createAdapter() {
        ResourcesListAdapter adapter = new ResourcesListAdapter(LayoutInflater.from(getContext()), new ArrayList<>());
        adapter.setDetailsListener(this);
        return adapter;
    }

    @Click(R.id.card_product_models)
    public void productsClick() {
        Navigator.navigateTo(this, FRAGMENT_PRODUCT_MODEL_LIST);
    }

    @Click(R.id.card_service_models)
    public void servicesClick() {
        Navigator.navigateTo(this, FRAGMENT_SERVICE_MODEL_LIST);
    }

    @Override
    public void onDetailsRequest(Warehouse warehouse) {
        Bundle args = new Bundle();
        args.putString(WarehouseDetailsFragment.KEY_WAREHOUSE, gson.toJson(warehouse));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_WAREHOUSE_DETAILS, args);
    }

    @Override
    public void onItemClick(Warehouse warehouse) {
        Bundle args = new Bundle();
        args.putString(ProductListFragment.KEY_WAREHOUSE, gson.toJson(warehouse));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_PRODUCT_LIST, args);
    }

}

