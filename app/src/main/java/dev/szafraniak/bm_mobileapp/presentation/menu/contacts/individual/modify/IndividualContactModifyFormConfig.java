package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.UpdateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.models.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IndividualContactModifyFormConfig extends BaseFormConfig<UpdateIndividualContactRequest> {

    public TextEditTextFormRowConfig firstNameConfig;
    public TextEditTextFormRowConfig lastNameConfig;
    public TextEditTextFormRowConfig phoneConfig;
    public AddressFormConfig addressConfig;

}

