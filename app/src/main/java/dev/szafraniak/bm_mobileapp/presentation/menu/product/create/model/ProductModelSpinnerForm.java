package dev.szafraniak.bm_mobileapp.presentation.menu.product.create.model;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.spinner.BaseSpinnerAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.spinner.BaseSpinnerFormRow;

public class ProductModelSpinnerForm extends BaseSpinnerFormRow<ProductModel, Long, ProductModelSpinnerFormConfig> {
    public ProductModelSpinnerForm(LayoutInflater inflater, ViewGroup viewGroup, ProductModelSpinnerFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected BaseSpinnerAdapter<ProductModel, Long> createAdapter(LayoutInflater inflater, ProductModelSpinnerFormConfig config) {
        return new ProductModelSpinnerAdapter(inflater, config);
    }

    @Override
    protected int getPositionByValue(BaseSpinnerAdapter<ProductModel, Long> spinnerAdapter, Long value) {
        return spinnerAdapter.getPositionById(value);
    }

}
