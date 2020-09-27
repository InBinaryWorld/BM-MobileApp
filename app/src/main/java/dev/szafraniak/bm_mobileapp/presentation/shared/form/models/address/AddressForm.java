package dev.szafraniak.bm_mobileapp.presentation.shared.form.models.address;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.editText.text.TextEditTextDetails;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRow;

public class AddressForm extends BaseForm<Address, BaseViewHolder, AddressFormConfig> implements FormInterface<Address> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    TextEditTextDetails countryDetails;
    TextEditTextFormRow cityFormRow;
    TextEditTextFormRow streetFormRow;
    TextEditTextFormRow postalFormRow;
    TextEditTextFormRow houseFormRow;
    TextEditTextFormRow apartmentFormRow;

    public AddressForm(LayoutInflater inflater, ViewGroup viewGroup, AddressFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    public Address getValue() {
        String city = cityFormRow.getValue();
        String street = streetFormRow.getValue();
        String postal = postalFormRow.getValue();
        String house = houseFormRow.getValue();
        String apartment = apartmentFormRow.getValue();
        if (city == null && street == null && postal == null
                && house == null && apartment == null) {
            return null;
        }
        Address address = new Address();
        address.setCountry("Poland");
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
                && houseFormRow.isValid() && apartmentFormRow.isValid();
    }

    @Override
    protected void showValueOnView(Address value) {
        if (value == null) {
            countryDetails.setValue(null);
            cityFormRow.setValue(null);
            streetFormRow.setValue(null);
            postalFormRow.setValue(null);
            houseFormRow.setValue(null);
            apartmentFormRow.setValue(null);
            return;
        }
        countryDetails.setValue(value.getCountry());
        cityFormRow.setValue(value.getCity());
        streetFormRow.setValue(value.getStreet());
        postalFormRow.setValue(value.getPostalCode());
        houseFormRow.setValue(value.getHouseNumber());
        apartmentFormRow.setValue(value.getApartmentNumber());
    }

    @Override
    protected BaseViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, AddressFormConfig config) {
        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        countryDetails = new TextEditTextDetails(inflater, groupList, config.getCountryConfig());
        cityFormRow = new TextEditTextFormRow(inflater, groupList, config.getCityConfig());
        streetFormRow = new TextEditTextFormRow(inflater, groupList, config.getStreetConfig());
        postalFormRow = new TextEditTextFormRow(inflater, groupList, config.getPostalConfig());
        houseFormRow = new TextEditTextFormRow(inflater, groupList, config.getHouseConfig());
        apartmentFormRow = new TextEditTextFormRow(inflater, groupList, config.getApartmentConfig());

        groupList.addView(countryDetails.getView());
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
    protected void setupView(AddressFormConfig config) {
        cityFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        streetFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        postalFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        houseFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
        apartmentFormRow.setOnValidationStateChanged(this::onFieldStateChanged);
    }

    void onFieldStateChanged(boolean isValid) {
        onValueChange();
    }

}
