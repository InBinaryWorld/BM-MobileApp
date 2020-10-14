package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.EditTextViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.models.address.AddressDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.text.TextTextViewDetails;

public class CompanyContactDetails extends BaseDetails<CompanyContact, BaseViewHolder, CompanyContactDetailsConfig> {

    @LayoutRes
    private final int layoutId = R.layout.form_base_group_with_padding;

    TextTextViewDetails nameRow;
    TextTextViewDetails taxIdRow;
    TextTextViewDetails phoneRow;
    AddressDetails addressForm;

    public CompanyContactDetails(LayoutInflater inflater, ViewGroup viewGroup, CompanyContactDetailsConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(CompanyContact value) {
        nameRow.setValue(value != null ? value.getName() : null);
        taxIdRow.setValue(value != null ? value.getTaxIdentityNumber() : null);
        phoneRow.setValue(value != null ? value.getPhone() : null);
        addressForm.setValue(value != null ? value.getAddress() : null);
    }

    @Override
    protected EditTextViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, CompanyContactDetailsConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        nameRow = new TextTextViewDetails(inflater, groupList, config.getCompanyNameConfig());
        taxIdRow = new TextTextViewDetails(inflater, groupList, config.getTaxIdConfig());
        phoneRow = new TextTextViewDetails(inflater, groupList, config.getPhoneConfig());
        addressForm = new AddressDetails(inflater, groupList, config.getAddressConfig());

        groupList.addView(nameRow.getView());
        groupList.addView(taxIdRow.getView());
        groupList.addView(phoneRow.getView());
        groupList.addView(addressForm.getView());

        EditTextViewHolder holder = new EditTextViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, CompanyContactDetailsConfig config) {
        // Dodatkowa konfiguracja
    }


}

