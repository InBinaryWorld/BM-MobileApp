package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.form.payment;

import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.form.payment.transfer.PaymentTransferFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.spinner.type.BaseTypeFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentMethodFormConfig extends BaseFormConfig<PaymentMethod> {

    protected BaseTypeFormConfig<PaymentMethodType> paymentTypeFormConfig;
    protected PaymentTransferFormConfig paymentTransferFormConfig;

}
