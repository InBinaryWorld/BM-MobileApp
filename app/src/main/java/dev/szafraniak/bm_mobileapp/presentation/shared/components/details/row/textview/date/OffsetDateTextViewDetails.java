package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.date;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.time.OffsetDateTime;

import dev.szafraniak.bm_mobileapp.business.utils.Formatter;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.TextViewDetails;

public class OffsetDateTextViewDetails extends TextViewDetails<OffsetDateTime, SimpleDetailsConfig<OffsetDateTime>> {

    public OffsetDateTextViewDetails(LayoutInflater inflater, ViewGroup viewGroup, SimpleDetailsConfig<OffsetDateTime> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected String parseToDisplay(OffsetDateTime value) {
        return Formatter.safeFormatDateTime(value);
    }
}
