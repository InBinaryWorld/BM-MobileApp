package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
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

@EFragment(R.layout.fragment_base_list_with_btn)
public class WarehouseListFragment extends BaseListFragmentWithBtn<Warehouse, WarehouseListAdapter>
        implements WarehouseListView {

    @Inject
    WarehouseListPresenter presenter;

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
        return R.string.header_warehouse_list;
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_text_warehouse_list;
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
    protected WarehouseListAdapter createAdapter() {
        return new WarehouseListAdapter(LayoutInflater.from(getContext()), new ArrayList<>());
    }

    @Override
    public void onItemClick(Warehouse item) {
        Bundle args = new Bundle();
        args.putString(WarehouseDetailsFragment.KEY_WAREHOUSE, gson.toJson(item));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_WAREHOUSE_DETAILS, args);
    }

}
