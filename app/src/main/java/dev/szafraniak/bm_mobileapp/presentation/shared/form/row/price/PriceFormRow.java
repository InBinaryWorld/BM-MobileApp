package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.utils.Formatters;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;

public class PriceFormRow<T> extends BaseFormRow<T, PriceViewValue, Price, PriceViewHolder, PriceFormRowConfig<T>> {
    @LayoutRes
    private static final int layoutId = R.layout.row_form_price;

    public PriceFormRow(LayoutInflater inflater, ViewGroup viewGroup, PriceFormRowConfig<T> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected PriceViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, PriceFormRowConfig<T> config) {
        View view = inflater.inflate(layoutId, viewGroup, false);
        TextInputLayout netPriceLayout = view.findViewById(R.id.til_net_price);
        TextInputEditText netPriceEditText = view.findViewById(R.id.et_net_price);
        TextInputLayout taxRateLayout = view.findViewById(R.id.til_tax_rate);
        TextInputEditText taxRateEditText = view.findViewById(R.id.et_tax_rate);
        TextInputLayout grossPriceLayout = view.findViewById(R.id.til_gross_price);
        TextInputEditText grossPriceEditText = view.findViewById(R.id.et_gross_price);

        PriceViewHolder holder = new PriceViewHolder();
        holder.setView(view);
        holder.setNetPriceLayout(netPriceLayout);
        holder.setNetPriceEditText(netPriceEditText);
        holder.setTaxRateLayout(taxRateLayout);
        holder.setTaxRateEditText(taxRateEditText);
        holder.setGrossPriceLayout(grossPriceLayout);
        holder.setGrossPriceEditText(grossPriceEditText);

        taxRateLayout.setHint(config.getTaxRateLabel());
        netPriceLayout.setHint(config.getNetLabel());
        taxRateEditText.setText(config.getTaxRateInitValue());
        netPriceEditText.setText(config.getNetInitValue());


        grossPriceEditText.setEnabled(false);
        grossPriceLayout.setHint(config.getGrossLabel());
        grossPriceEditText.setText(config.getGrossInitValue());

        netPriceEditText.addTextChangedListener(new AfterTextChangeListener() {
            @Override
            public void afterTextChanged(Editable editable) {
                updateNetView();
                updateGrossView();
                onValueChange();
            }
        });
        taxRateEditText.addTextChangedListener(new AfterTextChangeListener() {
            @Override
            public void afterTextChanged(Editable editable) {
                updateTaxView();
                updateGrossView();
                onValueChange();
            }
        });
        return holder;
    }

    @Override
    protected void setEnabled(boolean enabled) {
        PriceViewHolder holder = getViewHolder();
        TextInputLayout netLayout = holder.getNetPriceLayout();
        TextInputLayout taxLayout = holder.getTaxRateLayout();
        netLayout.setEndIconVisible(enabled);
        taxLayout.setEndIconVisible(enabled);
        netLayout.setEnabled(enabled);
        taxLayout.setEnabled(enabled);
    }

    @Override
    protected PriceViewValue getValueToParse() {
        PriceViewHolder holder = getViewHolder();
        TextInputEditText netEditText = holder.getNetPriceEditText();
        TextInputEditText taxEditText = holder.getTaxRateEditText();
        PriceViewValue viewValue = new PriceViewValue();
        viewValue.setNetValue(netEditText.getText().toString());
        viewValue.setTaxRateValue(taxEditText.getText().toString());
        return viewValue;
    }

    private void updateNetView() {
        PriceViewHolder holder = getViewHolder();
        PriceFormParser parser = getConfig().getParser();
        PriceValidator validator = getConfig().getValidator();

        PriceViewValue valueToParse = getValueToParse();
        BigDecimal value = parser.parseNet(valueToParse.getNetValue());
        if (value == null || !validator.validateNet(value)) {
            setError(true, getConfig().getNetInvalidMessage(), holder.getNetPriceLayout());
            return;
        }
        setError(false, getConfig().getNetInvalidMessage(), holder.getNetPriceLayout());
    }

    private void updateTaxView() {
        PriceViewHolder holder = getViewHolder();
        PriceFormParser parser = getConfig().getParser();
        PriceValidator validator = getConfig().getValidator();

        PriceViewValue valueToParse = getValueToParse();
        BigDecimal value = parser.parseTax(valueToParse.getTaxRateValue());
        if (value == null || !validator.validateTax(value)) {
            setError(true, getConfig().getTaxInvalidMessage(), holder.getTaxRateLayout());
            return;
        }
        setError(false, getConfig().getTaxInvalidMessage(), holder.getTaxRateLayout());
    }

    private void updateGrossView() {
        Price price = getValueFromView();
        if (price == null || !isValid(price)) {
            setGross(false, null);
            return;
        }
        setGross(true, price.getGross());
    }

    protected void setError(boolean enabled, String invalidMessage, TextInputLayout layout) {
        String err = enabled ? invalidMessage : null;
        layout.setErrorEnabled(enabled);
        layout.setError(err);
    }

    private void setGross(boolean isValid, BigDecimal gross) {
        PriceViewHolder holder = getViewHolder();
        TextInputEditText grossEditText = holder.getGrossPriceEditText();
        if (!isValid) {
            grossEditText.getText().clear();
            return;
        }
        grossEditText.setText(Formatters.formatWithFraction(gross));
    }

    private abstract static class AfterTextChangeListener implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
    }
}
