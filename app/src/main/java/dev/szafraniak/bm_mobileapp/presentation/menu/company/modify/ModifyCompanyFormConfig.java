package dev.szafraniak.bm_mobileapp.presentation.menu.company.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.company.UpdateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.models.address.AddressFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ModifyCompanyFormConfig extends BaseFormConfig<UpdateCompanyRequest> {

    public TextEditTextFormRowConfig nameConfig;
    public TextEditTextFormRowConfig invoicePrefixConfig;
    public TextEditTextFormRowConfig taxIdentityConfig;
    public AddressFormConfig addressConfig;

}

