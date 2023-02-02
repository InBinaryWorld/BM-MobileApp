package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.number;

import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.utils.Formatter;
import dev.szafraniak.bm_mobileapp.business.utils.Parser;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.editText.EditTextFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextFormViewHolder;

public class DecimalEditTextFormRow extends EditTextFormRow<BigDecimal, TextFormConfig<BigDecimal>> {

    public DecimalEditTextFormRow(LayoutInflater inflater, ViewGroup viewGroup, TextFormConfig<BigDecimal> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected BigDecimal parseInput(String inputValue) {
        TextFormConfig<BigDecimal> config = getConfig();
        return Parser.safeToBigDecimal(inputValue, !config.isReadEmptyAsNull());
    }

    @Override
    protected String parseToDisplay(BigDecimal value) {
        return Formatter.safeFormatWithFractionNoSep(value);
    }

    @Override
    protected void setupView(LayoutInflater inflater, TextFormConfig<BigDecimal> config) {
        super.setupView(inflater, config);
        TextFormViewHolder<TextInputEditText> holder = getViewHolder();
        holder.editText.setKeyListener(new DecimalKeyListener());
    }

    public static class DecimalKeyListener extends DigitsKeyListener {
        private final char[] acceptedCharacters = new char[]{
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-',
                Formatter.getDecimalFormatSymbols().getDecimalSeparator()
        };

        @Override
        protected char[] getAcceptedChars() {
            return acceptedCharacters;
        }

        public int getInputType() {
            return InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL;
        }
    }

}
