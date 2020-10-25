package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.editText.text;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.editText.EditTextDetails;

public class TextEditTextDetails extends EditTextDetails<String, SimpleDetailsConfig<String>> {


    public TextEditTextDetails(LayoutInflater inflater, ViewGroup viewGroup, SimpleDetailsConfig<String> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected String parseToDisplay(String value) {
        return value;
    }

}
