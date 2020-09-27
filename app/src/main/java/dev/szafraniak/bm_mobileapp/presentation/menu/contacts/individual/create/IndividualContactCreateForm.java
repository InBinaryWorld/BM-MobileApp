package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.models.address.AddressForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;

public class IndividualContactCreateForm extends BaseForm<CreateIndividualContactRequest, BaseViewHolder, IndividualContactCreateFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    TextEditTextFormRow firstNameFormRow;
    TextEditTextFormRow lastNameFormRow;
    TextEditTextFormRow phoneFormRow;
    AddressForm addressForm;

    public IndividualContactCreateForm(LayoutInflater inflater, ViewGroup viewGroup, IndividualContactCreateFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(CreateIndividualContactRequest value) {
        if (value == null) {
            firstNameFormRow.setValue(null);
            lastNameFormRow.setValue(null);
            phoneFormRow.setValue(null);
            addressForm.setValue(null);
            return;
        }
        firstNameFormRow.setValue(value.getFirstName());
        lastNameFormRow.setValue(value.getLastName());
        phoneFormRow.setValue(value.getPhone());
        addressForm.setValue(value.getAddress());
    }

    @Override
    public CreateIndividualContactRequest getValue() {
        String firstName = firstNameFormRow.getValue();
        String lastName = lastNameFormRow.getValue();
        String phone = phoneFormRow.getValue();
        Address address = addressForm.getValue();
        if (firstName == null && phone == null && lastName == null && address == null) {
            return null;
        }
        CreateIndividualContactRequest model = new CreateIndividualContactRequest();
        model.setFirstName(firstName);
        model.setLastName(lastName);
        model.setPhone(phone);
        model.setAddress(address);
        return model;
    }


    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, IndividualContactCreateFormConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        firstNameFormRow = new TextEditTextFormRow(inflater, groupList, config.getFirstNameConfig());
        lastNameFormRow = new TextEditTextFormRow(inflater, groupList, config.getLastNameConfig());
        phoneFormRow = new TextEditTextFormRow(inflater, groupList, config.getPhoneConfig());
        addressForm = new AddressForm(inflater, groupList, config.getAddressConfig());

        groupList.addView(firstNameFormRow.getView());
        groupList.addView(lastNameFormRow.getView());
        groupList.addView(phoneFormRow.getView());
        groupList.addView(addressForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(IndividualContactCreateFormConfig config) {
        firstNameFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        lastNameFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        phoneFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        addressForm.setOnValidationStateChanged(this::onFieldStateChanged);
    }

    private void onFieldStateChanged(boolean b) {
        onValueChange();
    }

    @Override
    public boolean isValid() {
        return firstNameFormRow.isValid() && phoneFormRow.isValid() && lastNameFormRow.isValid() && addressForm.isValid();
    }
}


