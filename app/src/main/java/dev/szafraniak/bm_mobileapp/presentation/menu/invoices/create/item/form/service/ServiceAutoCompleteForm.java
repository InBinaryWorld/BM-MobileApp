package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.service;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.type.ItemType;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.price.PriceForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.service.ServiceNameAutoCompleteForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.number.DecimalEditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;

public class ServiceAutoCompleteForm extends BaseForm<InvoiceItemFormModel, BaseViewHolder, ServiceAutoCompleteFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    ServiceNameAutoCompleteForm serviceNameForm;
    DecimalEditTextFormRow quantityForm;
    TextEditTextFormRow quantityUnitForm;
    PriceForm priceForm;

    public ServiceAutoCompleteForm(LayoutInflater inflater, ViewGroup viewGroup, ServiceAutoCompleteFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(InvoiceItemFormModel value) {
        if (value == null) {
            serviceNameForm.setValue(null);
            quantityUnitForm.setValue(null);
            quantityForm.setValue(null);
            priceForm.setValue(null);
            return;
        }
        serviceNameForm.setValue(value.getName());
        quantityUnitForm.setValue(value.getQuantityUnit());
        quantityForm.setValue(value.getQuantity());
        priceForm.setValue(value.getPrice());
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, ServiceAutoCompleteFormConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        serviceNameForm = new ServiceNameAutoCompleteForm(inflater, groupList, config.getServiceNameConfig());
        quantityUnitForm = new TextEditTextFormRow(inflater, groupList, config.getQuantityUnitConfig());
        quantityForm = new DecimalEditTextFormRow(inflater, groupList, config.getQuantityConfig());
        priceForm = new PriceForm(inflater, groupList, config.getPriceFormConfig());

        groupList.addView(serviceNameForm.getView());
        groupList.addView(quantityUnitForm.getView());
        groupList.addView(quantityForm.getView());
        groupList.addView(priceForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, ServiceAutoCompleteFormConfig config) {
        serviceNameForm.setOnValidationStateChanged(this::onValueChange);
        quantityUnitForm.setOnValidationStateChanged(this::onValueChange);
        quantityForm.setOnValidationStateChanged(this::onValueChange);
        priceForm.setOnValidationStateChanged(this::onValueChange);
        serviceNameForm.addOnItemSelected(item -> {
            quantityUnitForm.setValue(item.getQuantityUnit());
            priceForm.setValue(item.getPriceSuggestion());
        });
    }

    @Override
    public InvoiceItemFormModel getValue() {
        String name = serviceNameForm.getValue();
        BigDecimal quantity = quantityForm.getValue();
        String unit = quantityUnitForm.getValue();
        Price price = priceForm.getValue();
        if (name == null && quantity == null && unit == null && price == null) {
            return null;
        }
        InvoiceItemFormModel invoiceItem = new InvoiceItemFormModel();
        invoiceItem.setName(name);
        invoiceItem.setQuantity(quantity);
        invoiceItem.setQuantityUnit(unit);
        invoiceItem.setPrice(price);
        invoiceItem.setType(ItemType.SERVICE);
        return invoiceItem;
    }

    @Override
    public boolean isValid() {
        return serviceNameForm.isValid() && quantityForm.isValid()
            && quantityUnitForm.isValid() && priceForm.isValid();
    }

}
