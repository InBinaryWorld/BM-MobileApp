package dev.szafraniak.bm_mobileapp.presentation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import com.trello.rxlifecycle3.LifecycleTransformer;

public interface BaseView {

    <T> LifecycleTransformer<T> bindToLifecycle();

    void startActivityForResult(Intent intent, int requestCode, Bundle options);

    Context getContext();

    void startActivity(Intent intent, Bundle options);

    FragmentManager getFManager();

    String getClassName();
}
