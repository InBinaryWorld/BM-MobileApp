package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.text;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.TextViewDetails;

public class TextTextViewDetails extends TextViewDetails<String, SimpleDetailsConfig<String>> {

    public TextTextViewDetails(LayoutInflater inflater, ViewGroup viewGroup, SimpleDetailsConfig<String> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected String parseToDisplay(String value) {
        return value;
    }
}
