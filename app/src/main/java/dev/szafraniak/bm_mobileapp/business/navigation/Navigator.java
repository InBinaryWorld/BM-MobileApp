package dev.szafraniak.bm_mobileapp.business.navigation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.memory.SessionManager;
import dev.szafraniak.bm_mobileapp.presentation.BaseView;
import dev.szafraniak.bm_mobileapp.presentation.login.LoginActivity_;

public class Navigator {

    private final static String TAG_MAIN = "main_fragment";

    private static Bundle getBundleAnimation(Context ctx) {
        return ActivityOptions
                .makeCustomAnimation(ctx, R.anim.slide_in_from_right, R.anim.slide_out_to_left)
                .toBundle();
    }

    private static void startActivity(Context ctx, Intent intent) {
        ctx.startActivity(intent, getBundleAnimation(ctx));
    }

    public static void startActivity(Context ctx, Class<? extends Activity> cls) {
        Intent intent = new Intent(ctx, cls);
        ctx.startActivity(intent, getBundleAnimation(ctx));
    }

    public static void startActivityForResult(BaseView view, Class<? extends Activity> cls, int requestCode) {
        Intent intent = new Intent(view.getContext(), cls);
        view.startActivityForResult(intent, requestCode, getBundleAnimation(view.getContext()));
    }

    public static void startActivityOnEmptyStack(Context ctx, Class<? extends Activity> cls) {
        Intent intent = new Intent(ctx, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(ctx, intent);
    }

    public static void navigateToLoginActivity(Context ctx, SessionManager sessionManager) {
        sessionManager.clearSession();
        startActivityOnEmptyStack(ctx, LoginActivity_.class);
    }

    public static void logout(Context ctx, SessionManager sessionManager) {
        sessionManager.logout();
        startActivityOnEmptyStack(ctx, LoginActivity_.class);
    }

    public static void startNavigation(BaseView view) {
        int fragmentId = FragmentFactory.getMainId();
        Fragment mainFragment = FragmentFactory.getFragmentById(fragmentId);
        FragmentManager manager = view.getFManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_navigator_container, mainFragment, TAG_MAIN);
        transaction.addToBackStack(TAG_MAIN);
        transaction.commit();
    }

    public static void navigateTo(Integer fragmentId, BaseView view,
                                  Boolean withStack, Boolean pop) {
        FragmentManager fragmentManager = view.getFManager();
        Fragment fragment = FragmentFactory.getFragmentById(fragmentId);
        if (!getCurrentFragment(fragmentManager).equals(fragment)) {
            navigateTo(fragmentManager, fragment, withStack, pop);
        }
    }

    private static void navigateTo(FragmentManager fragmentManager, Fragment fragment,
                                   Boolean withStack, Boolean pop) {
        if (pop) {
            fragmentManager.popBackStack(TAG_MAIN, 0);
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_navigator_container, fragment);
        if (withStack && !getCurrentFragment(fragmentManager).equals(fragment)) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }


    public static Fragment getCurrentFragment(BaseView view) {
        FragmentManager manager = view.getFManager();
        return manager.findFragmentById(R.id.fl_navigator_container);
    }

    public static Fragment getCurrentFragment(FragmentManager manager) {
        return manager.findFragmentById(R.id.fl_navigator_container);
    }

    public static int getStackCount(BaseView view) {
        return view.getFManager().getBackStackEntryCount();
    }


}
