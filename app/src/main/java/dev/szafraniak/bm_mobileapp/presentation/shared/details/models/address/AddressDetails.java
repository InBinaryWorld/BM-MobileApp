package dev.szafraniak.bm_mobileapp.presentation.shared.details.models.address;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.EditTextViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.text.TextTextViewDetails;

public class AddressDetails extends BaseDetails<Address, BaseViewHolder, AddressDetailsConfig> {

    @LayoutRes
    private final int layoutId = R.layout.form_base_group;

    TextTextViewDetails countryRow;
    TextTextViewDetails cityRow;
    TextTextViewDetails postalCodeRow;
    TextTextViewDetails streetRow;
    TextTextViewDetails houseNumberRow;
    TextTextViewDetails apartmentNumberRow;

    public AddressDetails(LayoutInflater inflater, ViewGroup viewGroup, AddressDetailsConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(Address value) {
        countryRow.setValue(value != null ? value.getCountry() : null);
        cityRow.setValue(value != null ? value.getCity() : null);
        postalCodeRow.setValue(value != null ? value.getPostalCode() : null);
        streetRow.setValue(value != null ? value.getStreet() : null);
        houseNumberRow.setValue(value != null ? value.getHouseNumber() : null);
        apartmentNumberRow.setValue(value != null ? value.getApartmentNumber() : null);
    }

    @Override
    protected EditTextViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, AddressDetailsConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);

        countryRow = new TextTextViewDetails(inflater, groupList, config.getCountryConfig());
        cityRow = new TextTextViewDetails(inflater, groupList, config.getCityConfig());
        postalCodeRow = new TextTextViewDetails(inflater, groupList, config.getPostalCodeConfig());
        streetRow = new TextTextViewDetails(inflater, groupList, config.getStreetConfig());
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

