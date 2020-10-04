package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.address;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class AddressFormConfig extends BaseFormConfig<Address> {

    protected SimpleDetailsConfig<String> countryConfig;
    protected TextFormConfig<String> cityConfig;
    protected TextFormConfig<String> streetConfig;
    protected TextFormConfig<String> postalConfig;
    protected TextFormConfig<String> houseConfig;
    protected TextFormConfig<String> apartmentConfig;

}
