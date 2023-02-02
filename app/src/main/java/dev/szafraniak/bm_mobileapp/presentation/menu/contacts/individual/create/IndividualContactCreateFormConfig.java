package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class IndividualContactCreateFormConfig extends BaseFormConfig<CreateIndividualContactRequest> {

    public TextEditTextFormConfig firstNameConfig;
    public TextEditTextFormConfig lastNameConfig;
    public TextEditTextFormConfig phoneConfig;
    public AddressFormConfig addressConfig;

}

