package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.UpdateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class WarehouseModifyFragment extends BaseFormFragment<UpdateWarehouseRequest, UpdateWarehouseFormConfig> implements WarehouseModifyView {

    public final static String KEY_WAREHOUSE = "WAREHOUSE_KEY";

    @Inject
    WarehouseModifyPresenter presenter;

    @Inject
    Gson gson;

    Warehouse warehouse;

    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_WAREHOUSE)) {
            Navigator.back(this);
            return;
        }
        String companyJSON = args.getString(KEY_WAREHOUSE);
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
    protected FormInterface<UpdateWarehouseRequest> createForm(LayoutInflater inflater, LinearLayout linearLayout, UpdateWarehouseFormConfig config) {
        return new CreateWarehouseForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(UpdateWarehouseRequest object) {
        presenter.updateWarehouse(object, warehouse.getId());
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_modify_warehouse;
    }

    @Override
    protected void loadData() {
        presenter.loadData(warehouse.getId());
    }

    @Override
    public void setModifyModel(Warehouse warehouse) {
        UpdateWarehouseRequest model = new UpdateWarehouseRequest();
        model.setName(warehouse.getName());
        model.setAddress(warehouse.getAddress());

        UpdateWarehouseFormConfig config = presenter.createConfig();
        startForm(config, model);
    }
}
