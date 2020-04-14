package dev.szafraniak.bm_mobileapp.business.memory;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;
import static dev.szafraniak.bm_mobileapp.business.Constance.PREFERENCES_SESSION_PREFIX;

public class SessionPreferences {

    private final SharedPreferences sharedPreferences;


    public SessionPreferences(Context ctx) {
        sharedPreferences = ctx.getSharedPreferences(PREFERENCES_SESSION_PREFIX, MODE_PRIVATE);
    }
}
