package dev.szafraniak.bm_mobileapp.business.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import dev.szafraniak.bm_mobileapp.business.Constance;

public class Formatter {

    private final static DecimalFormat dfPrice = getDecimalFormatPrice();
    private final static DecimalFormat dfFraction = getDecimalFormatWithFraction();
    private final static DecimalFormat dfNoFraction = getDecimalFormatNoFraction();
    private final static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern(Constance.TIME_PATTERN);
    private final static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(Constance.DATE_PATTERN);
    private final static DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(Constance.DATE_TIME_PATTERN);

    public static String safeFormatPrice(BigDecimal value) {
        return value == null ? null : dfPrice.format(value);
    }

    public static String safeFormatPrice(BigDecimal value, String currency) {
        String number = safeFormatPrice(value);
        return number == null ? null : String.format("%s %s", number, currency);
    }

    public static String safeFormatNoFraction(BigDecimal value) {
        return value == null ? null : dfNoFraction.format(value);
    }

    public static String safeFormatNoFractionNoSep(BigDecimal value) {
        String number = safeFormatNoFraction(value);
        return number == null ? null : removeSeparator(number);
    }

    public static String safeFormatWithFraction(BigDecimal value) {
        return value == null ? null : dfFraction.format(value);
    }

    public static String safeFormatWithFractionNoSep(BigDecimal value) {
        String number = safeFormatWithFraction(value);
        return number == null ? null : removeSeparator(number);
    }

    private static String removeSeparator(String value) {
        return value.replaceAll(String.valueOf(Constance.GROUPING_SEPARATOR), "");
    }


    private static DecimalFormat getBaseDecimalFormat() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        if (Constance.DECIMAL_SEPARATOR.length() == 1) {
            symbols.setDecimalSeparator(Constance.DECIMAL_SEPARATOR.charAt(0));
        }
        symbols.setGroupingSeparator(Constance.GROUPING_SEPARATOR);

        DecimalFormat format = new DecimalFormat();
        format.setDecimalFormatSymbols(symbols);
        return format;
    }

    private static DecimalFormat getDecimalFormatWithFraction() {
        DecimalFormat format = getBaseDecimalFormat();
        format.setMinimumFractionDigits(0);
        format.setMaximumFractionDigits(Integer.MAX_VALUE);
        return format;
    }

    private static DecimalFormat getDecimalFormatPrice() {
        DecimalFormat format = getBaseDecimalFormat();
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
        return format;
    }

    private static DecimalFormat getDecimalFormatNoFraction() {
        DecimalFormat format = getBaseDecimalFormat();
        format.setMaximumFractionDigits(0);
        return format;
    }

    public static String safeFormatDateTime(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        OffsetDateTime dateTime = offsetDateTime.withOffsetSameInstant(Parser.offsetCurrent);
        return safeFormatDateTime(dateTime.toLocalDateTime());
    }

    public static String safeFormatDate(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        OffsetDateTime dateTime = offsetDateTime.withOffsetSameInstant(Parser.offsetCurrent);
        return safeFormatDate(dateTime.toLocalDate());
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

    public static String safeFormatTime(LocalTime value) {
        if (value != null) {
            return timeFormat.format(value);
        }
        return null;
    }

}
