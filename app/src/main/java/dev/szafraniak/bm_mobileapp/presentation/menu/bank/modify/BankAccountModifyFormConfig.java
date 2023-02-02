package dev.szafraniak.bm_mobileapp.presentation.menu.bank.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.UpdateBankAccountRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class BankAccountModifyFormConfig extends BaseFormConfig<UpdateBankAccountRequest> {

    public TextEditTextFormConfig nameConfig;
    public TextEditTextFormConfig numberConfig;

}

