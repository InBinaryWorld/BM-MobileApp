package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.number;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText.EditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormViewHolder;

public class IntegerEditTextFormRow extends EditTextFormRow<BigDecimal, TextFormConfig<BigDecimal>> {

    public IntegerEditTextFormRow(LayoutInflater inflater, ViewGroup viewGroup, TextFormConfig<BigDecimal> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected BigDecimal parseInput(String inputValue) {
        TextFormConfig<BigDecimal> config = getConfig();
        return Parsers.safeToBigDecimal(inputValue, !config.isReadEmptyAsNull());
    }

    @Override
    protected String parseToDisplay(BigDecimal value) {
        return Parsers.safeFormatNoFractionNoSep(value);
    }

    @Override
    protected void setupView(LayoutInflater inflater, TextFormConfig<BigDecimal> config) {
        TextFormViewHolder<TextInputEditText> holder = getViewHolder();
        holder.editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);
        super.setupView(inflater, config);
    }
}
