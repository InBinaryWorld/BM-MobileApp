package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.CreateProductModelRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.price.PriceForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.barcode.BarcodeFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;

public class CreateProductModelForm extends BaseForm<CreateProductModelRequest, BaseViewHolder, CreateProductModelFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group_with_padding;

    BarcodeFormRow barcodeFormRow;
    TextEditTextFormRow nameFormRow;
    TextEditTextFormRow quantityUnitFormRow;
    PriceForm priceForm;


    public CreateProductModelForm(LayoutInflater inflater, ViewGroup viewGroup, CreateProductModelFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(CreateProductModelRequest value) {
        if (value == null) {
            nameFormRow.setValue(null);
            barcodeFormRow.setValue(null);
            quantityUnitFormRow.setValue(null);
            priceForm.setValue(null);
            return;
        }
        nameFormRow.setValue(value.getName());
        barcodeFormRow.setValue(value.getBarcode());
        quantityUnitFormRow.setValue(value.getQuantityUnit());
        priceForm.setValue(value.getPriceSuggestion());
    }

    @Override
    public CreateProductModelRequest getValue() {
        String name = nameFormRow.getValue();
        String barcode = barcodeFormRow.getValue();
        String quantityUnit = quantityUnitFormRow.getValue();
        Price price = priceForm.getValue();
        if (name == null && quantityUnit == null && barcode == null && price == null) {
            return null;
        }
        CreateProductModelRequest model = new CreateProductModelRequest();
        model.setName(name);
        model.setBarcode(barcode);
        model.setQuantityUnit(quantityUnit);
        model.setPriceSuggestion(price);
        return model;
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, CreateProductModelFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        nameFormRow = new TextEditTextFormRow(inflater, groupList, config.getNameConfig());
        barcodeFormRow = new BarcodeFormRow(inflater, groupList, config.getBarcodeConfig());
        quantityUnitFormRow = new TextEditTextFormRow(inflater, groupList, config.getQuantityUniteConfig());
        priceForm = new PriceForm(inflater, groupList, config.getPriceFormConfig());

        groupList.addView(nameFormRow.getView());
        groupList.addView(barcodeFormRow.getView());
        groupList.addView(quantityUnitFormRow.getView());
        groupList.addView(priceForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, CreateProductModelFormConfig config) {
        nameFormRow.setOnValidationStateChanged(this::onValueChange);
        barcodeFormRow.setOnValidationStateChanged(this::onValueChange);
        quantityUnitFormRow.setOnValidationStateChanged(this::onValueChange);
        priceForm.setOnValidationStateChanged(this::onValueChange);
    }


    @Override
    public boolean isValid() {
        return nameFormRow.isValid() && quantityUnitFormRow.isValid() && barcodeFormRow.isValid() && priceForm.isValid();
    }
}


