package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.type;

import java.util.HashMap;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.SpinnerFormRowConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentMethodTypeFormConfig extends SpinnerFormRowConfig<PaymentMethodType, PaymentMethodType> {

    private HashMap<PaymentMethodType, String> displayValues;

}
