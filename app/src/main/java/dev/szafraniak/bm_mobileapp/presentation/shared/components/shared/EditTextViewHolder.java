package dev.szafraniak.bm_mobileapp.presentation.shared.components.shared;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EditTextViewHolder extends BaseViewHolder {
    public TextInputLayout layout;
    public TextInputEditText editText;
}