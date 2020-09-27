package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.models.address.AddressDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetailsConfig;
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

