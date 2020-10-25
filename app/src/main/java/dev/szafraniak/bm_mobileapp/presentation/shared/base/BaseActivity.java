package dev.szafraniak.bm_mobileapp.presentation.shared.base;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.FragmentManager;

import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;

public abstract class BaseActivity extends RxAppCompatActivity implements BaseView {

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public FragmentManager getFManager() {
        return getSupportFragmentManager();
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void onBackPressed() {
        if (Navigator.getStackCount(this) == 1) {
            finish();
        }
        super.onBackPressed();
    }
}
