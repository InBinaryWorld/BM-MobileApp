package dev.szafraniak.bm_mobileapp.business.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

import lombok.Getter;

public abstract class TimeUtils {

    @Getter
    private final static ZoneId zoneId = TimeZone.getDefault().toZoneId();

    @Getter
    private final static ZoneId utcZoneId = TimeZone.getTimeZone("UTC").toZoneId();

    public static LocalDate getDate() {
        return LocalDate.now();
    }

    public static LocalDateTime getDateTime() {
        return LocalDateTime.now();
    }

    public static ZonedDateTime getZonedDateTime() {
        return LocalDateTime.now().atZone(zoneId);
    }

    public static ZonedDateTime getZonedDateTimeAtStartOfDay() {
        return LocalDate.now().atStartOfDay(zoneId);
    }

    // Not valid Date but sometimes is useful
    public static ZonedDateTime getZonedDateTimeAsUTC() {
        return LocalDateTime.now().atZone(utcZoneId);
    }

    // Not valid Date but sometimes is useful
    public static ZonedDateTime getZonedDateTimeAtStartOfDayAsUTC() {
        return LocalDate.now().atStartOfDay(utcZoneId);
    }

}
