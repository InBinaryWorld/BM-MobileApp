package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.barcode;

import android.app.Activity;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BarcodeFormConfig extends TextFormConfig<String> {
    private Activity activity;
}
