package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import dev.szafraniak.bm_mobileapp.presentation.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TextViewHolder extends BaseViewHolder {
    public TextInputLayout textInputLayout;
    public TextInputEditText textInputEditText;
}