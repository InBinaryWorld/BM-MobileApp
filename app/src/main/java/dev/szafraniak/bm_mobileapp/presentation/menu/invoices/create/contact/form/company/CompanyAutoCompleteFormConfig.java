package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact.form.company;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompanyAutoCompleteFormConfig extends BaseFormConfig<CompanyContact> {

    private AutoCompleteTextFormConfig<String, CompanyContact> companyNameConfig;
    private TextEditTextFormConfig taxIdConfig;
    public AddressFormConfig addressConfig;

}
