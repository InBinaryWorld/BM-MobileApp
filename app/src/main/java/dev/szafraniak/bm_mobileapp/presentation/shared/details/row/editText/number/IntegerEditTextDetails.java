package dev.szafraniak.bm_mobileapp.presentation.shared.details.row.editText.number;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.editText.EditTextDetails;

public class IntegerEditTextDetails extends EditTextDetails<BigDecimal, SimpleDetailsConfig<BigDecimal>> {


    public IntegerEditTextDetails(LayoutInflater inflater, ViewGroup viewGroup, SimpleDetailsConfig<BigDecimal> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected String parseToDisplay(BigDecimal value) {
        return Parsers.safeFormatNoFraction(value);
    }
}
