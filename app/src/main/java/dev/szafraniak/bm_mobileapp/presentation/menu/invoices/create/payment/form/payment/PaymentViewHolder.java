package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.payment.form.payment;


import android.view.View;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentViewHolder extends BaseViewHolder {
    public View transferView;
}