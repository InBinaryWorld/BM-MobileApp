package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.models.address.AddressForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;

public class CompanyContactCreateForm extends BaseForm<CreateCompanyContactRequest, BaseViewHolder, CompanyContactCreateFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    TextEditTextFormRow nameFormRow;
    TextEditTextFormRow taxIdFormRow;
    TextEditTextFormRow phoneFormRow;
    AddressForm addressForm;


    public CompanyContactCreateForm(LayoutInflater inflater, ViewGroup viewGroup, CompanyContactCreateFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(CreateCompanyContactRequest value) {
        if (value == null) {
            nameFormRow.setValue(null);
            taxIdFormRow.setValue(null);
            phoneFormRow.setValue(null);
            addressForm.setValue(null);
            return;
        }
        nameFormRow.setValue(value.getName());
        taxIdFormRow.setValue(value.getTaxIdentityNumber());
        phoneFormRow.setValue(value.getPhone());
        addressForm.setValue(value.getAddress());
    }

    @Override
    public CreateCompanyContactRequest getValue() {
        String name = nameFormRow.getValue();
        String phone = phoneFormRow.getValue();
        String taxId = taxIdFormRow.getValue();
        Address address = addressForm.getValue();
        if (name == null && phone == null && taxId == null && address == null) {
            return null;
        }
        CreateCompanyContactRequest model = new CreateCompanyContactRequest();
        model.setName(name);
        model.setPhone(phone);
        model.setTaxIdentityNumber(taxId);
        model.setAddress(address);
        return model;
    }


    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, CompanyContactCreateFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        nameFormRow = new TextEditTextFormRow(inflater, groupList, config.getNameConfig());
        taxIdFormRow = new TextEditTextFormRow(inflater, groupList, config.getTaxIdConfig());
        phoneFormRow = new TextEditTextFormRow(inflater, groupList, config.getPhoneConfig());
        addressForm = new AddressForm(inflater, groupList, config.getAddressConfig());

        groupList.addView(nameFormRow.getView());
        groupList.addView(taxIdFormRow.getView());
        groupList.addView(phoneFormRow.getView());
        groupList.addView(addressForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(CompanyContactCreateFormConfig config) {
        nameFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        taxIdFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        phoneFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        addressForm.setOnValidationStateChanged(this::onFieldStateChanged);
    }

    private void onFieldStateChanged(boolean b) {
        onValueChange();
    }

    @Override
    public boolean isValid() {
        return nameFormRow.isValid() && phoneFormRow.isValid() && taxIdFormRow.isValid() && addressForm.isValid();
    }
}


