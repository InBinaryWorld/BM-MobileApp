package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.address;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.BaseDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.text.TextTextViewDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.EditTextViewHolder;

public class AddressDetails extends BaseDetails<Address, BaseViewHolder, AddressDetailsConfig> {

    @LayoutRes
    private final int layoutId = R.layout.form_base_group;

    TextTextViewDetails cityRow;
    TextTextViewDetails countryRow;
    TextTextViewDetails streetRow;
    TextTextViewDetails postalCodeRow;
    TextTextViewDetails houseNumberRow;
    TextTextViewDetails apartmentNumberRow;

    public AddressDetails(LayoutInflater inflater, ViewGroup viewGroup, AddressDetailsConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(Address value) {
        cityRow.setValue(value != null ? value.getCity() : null);
        streetRow.setValue(value != null ? value.getStreet() : null);
        countryRow.setValue(value != null ? value.getCountry() : null);
        postalCodeRow.setValue(value != null ? value.getPostalCode() : null);
        houseNumberRow.setValue(value != null ? value.getHouseNumber() : null);
        apartmentNumberRow.setValue(value != null ? value.getApartmentNumber() : null);
    }

    @Override
    protected EditTextViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, AddressDetailsConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        cityRow = new TextTextViewDetails(inflater, groupList, config.getCityConfig());
        streetRow = new TextTextViewDetails(inflater, groupList, config.getStreetConfig());
        countryRow = new TextTextViewDetails(inflater, groupList, config.getCountryConfig());
        postalCodeRow = new TextTextViewDetails(inflater, groupList, config.getPostalCodeConfig());
        houseNumberRow = new TextTextViewDetails(inflater, groupList, config.getHouseNumberConfig());
        apartmentNumberRow = new TextTextViewDetails(inflater, groupList, config.getApartmentNumberConfig());

        groupList.addView(countryRow.getView());
        groupList.addView(cityRow.getView());
        groupList.addView(postalCodeRow.getView());
        groupList.addView(streetRow.getView());
        groupList.addView(houseNumberRow.getView());
        groupList.addView(apartmentNumberRow.getView());

        EditTextViewHolder holder = new EditTextViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, AddressDetailsConfig config) {
        // Dodatkowa konfiguracja
    }

}

