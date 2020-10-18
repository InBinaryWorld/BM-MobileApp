package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.AutoCompleteTextViewViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.BaseAutoCompleteListAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.text.TextAutoCompleteTextForm;

public class ProductNameAutoCompleteForm extends TextAutoCompleteTextForm<ProductModel> {

    private Callback onScannerClick;

    public ProductNameAutoCompleteForm(LayoutInflater inflater, ViewGroup viewGroup, AutoCompleteTextFormConfig<String, ProductModel> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.row_form_invoice_create_product_name;
    }

    @Override
    protected BaseAutoCompleteListAdapter<ProductModel> createAdapter(LayoutInflater inflater, AutoCompleteTextFormConfig<String, ProductModel> config) {
        return new productNameAutoCompleteAdapter(inflater, config.getListItems());
    }

    @Override
    protected void setupView(LayoutInflater inflater, AutoCompleteTextFormConfig<String, ProductModel> config) {
        super.setupView(inflater, config);
        AutoCompleteTextViewViewHolder holder = getViewHolder();
        View icon = holder.view.findViewById(R.id.iv_scanner);
        icon.setOnClickListener(view -> {
            if (onScannerClick != null) {
                onScannerClick.call();
            }
        });
    }

    public void setOnScannerIconClick(Callback onScannerClick) {
        this.onScannerClick = onScannerClick;
    }

}
