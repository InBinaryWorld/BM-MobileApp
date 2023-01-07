package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form;

import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceBaseFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form.contact.ClickableContactFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form.payment.ClickablePaymentFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.datePicker.DatePickerFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateInvoiceBaseDataFormConfig extends BaseFormConfig<CreateInvoiceBaseFormModel> {

    public TextFormConfig<String> invoiceNumberConfig;
    public DatePickerFormConfig issueDateConfig;
    public DatePickerFormConfig sellDateConfig;
    public ClickableContactFormConfig buyerConfig;
    public ClickableContactFormConfig receiverConfig;
    public ClickablePaymentFormConfig paymentConfig;

}

