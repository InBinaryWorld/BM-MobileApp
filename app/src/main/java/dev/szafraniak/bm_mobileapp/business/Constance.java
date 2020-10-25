package dev.szafraniak.bm_mobileapp.business;

public final class Constance {

    public static final long SPLASH_DISPLAY_LENGTH = 1500;

    public static final char DECIMAL_SEPARATOR = '.';
    public static final char GROUPING_SEPARATOR = ',';

    public static final String CURRENCY = "PLN";
    public static final String TIME_PATTERN = "HH:mm";
    public static final String DATE_PATTERN = "yyyy.MM.dd";
    public static final String DATE_TIME_PATTERN = "yyyy.MM.dd HH:mm";

    public final static String PREFERENCES_USER_PREFIX = "BM_User";
    public final static String PREFERENCES_FORMS_PREFIX = "BM_Forms";
    public final static String PREFERENCES_SESSION_PREFIX = "BM_Session";

    // Activity result code must consist of no more than 16 bits (0-65535)
    public final static int ACTIVITY_RESULT_CAMERA = 100;
    public final static int ACTIVITY_RESULT_CODE_GOOGLE_LOGIN = 1000;
    public final static int ACTIVITY_RESULT_CODE_FACEBOOK_LOGIN = 64206;
    public final static int ACTIVITY_RESULT_WRITE_EXTERNAL_STORAGE = 101;
}
