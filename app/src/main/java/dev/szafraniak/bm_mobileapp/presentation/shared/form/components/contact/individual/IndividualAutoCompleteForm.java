package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.individual;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.address.AddressForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.individual.IndividualNameAutoCompleteForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;

public class IndividualAutoCompleteForm extends BaseForm<IndividualContact, BaseViewHolder, IndividualAutoCompleteFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    IndividualNameAutoCompleteForm firstNameForm;
    TextEditTextFormRow lastNameForm;
    AddressForm addressForm;

    public IndividualAutoCompleteForm(LayoutInflater inflater, ViewGroup viewGroup, IndividualAutoCompleteFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected void showValueOnView(IndividualContact value) {
        if (value == null) {
            firstNameForm.setValue(null);
            lastNameForm.setValue(null);
            addressForm.setValue(null);
            return;
        }
        firstNameForm.setValue(value.getFirstName());
        lastNameForm.setValue(value.getLastName());
        addressForm.setValue(value.getAddress());
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, IndividualAutoCompleteFormConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        firstNameForm = new IndividualNameAutoCompleteForm(inflater, groupList, config.getFirstNameConfig());
        lastNameForm = new TextEditTextFormRow(inflater, groupList, config.getLastNameConfig());
        addressForm = new AddressForm(inflater, groupList, config.getAddressConfig());

        groupList.addView(firstNameForm.getView());
        groupList.addView(lastNameForm.getView());
        groupList.addView(addressForm.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, IndividualAutoCompleteFormConfig config) {
        firstNameForm.setOnValidationStateChanged(this::onValueChange);
        lastNameForm.setOnValidationStateChanged(this::onValueChange);
        addressForm.setOnValidationStateChanged(this::onValueChange);
        firstNameForm.addOnItemSelected(item -> {
            lastNameForm.setValue(item.getLastName());
            addressForm.setValue(item.getAddress());
        });
    }

    @Override
    public IndividualContact getValue() {
        String firstName = firstNameForm.getValue();
        String lastName = lastNameForm.getValue();
        Address address = addressForm.getValue();
        if (firstName == null && lastName == null && address == null) {
            return null;
        }
        IndividualContact individualContact = new IndividualContact();
        individualContact.setFirstName(firstName);
        individualContact.setLastName(lastName);
        individualContact.setAddress(address);
        return individualContact;
    }

    @Override
    public boolean isValid() {
        return firstNameForm.isValid() && lastNameForm.isValid() && addressForm.isValid();
    }

}
