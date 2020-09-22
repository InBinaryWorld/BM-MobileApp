package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.UpdateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;

@EFragment(R.layout.fragment_base_form)
public class WarehouseModifyFragment extends BaseFormFragment<UpdateWarehouseRequest> implements WarehouseModifyView {

    public final static String KEY_WAREHOUSE = "WAREHOUSE_KEY";

    @Inject
    WarehouseModifyPresenter presenter;

    @Inject
    Gson gson;

    Warehouse contact;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null || !getArguments().containsKey(KEY_WAREHOUSE)) {
            Navigator.back(this);
        }
        String companyJSON = getArguments().getString(KEY_WAREHOUSE);
        contact = gson.fromJson(companyJSON, Warehouse.class);
    }

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        super.initialize();
    }

    @Override
    protected UpdateWarehouseRequest getFormModel() {
        UpdateWarehouseRequest model = new UpdateWarehouseRequest();
        model.setAddress(new Address());
        return model;
    }

    @Override
    protected void onSubmit(UpdateWarehouseRequest object) {
        presenter.updateWarehouse(object, contact.getId());
    }

    @Override
    protected FormConfig<UpdateWarehouseRequest> createFormConfig() {
        return new WarehouseModifyFormConfig(inflater, formLayout, contact);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_modify_warehouse;
    }
}
