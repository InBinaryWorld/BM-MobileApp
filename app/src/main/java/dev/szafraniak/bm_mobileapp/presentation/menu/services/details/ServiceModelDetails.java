package dev.szafraniak.bm_mobileapp.presentation.menu.services.details;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.EditTextViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.models.price.PriceDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.text.TextTextViewDetails;

public class ServiceModelDetails extends BaseDetails<ServiceModel, BaseViewHolder, ServiceModelDetailsConfig> {

    @LayoutRes
    private final int layoutId = R.layout.form_base_group;

    TextTextViewDetails nameRow;
    TextTextViewDetails quantityUnitRow;
    PriceDetails priceDetails;

    public ServiceModelDetails(LayoutInflater inflater, ViewGroup viewGroup, ServiceModelDetailsConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(ServiceModel value) {
        if (value == null) {
            nameRow.setValue(null);
            quantityUnitRow.setValue(null);
            priceDetails.setValue(null);
            return;
        }
        nameRow.setValue(value.getName());
        quantityUnitRow.setValue(value.getQuantityUnit());
        priceDetails.setValue(value.getPriceSuggestion());
    }

    @Override
    protected EditTextViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, ServiceModelDetailsConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        nameRow = new TextTextViewDetails(inflater, groupList, config.getServiceModelNameConfig());
        quantityUnitRow = new TextTextViewDetails(inflater, groupList, config.getQuantityUnitConfig());
        priceDetails = new PriceDetails(inflater, groupList, config.getPriceDetailsConfig());

        groupList.addView(nameRow.getView());
        groupList.addView(quantityUnitRow.getView());
        groupList.addView(priceDetails.getView());

        EditTextViewHolder holder = new EditTextViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(ServiceModelDetailsConfig config) {
        // Dodatkowa konfiguracja
    }


}

