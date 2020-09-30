package dev.szafraniak.bm_mobileapp.presentation.shared.form.special.payment;

import java.util.Map;

import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClickablePaymentFormConfig extends BaseFormConfig<PaymentModel> {

    private String label;
    private String dueDateLabel;
    private String paymentTypeLabel;
    private String emptyText;
    private boolean required;
    private Map<Class<? extends PaymentMethod>, String> paymentMethodDisplayNames;
}
