package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.company;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompanyAutoCompleteFormConfig extends BaseFormConfig<CompanyContact> {

    private AutoCompleteTextFormConfig<String, CompanyContact> companyNameConfig;
    private TextFormConfig<String> taxIdConfig;
    public AddressFormConfig addressConfig;

}
