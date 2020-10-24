package dev.szafraniak.bm_mobileapp.business.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import dev.szafraniak.bm_mobileapp.business.Constance;

public final class Parsers {

    private final static char decimalSep = '.';
    private final static char groupingSep = ',';

    private final static DecimalFormat dfPrice = getDecimalFormatPrice();
    private final static DecimalFormat dfNoFraction = getDecimalFormatNoFraction();
    private final static DecimalFormat dfWithFraction = getDecimalFormatWithFraction();
    private final static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern(Constance.TIME_PATTERN);
    private final static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(Constance.DATE_PATTERN);
    private final static DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(Constance.DATE_TIME_PATTERN);


    public static String safeFormatNoFraction(BigDecimal value, boolean zeroOnNull) {
        if (value == null) {
            return zeroOnNull ? "0" : null;
        }
        return dfNoFraction.format(value);
    }

    public static String safeFormatPrice(BigDecimal value, boolean zeroOnNull) {
        if (value == null) {
            return zeroOnNull ? "0" : null;
        }
        return dfPrice.format(value);
    }

    public static String safeFormatPrice(BigDecimal value) {
        return safeFormatPrice(value, false);
    }

    public static String safeFormatPrice(BigDecimal value, String currency) {
        String numberString = safeFormatPrice(value);
        if (numberString == null) {
            return null;
        }
        return String.format("%s %s", numberString, currency);
    }

    public static String safeFormatNoFraction(BigDecimal value) {
        return safeFormatNoFraction(value, false);
    }

    public static String safeFormatNoFractionNoSep(BigDecimal value) {
        String number = safeFormatNoFraction(value, false);
        if (number != null) {
            return number.replaceAll(String.valueOf(groupingSep), "");
        }
        return null;
    }

    public static String safeFormatWithFraction(BigDecimal value, boolean zeroOnNull) {
        if (value == null) {
            return zeroOnNull ? "0" : null;
        }
        return dfWithFraction.format(value);
    }

    public static String safeFormatWithFraction(BigDecimal value) {
        return safeFormatWithFraction(value, false);
    }

    public static String safeFormatWithFractionNoSep(BigDecimal value) {
        String number = safeFormatWithFraction(value, false);
        if (number != null) {
            return number.replaceAll(String.valueOf(groupingSep), "");
        }
        return null;
    }


    private static DecimalFormatSymbols getDecimalFormatSymbols() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(decimalSep);
        symbols.setGroupingSeparator(groupingSep);
        return symbols;
    }

    private static DecimalFormat getDecimalFormatPrice() {
        DecimalFormat format = new DecimalFormat();
        format.setDecimalFormatSymbols(getDecimalFormatSymbols());
        format.setMinimumIntegerDigits(1);
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
        return format;
    }

    private static DecimalFormat getDecimalFormatWithFraction() {
        DecimalFormat format = new DecimalFormat();
        format.setDecimalFormatSymbols(getDecimalFormatSymbols());
        format.setMinimumIntegerDigits(1);
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

    public static String safeFormatDateTime(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        ZoneOffset offset = OffsetDateTime.now().getOffset();
        OffsetDateTime dateTimeAtSystemZone = offsetDateTime.withOffsetSameInstant(offset);
        return dateTimeAtSystemZone.format(dateTimeFormat);
    }

    public static String safeFormatDate(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        ZoneOffset offset = OffsetDateTime.now().getOffset();
        OffsetDateTime dateTimeAtSystemZone = offsetDateTime.withOffsetSameInstant(offset);
        return dateTimeAtSystemZone.format(dateFormat);
    }

    public static String safeFormatDate(LocalDate dueDate) {
        if (dueDate != null) {
            return dueDate.format(dateFormat);
        }
        return null;
    }

    public static String safeFormatDateTime(LocalDateTime dueDate) {
        if (dueDate != null) {
            return dueDate.format(dateTimeFormat);
        }
        return null;
    }

    public static String safeFormatDate(LocalDateTime dueDate) {
        if (dueDate != null) {
            return dueDate.format(dateFormat);
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

    public static String safeFormatTime(LocalTime value) {
        if (value != null) {
            return timeFormat.format(value);
        }
        return null;
    }

    public static LocalDateTime parseToLocalDateTime(OffsetDateTime value) {
        ZoneOffset offset = OffsetDateTime.now().getOffset();
        OffsetDateTime dateTimeAtSystemZone = value.withOffsetSameInstant(offset);
        return dateTimeAtSystemZone.toLocalDateTime();
    }

    public static OffsetDateTime parseToOffsetDateTime(LocalDateTime value) {
        if (value == null) {
            return null;
        }
        ZoneOffset offset = OffsetDateTime.now().getOffset();
        return value.atOffset(offset);
    }
}
