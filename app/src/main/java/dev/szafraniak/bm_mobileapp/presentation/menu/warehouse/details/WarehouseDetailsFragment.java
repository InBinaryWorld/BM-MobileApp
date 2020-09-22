package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

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
import dev.szafraniak.bm_mobileapp.presentation.shared.details.BaseDetailsFragmentWithBtn;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.config.DetailsConfig;

@EFragment(R.layout.fragment_base_details)
public class WarehouseDetailsFragment extends BaseDetailsFragmentWithBtn<Warehouse>
        implements WarehouseDetailsView {

    public final static String KEY_WAREHOUSE = "KEY_WAREHOUSE";

    @Inject
    WarehouseDetailsPresenter presenter;

    @Inject
    Gson gson;

    Warehouse warehouse;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null || !getArguments().containsKey(KEY_WAREHOUSE)) {
            Navigator.back(this);
        }
        String companyJSON = getArguments().getString(KEY_WAREHOUSE);
        warehouse = gson.fromJson(companyJSON, Warehouse.class);
    }

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_warehouse_details;
    }

    @Override
    protected int getFblBtnTextResourceId() {
        return R.string.fragment_warehouse_details_fl_btn_text;
    }

    @Override
    protected void onFblClick(View view) {
        Bundle args = new Bundle();
        args.putString(WarehouseModifyFragment.KEY_WAREHOUSE, gson.toJson(warehouse));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_WAREHOUSE_MODIFY, args);
    }

    @Override
    protected void loadData() {
        presenter.loadData(warehouse.getId());
    }

    @Override
    protected DetailsConfig<Warehouse> createDetailsConfig() {
        return new WarehouseDetailsConfig(inflater, layout);
    }
}
