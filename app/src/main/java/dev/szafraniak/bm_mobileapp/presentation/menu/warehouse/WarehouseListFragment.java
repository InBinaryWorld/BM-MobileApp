package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse;

import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details.WarehouseDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragmentWithBtn;

@EFragment(R.layout.fragment_base_list_with_btn)
public class WarehouseListFragment extends BaseListFragmentWithBtn<Warehouse>
        implements WarehouseListView {

    @Inject
    WarehouseListPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        firstLoadData();
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_warehouse_list;
    }

    @Override
    protected int getFlButtonTextId() {
        return R.string.warehouse_list_fl_btn_text;
    }

    @Override
    protected void onFlButtonClick(View view) {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_WAREHOUSE_CREATE);
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    protected BaseAdapter<Warehouse> createAdapter() {
        return new WarehouseListAdapter(getContext());
    }

    @Override
    public void onItemClick(Warehouse item) {
        Bundle args = new Bundle();
        args.putString(WarehouseDetailsFragment.KEY_WAREHOUSE, new Gson().toJson(item));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_WAREHOUSE_DETAILS, args);
    }

}
