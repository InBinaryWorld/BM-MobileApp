package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment;

import java.util.List;

import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.PaymentModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormView;

public interface InvoicePaymentView extends BaseFormView {

    void setData(PaymentModel model, List<BankAccount> bankAccounts);

}
