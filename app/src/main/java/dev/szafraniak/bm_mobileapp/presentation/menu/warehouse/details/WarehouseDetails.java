package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse.details;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.EditTextViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.models.address.AddressDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.text.TextTextViewDetails;

public class WarehouseDetails extends BaseDetails<Warehouse, BaseViewHolder, WarehouseDetailsConfig> {

    @LayoutRes
    private final int layoutId = R.layout.form_base_group;

    TextTextViewDetails nameDetails;
    AddressDetails addressDetails;

    public WarehouseDetails(LayoutInflater inflater, ViewGroup viewGroup, WarehouseDetailsConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(Warehouse value) {
        if (value == null) {
            nameDetails.setValue(null);
            addressDetails.setValue(null);
            return;
        }
        nameDetails.setValue(value.getName());
        addressDetails.setValue(value.getAddress());
    }

    @Override
    protected EditTextViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, WarehouseDetailsConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        nameDetails = new TextTextViewDetails(inflater, groupList, config.getWarehouseNameConfig());
        addressDetails = new AddressDetails(inflater, groupList, config.getAddressDetailsConfig());

        groupList.addView(nameDetails.getView());
        groupList.addView(addressDetails.getView());

        EditTextViewHolder holder = new EditTextViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(WarehouseDetailsConfig config) {
        // Dodatkowa konfiguracja
    }


}

