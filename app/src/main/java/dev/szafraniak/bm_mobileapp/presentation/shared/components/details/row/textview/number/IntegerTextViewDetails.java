package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.number;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.utils.Formatter;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.textview.TextViewDetails;

public class IntegerTextViewDetails extends TextViewDetails<BigDecimal, SimpleDetailsConfig<BigDecimal>> {

    public IntegerTextViewDetails(LayoutInflater inflater, ViewGroup viewGroup, SimpleDetailsConfig<BigDecimal> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected String parseToDisplay(BigDecimal value) {
        return Formatter.safeFormatNoFraction(value);
    }

}

