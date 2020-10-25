package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text;

import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TextFormViewHolder<T extends EditText> extends BaseViewHolder {
    public TextInputLayout layout;
    public T editText;
}
