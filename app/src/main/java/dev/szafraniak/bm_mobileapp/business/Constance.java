package dev.szafraniak.bm_mobileapp.business;

public final class Constance {
    public static final long SPLASH_DISPLAY_LENGTH = 1500;

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public final static String PREFERENCES_SESSION_PREFIX = "BM_Session";
    public final static String PREFERENCES_FORMS_PREFIX = "BM_Forms";
    public final static String PREFERENCES_USER_PREFIX = "BM_User";

    // Activity result code must consist of no more than 16 bits (0-65535)
    public final static int ACTIVITY_RESULT_CAMERA = 100;
    public final static int ACTIVITY_RESULT_WRITE_EXTERNAL_STORAGE = 101;
    public final static int ACTIVITY_RESULT_CODE_GOOGLE_LOGIN = 1000;
    public final static int ACTIVITY_RESULT_CODE_FACEBOOK_LOGIN = 64206;
}
