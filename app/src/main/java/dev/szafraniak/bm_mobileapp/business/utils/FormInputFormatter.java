package dev.szafraniak.bm_mobileapp.business.utils;

public final class FormInputFormatter {

    public static String formatTrimAndNull(String value) {
        String trimmed = value.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }

    public static String formatNull(String value) {
        return value.trim().isEmpty() ? null : value;
    }
}
