package dev.szafraniak.bm_mobileapp.presentation.shared.details.models.address;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetailsConfig;
import lombok.Data;

@Data
public class AddressDetailsConfig extends BaseDetailsConfig<Address> {

    private SimpleDetailsConfig<String> countryConfig;
    private SimpleDetailsConfig<String> cityConfig;
    private SimpleDetailsConfig<String> postalCodeConfig;
    private SimpleDetailsConfig<String> streetConfig;
    private SimpleDetailsConfig<String> houseNumberConfig;
    private SimpleDetailsConfig<String> apartmentNumberConfig;

}

