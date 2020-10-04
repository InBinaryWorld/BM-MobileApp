package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class CompanyContactCreateFormConfig extends BaseFormConfig<CreateCompanyContactRequest> {

    public TextFormConfig<String> nameConfig;
    public TextFormConfig<String> taxIdConfig;
    public TextFormConfig<String> phoneConfig;
    public AddressFormConfig addressConfig;

}

