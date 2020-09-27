package dev.szafraniak.bm_mobileapp.business.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FinancesUtils {

    public static BigDecimal safeCountGross(BigDecimal net, BigDecimal taxRate) {
        if (net == null || !Validator.validateNetPrice(net) ||
                taxRate == null || !Validator.validateTaxRate(taxRate)) {
            return null;
        }
        BigDecimal tax = taxRate.movePointLeft(2).multiply(net)
                .setScale(2, RoundingMode.HALF_UP);
        return tax.add(net);
    }
}
