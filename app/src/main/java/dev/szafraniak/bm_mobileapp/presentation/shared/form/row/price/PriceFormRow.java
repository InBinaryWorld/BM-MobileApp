package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.LayoutRes;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.utils.Formatters;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowFulFiller;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowValidator;
import lombok.Getter;

public class PriceFormRow<T> implements FormRowInterface<T> {

    @LayoutRes
    private final int layoutId = R.layout.row_form_price;

    @Getter
    private final PriceFormRowConfig<T> config;

    @Getter
    private final PriceViewHolder viewHolder;

    private final FormRowFulFiller<T, Price> fulFiller;

    public PriceFormRow(LayoutInflater inflater, ViewGroup viewGroup, PriceFormRowConfig<T> config) {
        this.config = config;
        this.fulFiller = config.getFulFiller();
        this.viewHolder = createViewHolder(inflater, viewGroup, config);
        this.setEnabled(config.isEnabled());
    }

    protected Price getValue() {
        if (isEnabled()) {
            return getOriginalValue();
        }
        return getDisabledValue();
    }

    private Price getDisabledValue() {
        switch (config.getDisableValueMode()) {
            case NULL:
                return null;
            case CUSTOM:
                return config.getDisableCustomValue();
            default:
                return getOriginalValue();
        }
    }

    @Override
    public View getView() {
        PriceViewHolder holder = getViewHolder();
        return holder.getView();
    }

    @Override
    public void fillModel(T model) {
        Price value = getValue();
        fulFiller.fulfill(model, value);
    }

    private boolean isNetValid() {
        TextInputEditText netEditText = getViewHolder().getNetPriceEditText();
        FormRowValidator<BigDecimal> validator = getConfig().getNetValidator();
        BigDecimal number = extractNumber(netEditText);
        return validator.validate(number);
    }

    private boolean isTaxValid() {
        TextInputEditText taxEditText = getViewHolder().getTaxRateEditText();
        FormRowValidator<BigDecimal> validator = getConfig().getTaxRateValidator();
        BigDecimal number = extractNumber(taxEditText);
        return validator.validate(number);
    }

    @Override
    public boolean isValid() {
        return isNetValid() && isTaxValid();
    }


    private PriceViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup,
                                             PriceFormRowConfig<T> config) {
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

        netPriceLayout.setEnabled(config.isEnabled());
        netPriceLayout.setHint(config.getNetLabel());
        netPriceEditText.setText(config.getNetInitValue());

        taxRateLayout.setEnabled(config.isEnabled());
        taxRateLayout.setHint(config.getTaxRateLabel());
        taxRateEditText.setText(config.getTaxRateInitValue());

        grossPriceEditText.setEnabled(false);
        grossPriceLayout.setHint(config.getGrossLabel());
        grossPriceEditText.setText(config.getGrossInitValue());

        netPriceEditText.addTextChangedListener(new AfterTextChangeListener() {
            @Override
            public void afterTextChanged(Editable editable) {
                updateNetView();
                setGross();
            }
        });
        taxRateEditText.addTextChangedListener(new AfterTextChangeListener() {
            @Override
            public void afterTextChanged(Editable editable) {
                updateTaxView();
                setGross();
            }
        });
        return holder;
    }

    private BigDecimal getNetPrice() {
        TextInputEditText netEditText = getViewHolder().getNetPriceEditText();
        return extractNumber(netEditText);
    }

    private BigDecimal getTaxRate() {
        TextInputEditText taxEditText = getViewHolder().getTaxRateEditText();
        return extractNumber(taxEditText);
    }

    private BigDecimal getGross() {
        TextInputEditText grossEditText = getViewHolder().getGrossPriceEditText();
        return extractNumber(grossEditText);
    }

    private BigDecimal extractNumber(TextInputEditText et) {
        String text = Objects.requireNonNull(et.getText()).toString();
        if (text.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(text);
    }

    private void setGross() {
        TextInputEditText grossEditText = getViewHolder().getGrossPriceEditText();
        if (!isNetValid() || !isTaxValid()) {
            grossEditText.setText("-");
            return;
        }
        BigDecimal netPrice = getNetPrice();
        BigDecimal taxRate = getTaxRate();
        BigDecimal tax = taxRate.movePointLeft(2).multiply(netPrice)
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal gross = tax.add(netPrice);
        grossEditText.setText(Formatters.formatWithFraction(gross));
    }

    private void updateNetView() {
        TextInputLayout netLayout = getViewHolder().getNetPriceLayout();
        String netInvalidMessage = getConfig().getNetInvalidMessage();
        setError(!isNetValid(), netInvalidMessage, netLayout);
    }

    private void updateTaxView() {
        TextInputLayout taxLayout = getViewHolder().getTaxRateLayout();
        String taxInvalidMessage = getConfig().getTaxInvalidMessage();
        setError(!isTaxValid(), taxInvalidMessage, taxLayout);
    }

    protected void setError(boolean enabled, String invalidMessage, TextInputLayout layout) {
        String err = enabled ? invalidMessage : null;
        layout.setErrorEnabled(enabled);
        layout.setError(err);
    }

    protected Price getOriginalValue() {
        if (!isValid()) {
            return null;
        }
        Price price = new Price();
        price.setNet(getNetPrice());
        price.setTaxRate(getTaxRate());
        price.setGross(getGross());
        return price;
    }

    protected boolean isEnabled() {
        PriceViewHolder holder = getViewHolder();
        TextInputLayout netLayout = holder.getNetPriceLayout();
        return netLayout.isEnabled();
    }

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
    public void setOnValueChange(BaseFormFragment.Callback onValueChange) {
        PriceViewHolder holder = getViewHolder();
        EditText netPriceEditText = holder.getNetPriceEditText();
        EditText taxRateEditText = holder.getTaxRateEditText();
        netPriceEditText.addTextChangedListener(new AfterTextChangeListener() {
            @Override
            public void afterTextChanged(Editable editable) {
                callIfValid(onValueChange);
            }
        });
        taxRateEditText.addTextChangedListener(new AfterTextChangeListener() {
            @Override
            public void afterTextChanged(Editable editable) {
                callIfValid(onValueChange);
            }
        });
    }

    public void callIfValid(BaseFormFragment.Callback onValueChange) {
        if (isValid()) {
            onValueChange.call();
        }
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
