package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class AddressFormConfig extends BaseFormConfig<Address> {

    protected TextEditTextFormConfig countryConfig;
    protected TextEditTextFormConfig cityConfig;
    protected TextEditTextFormConfig streetConfig;
    protected TextEditTextFormConfig postalConfig;
    protected TextEditTextFormConfig houseConfig;
    protected TextEditTextFormConfig apartmentConfig;

}
