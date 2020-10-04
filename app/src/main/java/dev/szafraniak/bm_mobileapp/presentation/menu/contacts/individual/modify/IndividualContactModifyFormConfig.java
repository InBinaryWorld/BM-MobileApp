package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.UpdateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class IndividualContactModifyFormConfig extends BaseFormConfig<UpdateIndividualContactRequest> {

    public TextFormConfig<String> firstNameConfig;
    public TextFormConfig<String> lastNameConfig;
    public TextFormConfig<String> phoneConfig;
    public AddressFormConfig addressConfig;

}

