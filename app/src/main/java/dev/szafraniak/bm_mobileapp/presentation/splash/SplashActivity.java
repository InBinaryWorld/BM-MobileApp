package dev.szafraniak.bm_mobileapp.presentation.splash;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;

import org.androidannotations.annotations.EActivity;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.BaseActivity;
import dev.szafraniak.bm_mobileapp.presentation.login.LoginActivity_;

import static dev.szafraniak.bm_mobileapp.business.Constance.SPLASH_DISPLAY_LENGTH;

@SuppressLint("Registered")
@EActivity(R.layout.activity_splash)
public class SplashActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(() -> {
            Navigator.startActivityOnEmptyStack(this, LoginActivity_.class);
        }, SPLASH_DISPLAY_LENGTH);
    }
}
