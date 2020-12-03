package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;

public class AddressForm extends BaseForm<Address, BaseViewHolder, AddressFormConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    TextEditTextFormRow countryFormRow;
    TextEditTextFormRow cityFormRow;
    TextEditTextFormRow streetFormRow;
    TextEditTextFormRow postalFormRow;
    TextEditTextFormRow houseFormRow;
    TextEditTextFormRow apartmentFormRow;

    public AddressForm(LayoutInflater inflater, ViewGroup viewGroup, AddressFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    public Address getValue() {
        String country = countryFormRow.getValue();
        String city = cityFormRow.getValue();
        String street = streetFormRow.getValue();
        String postal = postalFormRow.getValue();
        String house = houseFormRow.getValue();
        String apartment = apartmentFormRow.getValue();
        if (city == null && street == null && postal == null
            && house == null && apartment == null && country == null) {
            return null;
        }
        Address address = new Address();
        address.setCountry(country);
        address.setCity(city);
        address.setStreet(street);
        address.setPostalCode(postal);
        address.setHouseNumber(house);
        address.setApartmentNumber(apartment);
        return address;
    }

    @Override
    public boolean isValid() {
        return cityFormRow.isValid() && streetFormRow.isValid() && postalFormRow.isValid()
            && houseFormRow.isValid() && apartmentFormRow.isValid() && countryFormRow.isValid();
    }

    @Override
    protected void showValueOnView(Address value) {
        if (value == null) {
            countryFormRow.setValue(null);
            cityFormRow.setValue(null);
            streetFormRow.setValue(null);
            postalFormRow.setValue(null);
            houseFormRow.setValue(null);
            apartmentFormRow.setValue(null);
            return;
        }
        countryFormRow.setValue(value.getCountry());
        cityFormRow.setValue(value.getCity());
        streetFormRow.setValue(value.getStreet());
        postalFormRow.setValue(value.getPostalCode());
        houseFormRow.setValue(value.getHouseNumber());
        apartmentFormRow.setValue(value.getApartmentNumber());
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, AddressFormConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        countryFormRow = new TextEditTextFormRow(inflater, groupList, config.getCountryConfig());
        cityFormRow = new TextEditTextFormRow(inflater, groupList, config.getCityConfig());
        streetFormRow = new TextEditTextFormRow(inflater, groupList, config.getStreetConfig());
        postalFormRow = new TextEditTextFormRow(inflater, groupList, config.getPostalConfig());
        houseFormRow = new TextEditTextFormRow(inflater, groupList, config.getHouseConfig());
        apartmentFormRow = new TextEditTextFormRow(inflater, groupList, config.getApartmentConfig());

        groupList.addView(countryFormRow.getView());
        groupList.addView(cityFormRow.getView());
        groupList.addView(streetFormRow.getView());
        groupList.addView(postalFormRow.getView());
        groupList.addView(houseFormRow.getView());
        groupList.addView(apartmentFormRow.getView());

        BaseViewHolder holder = new BaseViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, AddressFormConfig config) {
        cityFormRow.setOnValidationStateChanged(this::onValueChange);
        houseFormRow.setOnValidationStateChanged(this::onValueChange);
        streetFormRow.setOnValidationStateChanged(this::onValueChange);
        postalFormRow.setOnValidationStateChanged(this::onValueChange);
        apartmentFormRow.setOnValidationStateChanged(this::onValueChange);
    }

}