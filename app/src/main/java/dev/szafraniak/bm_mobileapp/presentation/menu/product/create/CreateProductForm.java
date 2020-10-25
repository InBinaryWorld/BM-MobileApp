package dev.szafraniak.bm_mobileapp.presentation.menu.product.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.CreateProductRequest;
import dev.szafraniak.bm_mobileapp.presentation.menu.product.create.model.ProductModelSpinnerForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.number.DecimalEditTextFormRow;

public class CreateProductForm extends BaseForm<CreateProductRequest, BaseViewHolder, CreateProductFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group_with_padding;

    ProductModelSpinnerForm productModelForm;
    DecimalEditTextFormRow quantity;


    public CreateProductForm(LayoutInflater inflater, ViewGroup viewGroup, CreateProductFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {

    }

    @Override
    protected void showValueOnView(CreateProductRequest value) {
        if (value == null) {
            productModelForm.setValue(null);
            quantity.setValue(null);
            return;
        }
        productModelForm.setValue(value.getProductModelId());
        quantity.setValue(value.getQuantity());
    }

    @Override
    public CreateProductRequest getValue() {
        Long productModelId = productModelForm.getValue();
        BigDecimal quantityValue = quantity.getValue();
        if (productModelId == null && quantityValue == null) {
            return null;
        }
        CreateProductRequest model = new CreateProductRequest();
        model.setProductModelId(productModelId);
        model.setQuantity(quantityValue);
        return model;
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, CreateProductFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        productModelForm = new ProductModelSpinnerForm(inflater, groupList, config.getProductModelConfig());
        quantity = new DecimalEditTextFormRow(inflater, groupList, config.getQuantityConfig());

        groupList.addView(productModelForm.getView());
        groupList.addView(quantity.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, CreateProductFormConfig config) {
        productModelForm.setOnValidationStateChanged(this::onValueChange);
        quantity.setOnValidationStateChanged(this::onValueChange);
    }


    @Override
    public boolean isValid() {
        return productModelForm.isValid() && quantity.isValid();
    }
}


