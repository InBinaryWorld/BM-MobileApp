package dev.szafraniak.bm_mobileapp.presentation.menu.services.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.CreateServiceModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.models.price.PriceForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;

public class CreateServiceForm extends BaseForm<CreateServiceModelRequest, BaseViewHolder, CreateServiceFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    TextEditTextFormRow nameFormRow;
    TextEditTextFormRow quantityUnitFormRow;
    PriceForm priceForm;


    public CreateServiceForm(LayoutInflater inflater, ViewGroup viewGroup, CreateServiceFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(CreateServiceModelRequest value) {
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
    public CreateServiceModelRequest getValue() {
        String name = nameFormRow.getValue();
        String quantityUnit = quantityUnitFormRow.getValue();
        Price price = priceForm.getValue();
        if (name == null && quantityUnit == null && price == null) {
            return null;
        }
        CreateServiceModelRequest model = new CreateServiceModelRequest();
        model.setName(name);
        model.setQuantityUnit(quantityUnit);
        model.setPriceSuggestion(price);
        return model;
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, CreateServiceFormConfig config) {

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
    protected void setupView(CreateServiceFormConfig config) {
        nameFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        quantityUnitFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        priceForm.setOnValidationStateChanged(this::onFieldStateChanged);
    }

    private void onFieldStateChanged(boolean b) {
        onValueChange();
    }

    @Override
    public boolean isValid() {
        return nameFormRow.isValid() && quantityUnitFormRow.isValid() && priceForm.isValid();
    }
}


