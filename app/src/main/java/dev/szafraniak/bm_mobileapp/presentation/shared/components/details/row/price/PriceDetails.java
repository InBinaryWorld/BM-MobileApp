package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.price;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.BaseDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.number.IntegerTextViewDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.number.PriceTextViewDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.EditTextViewHolder;

public class PriceDetails extends BaseDetails<Price, BaseViewHolder, PriceDetailsConfig> {

    @LayoutRes
    private final int layoutId = R.layout.form_base_group;

    PriceTextViewDetails netRow;
    IntegerTextViewDetails taxRow;
    PriceTextViewDetails grossRow;

    public PriceDetails(LayoutInflater inflater, ViewGroup viewGroup, PriceDetailsConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(Price value) {
        if (value == null) {
            netRow.setValue(null);
            taxRow.setValue(null);
            grossRow.setValue(null);
            return;
        }
        netRow.setValue(value.getNet());
        taxRow.setValue(value.getTaxRate());
        grossRow.setValue(value.getGross());
    }

    @Override
    protected EditTextViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, PriceDetailsConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        netRow = new PriceTextViewDetails(inflater, groupList, config.getNetConfig());
        taxRow = new IntegerTextViewDetails(inflater, groupList, config.getTaxConfig());
        grossRow = new PriceTextViewDetails(inflater, groupList, config.getGrossConfig());

        groupList.addView(netRow.getView());
        groupList.addView(taxRow.getView());
        groupList.addView(grossRow.getView());

        EditTextViewHolder holder = new EditTextViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, PriceDetailsConfig config) {
        // Dodatkowa konfiguracja
    }

}

