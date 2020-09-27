package dev.szafraniak.bm_mobileapp.presentation.company.create;

import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.models.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateCompanyFormConfig extends BaseFormConfig<CreateCompanyRequest> {

    public TextEditTextFormRowConfig nameConfig;
    public TextEditTextFormRowConfig invoicePrefixConfig;
    public TextEditTextFormRowConfig taxIdentityConfig;
    public AddressFormConfig addressConfig;

}

