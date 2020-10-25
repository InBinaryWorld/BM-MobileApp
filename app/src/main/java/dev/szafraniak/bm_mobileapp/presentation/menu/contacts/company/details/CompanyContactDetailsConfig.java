package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.address.AddressDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.base.BaseDetailsConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompanyContactDetailsConfig extends BaseDetailsConfig<CompanyContact> {

    public SimpleDetailsConfig<String> companyNameConfig;
    public SimpleDetailsConfig<String> taxIdConfig;
    public SimpleDetailsConfig<String> phoneConfig;
    public AddressDetailsConfig addressConfig;

}

