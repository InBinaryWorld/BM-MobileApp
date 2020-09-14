package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.price;

import java.math.BigDecimal;
import java.math.RoundingMode;

import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.FormRowParser;

public class PriceFormParser implements FormRowParser<PriceViewValue, Price> {
    @Override
    public Price parse(PriceViewValue value) {
        BigDecimal taxRate = parseTax(value.getTaxRateValue());
        BigDecimal netValue = parseNet(value.getNetValue());
        if (taxRate == null || netValue == null) {
            return null;
        }
        BigDecimal tax = taxRate.movePointLeft(2).multiply(netValue)
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal gross = tax.add(netValue);
        Price price = new Price();
        price.setNet(netValue);
        price.setTaxRate(taxRate);
        price.setGross(gross);
        return price;
    }

    public BigDecimal parseNet(String netValue) {
        return parseToBigDecimal(netValue);
    }

    public BigDecimal parseTax(String taxValue) {
        return parseToBigDecimal(taxValue);
    }

    private BigDecimal parseToBigDecimal(String value) {
        try {
            return new BigDecimal(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
