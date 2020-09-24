package dev.szafraniak.bm_mobileapp.presentation.menu.products.details;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.IdNameEntity;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.EditTextViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.models.price.PriceDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.text.TextTextViewDetails;

public class ProductModelDetails extends BaseDetails<ProductModel, BaseViewHolder, ProductModelDetailsConfig> {

    @LayoutRes
    private final int layoutId = R.layout.form_base_group;

    TextTextViewDetails nameRow;
    TextTextViewDetails bareCodeRow;
    TextTextViewDetails quantityUnitRow;
    TextTextViewDetails productGroupNameRow;
    PriceDetails priceDetails;

    public ProductModelDetails(LayoutInflater inflater, ViewGroup viewGroup, ProductModelDetailsConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(ProductModel value) {
        if (value == null) {
            nameRow.setValue(null);
            bareCodeRow.setValue(null);
            quantityUnitRow.setValue(null);
            productGroupNameRow.setValue(null);
            priceDetails.setValue(null);
            return;
        }
        IdNameEntity group = value.getProductGroup();
        nameRow.setValue(value.getName());
        bareCodeRow.setValue(value.getBareCode());
        quantityUnitRow.setValue(value.getQuantityUnit());
        productGroupNameRow.setValue(group != null ? group.getName() : null);
        priceDetails.setValue(value.getPriceSuggestion());
    }

    @Override
    protected EditTextViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, ProductModelDetailsConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        nameRow = new TextTextViewDetails(inflater, groupList, config.getProductModelNameConfig());
        bareCodeRow = new TextTextViewDetails(inflater, groupList, config.getBareCodeConfig());
        quantityUnitRow = new TextTextViewDetails(inflater, groupList, config.getQuantityUnitConfig());
        productGroupNameRow = new TextTextViewDetails(inflater, groupList, config.getProductGroupNameConfig());
        priceDetails = new PriceDetails(inflater, groupList, config.getPriceDetailsConfig());

        groupList.addView(nameRow.getView());
        groupList.addView(bareCodeRow.getView());
        groupList.addView(quantityUnitRow.getView());
        groupList.addView(productGroupNameRow.getView());
        groupList.addView(priceDetails.getView());

        EditTextViewHolder holder = new EditTextViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(ProductModelDetailsConfig config) {
        // Dodatkowa konfiguracja
    }


}

