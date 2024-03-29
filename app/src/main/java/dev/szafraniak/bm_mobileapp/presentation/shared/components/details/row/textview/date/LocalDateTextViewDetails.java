package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.date;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.time.LocalDate;

import dev.szafraniak.bm_mobileapp.business.utils.Formatter;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.TextViewDetails;

public class LocalDateTextViewDetails extends TextViewDetails<LocalDate, SimpleDetailsConfig<LocalDate>> {

    public LocalDateTextViewDetails(LayoutInflater inflater, ViewGroup viewGroup, SimpleDetailsConfig<LocalDate> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected String parseToDisplay(LocalDate value) {
        return Formatter.safeFormatDate(value);
    }
}
