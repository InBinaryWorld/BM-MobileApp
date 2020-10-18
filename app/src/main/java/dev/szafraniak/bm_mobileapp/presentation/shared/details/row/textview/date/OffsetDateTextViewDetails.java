package dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.date;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.time.OffsetDateTime;

import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.TextViewDetails;

public class OffsetDateTextViewDetails extends TextViewDetails<OffsetDateTime, SimpleDetailsConfig<OffsetDateTime>> {

    public OffsetDateTextViewDetails(LayoutInflater inflater, ViewGroup viewGroup, SimpleDetailsConfig<OffsetDateTime> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected String parseToDisplay(OffsetDateTime value) {
        return Parsers.safeFormat(value);
    }
}
