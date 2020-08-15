package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EditTextViewHolder extends BaseViewHolder {
    private TextInputLayout textInputLayout;
    private TextInputEditText textInputEditText;
}