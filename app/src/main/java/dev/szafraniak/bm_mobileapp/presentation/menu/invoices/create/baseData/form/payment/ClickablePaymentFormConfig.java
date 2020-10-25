package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.baseData.form.payment;

import java.util.Map;

import dev.szafraniak.bm_mobileapp.business.models.entity.payment.PaymentMethod;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.PaymentFormModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.labeled.LabelFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClickablePaymentFormConfig extends LabelFormRowConfig<PaymentFormModel> {

    private String dueDateLabel;
    private String paymentTypeLabel;
    private String emptyText;
    private Map<Class<? extends PaymentMethod>, String> paymentMethodDisplayNames;
}
