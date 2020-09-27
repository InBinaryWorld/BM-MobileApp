package dev.szafraniak.bm_mobileapp.presentation.company.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.models.address.AddressForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;

public class CreateCompanyForm extends BaseForm<CreateCompanyRequest, BaseViewHolder, CreateCompanyFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    TextEditTextFormRow nameFormRow;
    TextEditTextFormRow invoicePrefixFormRow;
    TextEditTextFormRow taxIdentityFormRow;
    AddressForm addressForm;

    public CreateCompanyForm(LayoutInflater inflater, ViewGroup viewGroup, CreateCompanyFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(CreateCompanyRequest value) {
        if (value == null) {
            nameFormRow.setValue(null);
            invoicePrefixFormRow.setValue(null);
            taxIdentityFormRow.setValue(null);
            addressForm.setValue(null);
            return;
        }
        nameFormRow.setValue(value.getName());
        invoicePrefixFormRow.setValue(value.getInvoicePrefix());
        taxIdentityFormRow.setValue(value.getTaxIdentityNumber());
        addressForm.setValue(value.getHeadquarter());
    }

    @Override
    public CreateCompanyRequest getValue() {
        String name = nameFormRow.getValue();
        String invoicePrefix = invoicePrefixFormRow.getValue();
        String taxIdentity = taxIdentityFormRow.getValue();
        Address address = addressForm.getValue();
        if (name == null && taxIdentity == null && invoicePrefix == null && address == null) {
            return null;
        }
        CreateCompanyRequest model = new CreateCompanyRequest();
        model.setName(name);
        model.setInvoicePrefix(invoicePrefix);
        model.setTaxIdentityNumber(taxIdentity);
        model.setHeadquarter(address);
        return model;
    }


    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, CreateCompanyFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        nameFormRow = new TextEditTextFormRow(inflater, groupList, config.getNameConfig());
        invoicePrefixFormRow = new TextEditTextFormRow(inflater, groupList, config.getInvoicePrefixConfig());
        taxIdentityFormRow = new TextEditTextFormRow(inflater, groupList, config.getTaxIdentityConfig());
        addressForm = new AddressForm(inflater, groupList, config.getAddressConfig());

        groupList.addView(nameFormRow.getView());
        groupList.addView(invoicePrefixFormRow.getView());
        groupList.addView(taxIdentityFormRow.getView());
        groupList.addView(addressForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(CreateCompanyFormConfig config) {
        nameFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        invoicePrefixFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        taxIdentityFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        addressForm.setOnValidationStateChanged(this::onFieldStateChanged);
    }

    private void onFieldStateChanged(boolean b) {
        onValueChange();
    }

    @Override
    public boolean isValid() {
        return nameFormRow.isValid() && taxIdentityFormRow.isValid() && invoicePrefixFormRow.isValid() && addressForm.isValid();
    }
}


