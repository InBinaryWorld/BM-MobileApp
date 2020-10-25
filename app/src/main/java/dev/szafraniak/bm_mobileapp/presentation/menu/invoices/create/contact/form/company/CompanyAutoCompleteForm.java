package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact.form.company;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address.AddressForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.company.CompanyNameAutoCompleteForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;

public class CompanyAutoCompleteForm extends BaseForm<CompanyContact, BaseViewHolder, CompanyAutoCompleteFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    CompanyNameAutoCompleteForm nameForm;
    TextEditTextFormRow taxIdForm;
    AddressForm addressForm;

    public CompanyAutoCompleteForm(LayoutInflater inflater, ViewGroup viewGroup, CompanyAutoCompleteFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(CompanyContact value) {
        if (value == null) {
            nameForm.setValue(null);
            taxIdForm.setValue(null);
            addressForm.setValue(null);
            return;
        }
        nameForm.setValue(value.getName());
        taxIdForm.setValue(value.getTaxIdentityNumber());
        addressForm.setValue(value.getAddress());
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, CompanyAutoCompleteFormConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        nameForm = new CompanyNameAutoCompleteForm(inflater, groupList, config.getCompanyNameConfig());
        taxIdForm = new TextEditTextFormRow(inflater, groupList, config.getTaxIdConfig());
        addressForm = new AddressForm(inflater, groupList, config.getAddressConfig());

        groupList.addView(nameForm.getView());
        groupList.addView(taxIdForm.getView());
        groupList.addView(addressForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, CompanyAutoCompleteFormConfig config) {
        nameForm.setOnValidationStateChanged(this::onValueChange);
        taxIdForm.setOnValidationStateChanged(this::onValueChange);
        addressForm.setOnValidationStateChanged(this::onValueChange);
        nameForm.addOnItemSelected(item -> {
            taxIdForm.setValue(item.getTaxIdentityNumber());
            addressForm.setValue(item.getAddress());
        });
    }

    @Override
    public CompanyContact getValue() {
        String name = nameForm.getValue();
        String taxId = taxIdForm.getValue();
        Address address = addressForm.getValue();
        if (name == null && taxId == null && address == null) {
            return null;
        }
        CompanyContact companyContact = new CompanyContact();
        companyContact.setName(name);
        companyContact.setTaxIdentityNumber(taxId);
        companyContact.setAddress(address);
        return companyContact;
    }

    @Override
    public boolean isValid() {
        return nameForm.isValid() && taxIdForm.isValid() && addressForm.isValid();
    }

}
