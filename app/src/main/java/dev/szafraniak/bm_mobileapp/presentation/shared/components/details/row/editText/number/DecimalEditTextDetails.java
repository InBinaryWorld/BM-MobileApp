package dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.editText.number;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.utils.Formatter;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.details.row.editText.EditTextDetails;

public class DecimalEditTextDetails extends EditTextDetails<BigDecimal, SimpleDetailsConfig<BigDecimal>> {


    public DecimalEditTextDetails(LayoutInflater inflater, ViewGroup viewGroup, SimpleDetailsConfig<BigDecimal> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected String parseToDisplay(BigDecimal value) {
        return Formatter.safeFormatWithFraction(value);
    }
}
