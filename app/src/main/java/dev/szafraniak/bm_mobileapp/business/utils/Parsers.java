package dev.szafraniak.bm_mobileapp.business.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public final class Parsers {

    private final static DecimalFormat dfNoFraction = getDecimalFormatNoFraction();
    private final static DecimalFormat dfWithFraction = getDecimalFormatWithFraction();


    public static String safeFormatNoFraction(BigDecimal value, boolean zeroOnNull) {
        if (value == null) {
            return zeroOnNull ? "0" : null;
        }
        return dfNoFraction.format(value);
    }

    public static String safeFormatWithFraction(BigDecimal value, boolean zeroOnNull) {
        if (value == null) {
            return zeroOnNull ? "0" : null;
        }
        return dfWithFraction.format(value);
    }

    public static String safeFormatNoFraction(BigDecimal value) {
        return safeFormatNoFraction(value, false);
    }

    public static String safeFormatWithFraction(BigDecimal value) {
        return safeFormatWithFraction(value, false);
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

    public static String safeFormat(LocalDate dueDate) {
        if (dueDate != null) {
            return dueDate.toString();
        }
        return null;
    }

    public static Long parseToMills(LocalDate localDate) {
        return parseToMills(localDate, false);
    }

    public static Long parseToMills(LocalDate localDate, boolean useZone) {
        LocalDateTime localDateTime = localDate.atStartOfDay();
        return parseToMills(localDateTime, useZone);
    }

    public static Long parseToMills(LocalDateTime localDateTime) {
        return parseToMills(localDateTime, false);
    }

    public static Long parseToMills(LocalDateTime localDateTime, boolean useZone) {
        if (useZone) {
            return localDateTime.atZone(TimeUtils.getZoneId()).toInstant().toEpochMilli();
        }
        return localDateTime.atZone(TimeUtils.getUtcZoneId()).toInstant().toEpochMilli();
    }


    public static LocalDate parseMillsToLocalDate(long mills) {
        return parseMillsToLocalDate(mills, false);
    }

    public static LocalDate parseMillsToLocalDate(long mills, boolean useZone) {
        return parseMillsToLocalDateTime(mills, useZone).toLocalDate();
    }


    public static LocalDateTime parseMillsToLocalDateTime(long mills) {
        return parseMillsToLocalDateTime(mills, false);
    }

    public static LocalDateTime parseMillsToLocalDateTime(long mills, boolean useZone) {
        Instant instant = Instant.ofEpochMilli(mills);
        if (useZone) {
            return instant.atZone(TimeUtils.getZoneId()).toLocalDateTime();
        }
        return instant.atZone(TimeUtils.getUtcZoneId()).toLocalDateTime();
    }
}
