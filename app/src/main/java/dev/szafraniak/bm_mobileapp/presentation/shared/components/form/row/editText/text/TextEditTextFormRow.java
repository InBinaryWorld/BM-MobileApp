package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.text;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.EditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormViewHolder;

public class TextEditTextFormRow extends EditTextFormRow<String, TextEditTextFormConfig> {

    public TextEditTextFormRow(LayoutInflater inflater, ViewGroup viewGroup, TextEditTextFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void setupView(LayoutInflater inflater, TextEditTextFormConfig config) {
        super.setupView(inflater, config);
        TextFormViewHolder<TextInputEditText> holder = getViewHolder();
        holder.editText.setInputType(config.getInputType());
    }

    @Override
    protected String parseInput(String inputValue) {
        TextEditTextFormConfig config = getConfig();
        if (config.isReadEmptyAsNull() && inputValue.isEmpty()) {
            return null;
        }
        return inputValue;
    }

    @Override
    protected String parseToDisplay(String value) {
        return value;
    }

}
