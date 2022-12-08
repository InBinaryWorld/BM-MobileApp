package dev.szafraniak.bm_mobileapp.presentation.menu.company.modify;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.UpdateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address.AddressForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;

public class ModifyCompanyForm extends BaseForm<UpdateCompanyRequest, BaseViewHolder, ModifyCompanyFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group_with_padding;

    AddressForm addressForm;
    TextEditTextFormRow nameFormRow;
    TextEditTextFormRow taxIdentityFormRow;
    TextEditTextFormRow invoicePrefixFormRow;
    TextEditTextFormRow invoiceLogoFormRow;

    public ModifyCompanyForm(LayoutInflater inflater, ViewGroup viewGroup, ModifyCompanyFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(UpdateCompanyRequest value) {
        if (value == null) {
            addressForm.setValue(null);
            nameFormRow.setValue(null);
            taxIdentityFormRow.setValue(null);
            invoicePrefixFormRow.setValue(null);
            invoiceLogoFormRow.setValue(null);
            return;
        }
        addressForm.setValue(value.getHeadquarter());
        nameFormRow.setValue(value.getName());
        taxIdentityFormRow.setValue(value.getTaxIdentityNumber());
        invoicePrefixFormRow.setValue(value.getInvoicePrefix());
        invoiceLogoFormRow.setValue(value.getInvoiceLogo());
    }

    @Override
    public UpdateCompanyRequest getValue() {
        String name = nameFormRow.getValue();
        Address address = addressForm.getValue();
        String taxIdentity = taxIdentityFormRow.getValue();
        String invoicePrefix = invoicePrefixFormRow.getValue();
        String invoiceLogo = invoiceLogoFormRow.getValue();
        if (name == null && taxIdentity == null && invoicePrefix == null && invoiceLogo == null && address == null) {
            return null;
        }
        UpdateCompanyRequest model = new UpdateCompanyRequest();
        model.setName(name);
        model.setHeadquarter(address);
        model.setInvoicePrefix(invoicePrefix);
        model.setInvoiceLogo(invoiceLogo);
        model.setTaxIdentityNumber(taxIdentity);
        return model;
    }


    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, ModifyCompanyFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        nameFormRow = new TextEditTextFormRow(inflater, groupList, config.getNameConfig());
        addressForm = new AddressForm(inflater, groupList, config.getAddressConfig());
        taxIdentityFormRow = new TextEditTextFormRow(inflater, groupList, config.getTaxIdentityConfig());
        invoicePrefixFormRow = new TextEditTextFormRow(inflater, groupList, config.getInvoicePrefixConfig());
        invoiceLogoFormRow = new TextEditTextFormRow(inflater, groupList, config.getInvoiceLogoConfig());

        groupList.addView(nameFormRow.getView());
        groupList.addView(invoicePrefixFormRow.getView());
        groupList.addView(invoiceLogoFormRow.getView());
        groupList.addView(taxIdentityFormRow.getView());
        groupList.addView(addressForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, ModifyCompanyFormConfig config) {
        nameFormRow.setOnValidationStateChanged(this::onValueChange);
        addressForm.setOnValidationStateChanged(this::onValueChange);
        taxIdentityFormRow.setOnValidationStateChanged(this::onValueChange);
        invoicePrefixFormRow.setOnValidationStateChanged(this::onValueChange);
        invoiceLogoFormRow.setOnValidationStateChanged(this::onValueChange);
    }

    @Override
    public boolean isValid() {
        return nameFormRow.isValid() && taxIdentityFormRow.isValid()
                && invoicePrefixFormRow.isValid() && addressForm.isValid()
                && invoiceLogoFormRow.isValid();
    }
}


