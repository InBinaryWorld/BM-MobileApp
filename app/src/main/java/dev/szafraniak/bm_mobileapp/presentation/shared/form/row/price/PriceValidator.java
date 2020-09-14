package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price;

import java.math.BigDecimal;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.FormRowValidator;

public class PriceValidator implements FormRowValidator<Price> {

    @Override
    public boolean validate(Price value) {
        return validateNet(value.getNet()) && validateTax(value.getTaxRate());
    }

    public boolean validateNet(BigDecimal value) {
        return value.scale() <= 2 && value.signum() >= 0;
    }

    public boolean validateTax(BigDecimal value) {
        return value.scale() == 0 && value.signum() >= 0;
    }
}
