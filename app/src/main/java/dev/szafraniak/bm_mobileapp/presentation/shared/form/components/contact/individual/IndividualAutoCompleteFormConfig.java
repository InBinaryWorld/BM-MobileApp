package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.individual;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IndividualAutoCompleteFormConfig extends BaseFormConfig<IndividualContact> {

    private AutoCompleteTextFormConfig<String, IndividualContact> firstNameConfig;
    private TextFormConfig<String> lastNameConfig;
    public AddressFormConfig addressConfig;

}
