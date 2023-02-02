package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.form.payment.transfer;

import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentTransfer;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentTransferFormConfig extends BaseFormConfig<PaymentTransfer> {

    private AutoCompleteTextFormConfig<String, BankAccount> nameConfig;
    private TextEditTextFormConfig numberConfig;

}
