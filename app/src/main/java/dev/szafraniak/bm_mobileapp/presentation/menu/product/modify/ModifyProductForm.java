package dev.szafraniak.bm_mobileapp.presentation.menu.product.modify;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.UpdateProductRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.text.TextTextViewDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.number.DecimalEditTextFormRow;

public class ModifyProductForm extends BaseForm<UpdateProductRequest, BaseViewHolder, ModifyProductFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group_with_padding;

    TextTextViewDetails nameDetails;
    TextTextViewDetails barCodeDetails;
    DecimalEditTextFormRow quantityFormRow;

    public ModifyProductForm(LayoutInflater inflater, ViewGroup viewGroup, ModifyProductFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(UpdateProductRequest value) {
        if (value == null) {
            quantityFormRow.setValue(null);
            return;
        }
        quantityFormRow.setValue(value.getQuantity());
    }

    @Override
    public UpdateProductRequest getValue() {
        BigDecimal quantity = quantityFormRow.getValue();
        if (quantity == null) {
            return null;
        }
        UpdateProductRequest model = new UpdateProductRequest();
        model.setQuantity(quantity);
        return model;
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, ModifyProductFormConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        nameDetails = new TextTextViewDetails(inflater, groupList, config.getNameConfig());
        barCodeDetails = new TextTextViewDetails(inflater, groupList, config.getBarCodeConfig());
        quantityFormRow = new DecimalEditTextFormRow(inflater, groupList, config.getQuantityFormConfig());

        groupList.addView(nameDetails.getView());
        groupList.addView(barCodeDetails.getView());
        groupList.addView(quantityFormRow.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, ModifyProductFormConfig config) {
        nameDetails.setValue(config.getProduct().getProductModel().getName());
        barCodeDetails.setValue(config.getProduct().getProductModel().getBarcode());

        quantityFormRow.setOnValidationStateChanged(this::onValueChange);
    }

    @Override
    public boolean isValid() {
        return quantityFormRow.isValid();
    }
}


