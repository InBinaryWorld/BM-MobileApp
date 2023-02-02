package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact.form.individual;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IndividualAutoCompleteFormConfig extends BaseFormConfig<IndividualContact> {

    private AutoCompleteTextFormConfig<String, IndividualContact> firstNameConfig;
    private TextEditTextFormConfig lastNameConfig;
    public AddressFormConfig addressConfig;

}
