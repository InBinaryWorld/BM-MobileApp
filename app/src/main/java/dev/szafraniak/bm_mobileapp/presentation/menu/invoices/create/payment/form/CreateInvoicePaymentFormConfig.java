package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.form;

import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.PaymentFormModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.PaymentMethodFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateInvoicePaymentFormConfig extends BaseFormConfig<PaymentFormModel> {

    public PaymentMethodFormConfig paymentConfig;

}

