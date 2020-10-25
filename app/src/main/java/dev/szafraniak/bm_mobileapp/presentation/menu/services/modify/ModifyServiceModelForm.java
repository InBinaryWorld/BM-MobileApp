package dev.szafraniak.bm_mobileapp.presentation.menu.services.modify;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.UpdateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.price.PriceForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;

public class ModifyServiceModelForm extends BaseForm<UpdateServiceModelRequest, BaseViewHolder, ModifyServiceModelFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group_with_padding;

    TextEditTextFormRow nameFormRow;
    TextEditTextFormRow quantityUnitFormRow;
    PriceForm priceForm;


    public ModifyServiceModelForm(LayoutInflater inflater, ViewGroup viewGroup, ModifyServiceModelFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(UpdateServiceModelRequest value) {
        if (value == null) {
            nameFormRow.setValue(null);
            quantityUnitFormRow.setValue(null);
            priceForm.setValue(null);
            return;
        }
        nameFormRow.setValue(value.getName());
        quantityUnitFormRow.setValue(value.getQuantityUnit());
        priceForm.setValue(value.getPriceSuggestion());
    }

    @Override
    public UpdateServiceModelRequest getValue() {
        String name = nameFormRow.getValue();
        String quantityUnit = quantityUnitFormRow.getValue();
        Price price = priceForm.getValue();
        if (name == null && quantityUnit == null && price == null) {
            return null;
        }
        UpdateServiceModelRequest model = new UpdateServiceModelRequest();
        model.setName(name);
        model.setQuantityUnit(quantityUnit);
        model.setPriceSuggestion(price);
        return model;
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, ModifyServiceModelFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        nameFormRow = new TextEditTextFormRow(inflater, groupList, config.getNameConfig());
        quantityUnitFormRow = new TextEditTextFormRow(inflater, groupList, config.getQuantityUniteConfig());
        priceForm = new PriceForm(inflater, groupList, config.getPriceFormConfig());

        groupList.addView(nameFormRow.getView());
        groupList.addView(quantityUnitFormRow.getView());
        groupList.addView(priceForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, ModifyServiceModelFormConfig config) {
        nameFormRow.setOnValidationStateChanged(this::onValueChange);
        quantityUnitFormRow.setOnValidationStateChanged(this::onValueChange);
        priceForm.setOnValidationStateChanged(this::onValueChange);
    }


    @Override
    public boolean isValid() {
        return nameFormRow.isValid() && quantityUnitFormRow.isValid() && priceForm.isValid();
    }
}


