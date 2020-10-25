package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.address.AddressDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.BaseDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.text.TextTextViewDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.EditTextViewHolder;

public class IndividualContactDetails extends BaseDetails<IndividualContact, BaseViewHolder, IndividualContactDetailsConfig> {

    @LayoutRes
    private final int layoutId = R.layout.form_base_group_with_padding;

    TextTextViewDetails firstNameRow;
    TextTextViewDetails lastNameRow;
    TextTextViewDetails phoneRow;
    AddressDetails addressForm;

    public IndividualContactDetails(LayoutInflater inflater, ViewGroup viewGroup, IndividualContactDetailsConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(IndividualContact value) {
        firstNameRow.setValue(value != null ? value.getFirstName() : null);
        lastNameRow.setValue(value != null ? value.getLastName() : null);
        phoneRow.setValue(value != null ? value.getPhone() : null);
        addressForm.setValue(value != null ? value.getAddress() : null);
    }

    @Override
    protected EditTextViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, IndividualContactDetailsConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        firstNameRow = new TextTextViewDetails(inflater, groupList, config.getFirstNameConfig());
        lastNameRow = new TextTextViewDetails(inflater, groupList, config.getLastNameConfig());
        phoneRow = new TextTextViewDetails(inflater, groupList, config.getPhoneConfig());
        addressForm = new AddressDetails(inflater, groupList, config.getAddressConfig());

        groupList.addView(firstNameRow.getView());
        groupList.addView(lastNameRow.getView());
        groupList.addView(phoneRow.getView());
        groupList.addView(addressForm.getView());

        EditTextViewHolder holder = new EditTextViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, IndividualContactDetailsConfig config) {
        // Dodatkowa konfiguracja
    }


}

