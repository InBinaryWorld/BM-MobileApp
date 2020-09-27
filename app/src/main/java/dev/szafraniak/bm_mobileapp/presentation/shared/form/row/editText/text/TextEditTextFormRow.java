package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.EditTextFormRow;

public class TextEditTextFormRow extends EditTextFormRow<String, TextEditTextFormRowConfig> {

    public TextEditTextFormRow(LayoutInflater inflater, ViewGroup viewGroup, TextEditTextFormRowConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected String parseInput(String inputValue) {
        return inputValue;
    }

    @Override
    protected String parseToDisplay(String value) {
        TextEditTextFormRowConfig config = getConfig();
        if (config.isReadEmptyAsNull() && value.isEmpty()) {
            return null;
        }
        return value;
    }

}
