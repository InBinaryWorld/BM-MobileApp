package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.address;

import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AddressFormConfig extends BaseFormConfig<Address> {

    protected SimpleDetailsConfig<String> countryConfig;
    protected TextEditTextFormRowConfig cityConfig;
    protected TextEditTextFormRowConfig streetConfig;
    protected TextEditTextFormRowConfig postalConfig;
    protected TextEditTextFormRowConfig houseConfig;
    protected TextEditTextFormRowConfig apartmentConfig;

}
