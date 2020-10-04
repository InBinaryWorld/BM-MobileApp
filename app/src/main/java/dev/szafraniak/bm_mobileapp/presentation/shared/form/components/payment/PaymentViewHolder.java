package dev.szafraniak.bm_mobileapp.presentation.shared.form.components.payment;


import android.view.View;

import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PaymentViewHolder extends BaseViewHolder {
    public View transferView;
}