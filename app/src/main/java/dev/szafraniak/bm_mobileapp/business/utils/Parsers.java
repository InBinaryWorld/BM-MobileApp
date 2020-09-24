package dev.szafraniak.bm_mobileapp.business.utils;

import java.math.BigDecimal;

public final class Parsers {

    public static BigDecimal safeToBigDecimal(String value) {
        return safeToBigDecimal(value, false);
    }

    public static BigDecimal safeToBigDecimal(String value, boolean zeroOnNullOrEmpty) {
        return safeToBigDecimal(value, zeroOnNullOrEmpty, false);
    }

    public static BigDecimal safeToBigDecimal(String value, boolean zeroOnNullOrEmpty, boolean zeroOnException) {
        if (value == null || value.isEmpty()) {
            return zeroOnNullOrEmpty ? BigDecimal.ZERO : null;
        }
        try {
            return new BigDecimal(value);
        } catch (NumberFormatException e) {
            return zeroOnException ? BigDecimal.ZERO : null;
        }
    }

}
