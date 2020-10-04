package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.modify;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.UpdateProductModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.price.PriceForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;

public class ModifyProductModelForm extends BaseForm<UpdateProductModelRequest, BaseViewHolder, ModifyProductModelFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    PriceForm priceForm;
    TextEditTextFormRow nameFormRow;
    TextEditTextFormRow bareCodeFormRow;
    TextEditTextFormRow quantityUnitFormRow;


    public ModifyProductModelForm(LayoutInflater inflater, ViewGroup viewGroup, ModifyProductModelFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {

    }

    @Override
    protected void showValueOnView(UpdateProductModelRequest value) {
        if (value == null) {
            nameFormRow.setValue(null);
            bareCodeFormRow.setValue(null);
            quantityUnitFormRow.setValue(null);
            priceForm.setValue(null);
            return;
        }
        nameFormRow.setValue(value.getName());
        bareCodeFormRow.setValue(value.getBareCode());
        quantityUnitFormRow.setValue(value.getQuantityUnit());
        priceForm.setValue(value.getPriceSuggestion());
    }

    @Override
    public UpdateProductModelRequest getValue() {
        String name = nameFormRow.getValue();
        String bareCode = bareCodeFormRow.getValue();
        String quantityUnit = quantityUnitFormRow.getValue();
        Price price = priceForm.getValue();
        if (name == null && quantityUnit == null && bareCode == null && price == null) {
            return null;
        }
        UpdateProductModelRequest model = new UpdateProductModelRequest();
        model.setName(name);
        model.setBareCode(bareCode);
        model.setQuantityUnit(quantityUnit);
        model.setPriceSuggestion(price);
        return model;
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, ModifyProductModelFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        nameFormRow = new TextEditTextFormRow(inflater, groupList, config.getNameConfig());
        bareCodeFormRow = new TextEditTextFormRow(inflater, groupList, config.getBareCodeConfig());
        quantityUnitFormRow = new TextEditTextFormRow(inflater, groupList, config.getQuantityUniteConfig());
        priceForm = new PriceForm(inflater, groupList, config.getPriceFormConfig());

        groupList.addView(nameFormRow.getView());
        groupList.addView(bareCodeFormRow.getView());
        groupList.addView(quantityUnitFormRow.getView());
        groupList.addView(priceForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, ModifyProductModelFormConfig config) {
        nameFormRow.setOnValidationStateChanged(this::onValueChange);
        bareCodeFormRow.setOnValidationStateChanged(this::onValueChange);
        quantityUnitFormRow.setOnValidationStateChanged(this::onValueChange);
        priceForm.setOnValidationStateChanged(this::onValueChange);
    }

    @Override
    public boolean isValid() {
        return nameFormRow.isValid() && quantityUnitFormRow.isValid() && bareCodeFormRow.isValid() && priceForm.isValid();
    }
}


