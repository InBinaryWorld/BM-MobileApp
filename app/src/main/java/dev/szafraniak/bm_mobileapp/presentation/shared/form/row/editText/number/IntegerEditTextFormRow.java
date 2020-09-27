package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.number;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.presentation.shared.EditTextViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.EditTextFormRow;

public class IntegerEditTextFormRow extends EditTextFormRow<BigDecimal, NumberEditTextFormRowConfig> {

    public IntegerEditTextFormRow(LayoutInflater inflater, ViewGroup viewGroup, NumberEditTextFormRowConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected BigDecimal parseInput(String inputValue) {
        NumberEditTextFormRowConfig config = getConfig();
        return Parsers.safeToBigDecimal(inputValue, config.isZeroOnEmpty());
    }

    @Override
    protected String parseToDisplay(BigDecimal value) {
        return Parsers.safeFormatNoFraction(value);
    }

    @Override
    protected void setupView(NumberEditTextFormRowConfig config) {
        EditTextViewHolder holder = getViewHolder();
        holder.editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);
        super.setupView(config);
    }
}
