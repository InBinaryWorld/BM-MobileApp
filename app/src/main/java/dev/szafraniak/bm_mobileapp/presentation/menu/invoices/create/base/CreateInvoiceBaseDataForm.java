package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;

public class CreateInvoiceBaseDataForm extends BaseForm<CreateInvoiceBaseDataModel, BaseViewHolder, CreateInvoiceBaseDataFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    TextEditTextFormRow invoiceNumberFormRow;

    public CreateInvoiceBaseDataForm(LayoutInflater inflater, ViewGroup viewGroup, CreateInvoiceBaseDataFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(CreateInvoiceBaseDataModel value) {
        if (value == null) {
            invoiceNumberFormRow.setValue(null);
            return;
        }
        invoiceNumberFormRow.setValue(value.getInvoiceNumber());
    }

    @Override
    public CreateInvoiceBaseDataModel getValue() {
        String invoiceNumber = invoiceNumberFormRow.getValue();
        // If whole form is not required that allow to return null value if all of child fields have null values
        if (invoiceNumber == null) {
            return null;
        }
        CreateInvoiceBaseDataModel model = new CreateInvoiceBaseDataModel();
        model.setInvoiceNumber(invoiceNumber);
        return model;
    }


    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, CreateInvoiceBaseDataFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        invoiceNumberFormRow = new TextEditTextFormRow(inflater, groupList, config.getInvoiceNumberConfig());

        groupList.addView(invoiceNumberFormRow.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(CreateInvoiceBaseDataFormConfig config) {
        invoiceNumberFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
    }

    private void onFieldStateChanged(boolean b) {
        onValueChange();
    }

    @Override
    public boolean isValid() {
        return invoiceNumberFormRow.isValid();
    }
}


