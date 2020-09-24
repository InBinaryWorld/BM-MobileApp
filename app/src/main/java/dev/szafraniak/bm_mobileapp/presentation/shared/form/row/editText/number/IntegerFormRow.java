package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.number;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.utils.Formatters;
import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.presentation.shared.EditTextViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.EditTextFormRow;

public class IntegerFormRow extends EditTextFormRow<BigDecimal, NumberConfig> {

    public IntegerFormRow(LayoutInflater inflater, ViewGroup viewGroup, NumberConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected BigDecimal parseInput(String inputValue) {
        NumberConfig config = getConfig();
        return Parsers.safeToBigDecimal(inputValue, config.isZeroOnEmpty());
    }

    @Override
    protected String parseToDisplay(BigDecimal value) {
        return Formatters.formatNoFraction(value);
    }

    @Override
    protected void setupView(NumberConfig config) {
        EditTextViewHolder holder = getViewHolder();
        holder.editText.setInputType(InputType.TYPE_NUMBER_VARIATION_NORMAL);
        super.setupView(config);
    }
}