package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details;

import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.models.address.AddressDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetailsConfig;
import lombok.Data;

@Data
public class IndividualContactDetailsConfig extends BaseDetailsConfig<IndividualContact> {

    public SimpleDetailsConfig<String> firstNameConfig;
    public SimpleDetailsConfig<String> lastNameConfig;
    public SimpleDetailsConfig<String> phoneConfig;
    public AddressDetailsConfig addressConfig;

}

