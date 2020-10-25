package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.UpdateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompanyContactModifyFormConfig extends BaseFormConfig<UpdateCompanyContactRequest> {

    public TextFormConfig<String> nameConfig;
    public TextFormConfig<String> taxIdConfig;
    public TextFormConfig<String> phoneConfig;
    public AddressFormConfig addressConfig;

}

