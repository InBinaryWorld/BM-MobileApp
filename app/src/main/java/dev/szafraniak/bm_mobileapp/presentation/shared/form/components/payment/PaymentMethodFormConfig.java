package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment;

import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.transfer.PaymentTransferFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.type.PaymentMethodTypeFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentMethodFormConfig extends BaseFormConfig<PaymentMethod> {

    protected PaymentMethodTypeFormConfig paymentTypeFormConfig;
    protected PaymentTransferFormConfig paymentTransferFormConfig;

}
