package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.form;

import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceBaseDataModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.contact.ClickableContactFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.base.payment.ClickablePaymentFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateInvoiceBaseDataFormConfig extends BaseFormConfig<CreateInvoiceBaseDataModel> {

    public TextFormConfig<String> invoiceNumberConfig;
    public ClickableContactFormConfig buyerConfig;
    public ClickableContactFormConfig receiverConfig;
    public ClickablePaymentFormConfig paymentConfig;

}

