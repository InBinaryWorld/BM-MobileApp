package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class AddressFormConfig extends BaseFormConfig<Address> {

    protected TextFormConfig<String> countryConfig;
    protected TextFormConfig<String> cityConfig;
    protected TextFormConfig<String> streetConfig;
    protected TextFormConfig<String> postalConfig;
    protected TextFormConfig<String> houseConfig;
    protected TextFormConfig<String> apartmentConfig;

}
