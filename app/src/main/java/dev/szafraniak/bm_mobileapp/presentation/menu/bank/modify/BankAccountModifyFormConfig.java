package dev.szafraniak.bm_mobileapp.presentation.menu.bank.modify;

import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.UpdateBankAccountRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class BankAccountModifyFormConfig extends BaseFormConfig<UpdateBankAccountRequest> {

    public TextFormConfig<String> nameConfig;
    public TextFormConfig<String> numberConfig;

}

