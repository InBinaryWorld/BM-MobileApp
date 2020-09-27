package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create;

import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.models.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompanyContactCreateFormConfig extends BaseFormConfig<CreateCompanyContactRequest> {

    public TextEditTextFormRowConfig nameConfig;
    public TextEditTextFormRowConfig taxIdConfig;
    public TextEditTextFormRowConfig phoneConfig;
    public AddressFormConfig addressConfig;

}

