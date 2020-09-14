package dev.szafraniak.bm_mobileapp.business.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public final class Formatters {

    private final static DecimalFormat dfNoFraction = getDecimalFormatNoFraction();
    private final static DecimalFormat dfWithFraction = getDecimalFormatWithFraction();

    public static String formatTrimAndNull(String value) {
        String trimmed = value.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }

    public static String parseNullIfEmpty(String value) {
        return value.trim().isEmpty() ? null : value;
    }

    public static String formatNoFraction(BigDecimal value) {
        return dfNoFraction.format(value);
    }

    public static String formatWithFraction(BigDecimal value) {
        return dfWithFraction.format(value);
    }


    private static DecimalFormatSymbols getDecimalFormatSymbols() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(',');
        return symbols;
    }

    private static DecimalFormat getDecimalFormatWithFraction() {
        DecimalFormat format = new DecimalFormat();
        format.setDecimalFormatSymbols(getDecimalFormatSymbols());
        format.setMinimumIntegerDigits(1);
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
        return format;
    }

    private static DecimalFormat getDecimalFormatNoFraction() {
        DecimalFormat format = new DecimalFormat();
        format.setDecimalFormatSymbols(getDecimalFormatSymbols());
        format.setMinimumIntegerDigits(1);
        format.setMaximumFractionDigits(0);
        return format;
    }
}
