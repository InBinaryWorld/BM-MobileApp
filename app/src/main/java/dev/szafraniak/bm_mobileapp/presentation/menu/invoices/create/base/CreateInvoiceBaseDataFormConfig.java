package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text.TextEditTextFormRowConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.special.contact.ClickableContactFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.special.payment.ClickablePaymentFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateInvoiceBaseDataFormConfig extends BaseFormConfig<CreateInvoiceBaseDataModel> {

    public TextEditTextFormRowConfig invoiceNumberConfig;
    public ClickableContactFormConfig buyerConfig;
    public ClickableContactFormConfig receiverConfig;
    public ClickablePaymentFormConfig paymentConfig;

}

