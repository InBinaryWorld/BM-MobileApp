package dev.szafraniak.bm_mobileapp.business.utils;

import java.math.BigDecimal;
import java.text.DecimalFormatSymbols;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public final class Parser {

    /***
     * In app LocalDateTime, LocalTime always points to time in system zone
     * LocalDate, Instant, mils are always stored at UTC zone
     */

    public static final ZoneOffset offsetUTC = ZoneOffset.UTC;
    public static final ZoneOffset offsetCurrent = OffsetDateTime.now().getOffset();

    public static BigDecimal safeToBigDecimal(String value, boolean zeroOnNullOrEmpty) {
        return safeToBigDecimal(value, zeroOnNullOrEmpty, false);
    }

    public static BigDecimal safeToBigDecimal(String value, boolean zeroOnNullOrEmpty, boolean zeroOnException) {
        if (value == null || value.isEmpty()) {
            return zeroOnNullOrEmpty ? BigDecimal.ZERO : null;
        }
        try {
            DecimalFormatSymbols dfs = Formatter.getDecimalFormatSymbols();
            String valueEn = value
                    .replace(String.valueOf(dfs.getGroupingSeparator()), "")
                    .replace(dfs.getDecimalSeparator(), '.');
            return new BigDecimal(valueEn).stripTrailingZeros();
        } catch (NumberFormatException e) {
            return zeroOnException ? BigDecimal.ZERO : null;
        }
    }

    public static long parseToMillsAtStartOfDay(LocalDate localDate) {
        OffsetDateTime utcStartOfDay = localDate.atStartOfDay().atOffset(offsetUTC);
        return utcStartOfDay.toInstant().toEpochMilli();
    }

    public static LocalDate parseMillsToLocalDate(long mills) {
        Instant instant = Instant.ofEpochMilli(mills);
        return instant.atOffset(offsetUTC).toLocalDate();
    }

    public static LocalDateTime parseToLocalDateTime(OffsetDateTime value) {
        OffsetDateTime dateTimeAtSystemZone = value.withOffsetSameInstant(offsetCurrent);
        return dateTimeAtSystemZone.toLocalDateTime();
    }

    public static OffsetDateTime parseToOffsetDateTime(LocalDateTime value) {
        return value.atOffset(offsetCurrent);
    }
}
