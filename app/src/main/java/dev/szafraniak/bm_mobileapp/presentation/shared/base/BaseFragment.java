package dev.szafraniak.bm_mobileapp.presentation.shared.base;


import android.view.View;

import androidx.annotation.IdRes;
import androidx.fragment.app.FragmentManager;

import com.trello.rxlifecycle3.components.support.RxFragment;

import org.androidannotations.annotations.EFragment;

import java.util.Objects;

@EFragment
public abstract class BaseFragment extends RxFragment implements BaseView {

    @Override
    public FragmentManager getFManager() {
        return Objects.requireNonNull(getActivity()).getSupportFragmentManager();
    }

    @Override
    public String getClassName() {
        return getClass().getName();
    }

    protected View findViewById(@IdRes int id) {
        return Objects.requireNonNull(getView()).findViewById(id);
    }

}
