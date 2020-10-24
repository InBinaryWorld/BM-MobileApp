package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.product.ProductAutoCompleteForm;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.service.ServiceAutoCompleteForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.baseType.BaseTypeForm;

public class InvoiceItemForm extends BaseForm<InvoiceItemFormModel, InvoiceItemViewHolder, InvoiceItemFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group_with_padding;

    BaseTypeForm<ItemType> itemTypeForm;
    ProductAutoCompleteForm productForm;
    ServiceAutoCompleteForm serviceForm;


    public InvoiceItemForm(LayoutInflater inflater, ViewGroup viewGroup, InvoiceItemFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    public InvoiceItemFormModel getValue() {
        ItemType type = itemTypeForm.getValue();
        if (ItemType.PRODUCT.equals(type)) {
            return productForm.getValue();
        } else if (ItemType.SERVICE.equals(type)) {
            return serviceForm.getValue();
        }
        return null;
    }

    @Override
    public boolean isValid() {
        ItemType type = itemTypeForm.getValue();
        return ItemType.PRODUCT.equals(type) && productForm.isValid()
            || ItemType.SERVICE.equals(type) && serviceForm.isValid();
    }

    @Override
    protected void showValueOnView(InvoiceItemFormModel value) {
        if (value == null) {
            return;
        }
        ItemType type = value.getType();
        itemTypeForm.setValue(type);
        if (ItemType.PRODUCT.equals(type)) {
            productForm.setValue(value);
        } else {
            serviceForm.setValue(value);
        }
    }

    @Override
    protected InvoiceItemViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, InvoiceItemFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        itemTypeForm = new BaseTypeForm<ItemType>(inflater, groupList, config.getItemTypeForm());
        productForm = new ProductAutoCompleteForm(inflater, groupList, config.getProductConfig());
        serviceForm = new ServiceAutoCompleteForm(inflater, groupList, config.getServiceConfig());

        View productFormView = productForm.getView();
        View serviceFormView = serviceForm.getView();
        groupList.addView(itemTypeForm.getView());
        groupList.addView(serviceFormView);
        groupList.addView(productFormView);

        InvoiceItemViewHolder holder = new InvoiceItemViewHolder();
        holder.view = groupList;
        holder.serviceView = serviceFormView;
        holder.productView = productFormView;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, InvoiceItemFormConfig config) {
        itemTypeForm.setOnValueChange(this::onTypeChange);
        productForm.setOnValidationStateChanged(this::onValueChange);
        serviceForm.setOnValidationStateChanged(this::onValueChange);
    }

    private void onTypeChange(boolean isValid) {
        InvoiceItemViewHolder holder = getViewHolder();
        boolean isProduct = ItemType.PRODUCT.equals(itemTypeForm.getValue());
        holder.productView.setVisibility(isProduct ? View.VISIBLE : View.GONE);
        holder.serviceView.setVisibility(!isProduct ? View.VISIBLE : View.GONE);
        onValueChange();
    }

}
