package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify.WarehouseModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.DetailsInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.fragment.BaseDetailsFragmentWithBtn;

@EFragment(R.layout.fragment_base_details)
public class WarehouseDetailsFragment extends BaseDetailsFragmentWithBtn<Warehouse, WarehouseDetailsConfig>
    implements WarehouseDetailsView {

    public final static String KEY_WAREHOUSE = "KEY_WAREHOUSE";

    @Inject
    WarehouseDetailsPresenter presenter;

    @Inject
    Gson gson;

    Warehouse warehouse;

    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_WAREHOUSE)) {
            Navigator.back(this);
            return;
        }
        String companyJSON = getArguments().getString(KEY_WAREHOUSE);
        warehouse = gson.fromJson(companyJSON, Warehouse.class);
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
    protected void loadData() {
        presenter.loadData(warehouse.getId());
    }

    public void setData(Warehouse model) {
        WarehouseDetailsConfig config = presenter.createConfig();
        startForm(config, model);
    }

    @Override
    protected DetailsInterface<Warehouse> createForm(LayoutInflater inflater, ViewGroup viewGroup, WarehouseDetailsConfig config) {
        return new WarehouseDetails(inflater, detailsLayout, config);
    }

    @Override
    protected void onFblClick() {
        Bundle args = new Bundle();
        args.putString(WarehouseModifyFragment.KEY_WAREHOUSE, gson.toJson(warehouse));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_WAREHOUSE_MODIFY, args);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_warehouse_details;
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_warehouse_details;
    }

}
