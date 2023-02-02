package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.UpdateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompanyContactModifyFormConfig extends BaseFormConfig<UpdateCompanyContactRequest> {

    public TextEditTextFormConfig nameConfig;
    public TextEditTextFormConfig taxIdConfig;
    public TextEditTextFormConfig phoneConfig;
    public AddressFormConfig addressConfig;

}

