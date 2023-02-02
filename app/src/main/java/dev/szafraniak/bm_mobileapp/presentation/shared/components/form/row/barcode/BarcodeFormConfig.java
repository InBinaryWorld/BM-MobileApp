package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.barcode;

import android.app.Activity;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text.TextEditTextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BarcodeFormConfig extends TextEditTextFormConfig {
    private int inputType;
    private Activity activity;
}
