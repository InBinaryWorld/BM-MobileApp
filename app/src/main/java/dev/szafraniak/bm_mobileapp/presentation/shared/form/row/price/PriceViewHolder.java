package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PriceViewHolder extends BaseViewHolder {
    private TextInputLayout netPriceLayout;
    private TextInputEditText netPriceEditText;
    private TextInputLayout taxRateLayout;
    private TextInputEditText taxRateEditText;
    private TextInputLayout grossPriceLayout;
    private TextInputEditText grossPriceEditText;
}