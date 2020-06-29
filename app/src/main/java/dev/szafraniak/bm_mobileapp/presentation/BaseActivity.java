package dev.szafraniak.bm_mobileapp.presentation;

import android.content.Context;

import androidx.fragment.app.FragmentManager;

import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

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
}
