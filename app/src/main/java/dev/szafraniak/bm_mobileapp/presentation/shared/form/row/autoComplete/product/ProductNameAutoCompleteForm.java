package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.product;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.BaseAutoCompleteListAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.text.TextAutoCompleteTextForm;

public class ProductNameAutoCompleteForm extends TextAutoCompleteTextForm<ProductModel> {

    public ProductNameAutoCompleteForm(LayoutInflater inflater, ViewGroup viewGroup, AutoCompleteTextFormConfig<String, ProductModel> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected BaseAutoCompleteListAdapter<ProductModel> createAdapter(LayoutInflater inflater, AutoCompleteTextFormConfig<String, ProductModel> config) {
        return new productNameAutoCompleteAdapter(inflater, config.getListItems());
    }

}
