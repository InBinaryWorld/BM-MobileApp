package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.address;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.BaseDetailsConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AddressDetailsConfig extends BaseDetailsConfig<Address> {

    private SimpleDetailsConfig<String> cityConfig;
    private SimpleDetailsConfig<String> streetConfig;
    private SimpleDetailsConfig<String> countryConfig;
    private SimpleDetailsConfig<String> postalCodeConfig;
    private SimpleDetailsConfig<String> houseNumberConfig;
    private SimpleDetailsConfig<String> apartmentNumberConfig;

}

