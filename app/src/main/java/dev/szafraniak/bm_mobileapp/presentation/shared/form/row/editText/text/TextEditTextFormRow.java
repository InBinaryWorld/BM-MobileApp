package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.text;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.EditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;

public class TextEditTextFormRow extends EditTextFormRow<String, TextFormConfig<String>> {

    public TextEditTextFormRow(LayoutInflater inflater, ViewGroup viewGroup, TextFormConfig<String> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected String parseInput(String inputValue) {
        TextFormConfig<String> config = getConfig();
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
