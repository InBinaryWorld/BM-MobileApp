package dev.szafraniak.bm_mobileapp.presentation;

import android.content.Context;

import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

public abstract class BaseActivity extends RxAppCompatActivity implements BaseView {

    @Override
    public Context getContext() {
        return this;
    }
}
