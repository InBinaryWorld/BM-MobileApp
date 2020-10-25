package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.modify;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.UpdateWarehouseRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address.AddressForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;

public class ModifyWarehouseForm extends BaseForm<UpdateWarehouseRequest, BaseViewHolder, UpdateWarehouseFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group_with_padding;

    TextEditTextFormRow nameFormRow;
    AddressForm addressForm;


    public ModifyWarehouseForm(LayoutInflater inflater, ViewGroup viewGroup, UpdateWarehouseFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(UpdateWarehouseRequest value) {
        if (value == null) {
            nameFormRow.setValue(null);
            addressForm.setValue(null);
            return;
        }
        nameFormRow.setValue(value.getName());
        addressForm.setValue(value.getAddress());
    }

    @Override
    public UpdateWarehouseRequest getValue() {
        String name = nameFormRow.getValue();
        Address address = addressForm.getValue();
        if (name == null && address == null) {
            return null;
        }
        UpdateWarehouseRequest model = new UpdateWarehouseRequest();
        model.setName(name);
        model.setAddress(address);
        return model;
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, UpdateWarehouseFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        nameFormRow = new TextEditTextFormRow(inflater, groupList, config.getNameConfig());
        addressForm = new AddressForm(inflater, groupList, config.getAddressConfig());

        groupList.addView(nameFormRow.getView());
        groupList.addView(addressForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, UpdateWarehouseFormConfig config) {
        nameFormRow.setOnValidationStateChanged(this::onValueChange);
        addressForm.setOnValidationStateChanged(this::onValueChange);
    }

    @Override
    public boolean isValid() {
        return nameFormRow.isValid() && addressForm.isValid();
    }
}


