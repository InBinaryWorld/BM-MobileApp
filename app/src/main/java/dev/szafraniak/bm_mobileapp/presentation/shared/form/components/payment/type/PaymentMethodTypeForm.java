package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment.type;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.BaseSpinnerFormRow;

public class PaymentMethodTypeForm extends BaseSpinnerFormRow<PaymentMethodType, PaymentMethodTypeFormConfig> {
    public PaymentMethodTypeForm(LayoutInflater inflater, ViewGroup viewGroup, PaymentMethodTypeFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected PaymentMethodTypeAdapter createAdapter(LayoutInflater inflater, PaymentMethodTypeFormConfig config) {
        return new PaymentMethodTypeAdapter(inflater, config);
    }

}
