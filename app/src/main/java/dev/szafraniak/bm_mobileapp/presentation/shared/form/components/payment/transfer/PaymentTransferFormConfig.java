package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.transfer;

import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentTransfer;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentTransferFormConfig extends BaseFormConfig<PaymentTransfer> {

    private AutoCompleteTextFormConfig<String, BankAccount> nameConfig;
    private TextFormConfig<String> numberConfig;

}
