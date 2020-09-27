package dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.number;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview.TextViewDetails;

public class DecimalTextViewDetails extends TextViewDetails<BigDecimal, SimpleDetailsConfig<BigDecimal>> {

    public DecimalTextViewDetails(LayoutInflater inflater, ViewGroup viewGroup, SimpleDetailsConfig<BigDecimal> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected String parseToDisplay(BigDecimal value) {
        return Parsers.safeFormatWithFraction(value);
    }

}

