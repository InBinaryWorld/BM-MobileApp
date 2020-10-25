package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.text;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.AutoCompleteTextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.AutoCompleteTextFormRow;

public abstract class TextAutoCompleteTextForm<P> extends AutoCompleteTextFormRow<String, P, AutoCompleteTextFormConfig<String, P>> {

    public TextAutoCompleteTextForm(LayoutInflater inflater, ViewGroup viewGroup, AutoCompleteTextFormConfig<String, P> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected String parseInput(String inputValue) {
        AutoCompleteTextFormConfig<String, P> config = getConfig();
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
