package dev.szafraniak.bm_mobileapp.presentation.menu.resources;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details.WarehouseDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragmentWithBtn;

import static dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory.FRAGMENT_PRODUCT_MODEL_LIST;
import static dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory.FRAGMENT_SERVICE_MODEL_LIST;

@EFragment(R.layout.fragment_resources)
public class ResourcesFragment extends BaseListFragmentWithBtn<Warehouse, ResourcesListAdapter> implements ResourcesView {

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
        return R.string.btn_text_resources;
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
    protected ResourcesListAdapter createAdapter() {
        return new ResourcesListAdapter(LayoutInflater.from(getContext()), new ArrayList<>());
    }

    @Click(R.id.btn_products)
    public void productsClick() {
        Navigator.navigateTo(this, FRAGMENT_PRODUCT_MODEL_LIST);
    }

    @Click(R.id.btn_services)
    public void servicesClick() {
        Navigator.navigateTo(this, FRAGMENT_SERVICE_MODEL_LIST);
    }

    @Override
    public void onItemClick(Warehouse item) {
        Bundle args = new Bundle();
        args.putString(WarehouseDetailsFragment.KEY_WAREHOUSE, gson.toJson(item));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_WAREHOUSE_DETAILS, args);
    }

}

