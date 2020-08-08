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

    private final static String TAG_START = "main_fragment";

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

    public static void startCompanyNavigation(BaseView view) {
        int fragmentId = FragmentFactory.getCompanyMainFragmentId();
        startNavigation(view, fragmentId);
    }

    public static void startMenuNavigation(BaseView view) {
        int fragmentId = FragmentFactory.getMenuMainFragmentId();
        startNavigation(view, fragmentId);
    }

    private static void startNavigation(BaseView view, int fragmentId) {
        Fragment mainFragment = FragmentFactory.getFragmentById(fragmentId);
        FragmentManager manager = view.getFManager();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_navigator_container, mainFragment, TAG_START);
        transaction.addToBackStack(TAG_START);
        transaction.commit();
    }

    public static void backToStart(BaseView view) {
        backTo(view, TAG_START);
    }

    public static void backTo(BaseView view, int fragmentId) {
        String tag = getFragmentTag(fragmentId);
        backTo(view, tag);
    }

    private static void backTo(BaseView view, String tag) {
        FragmentManager fm = view.getFManager();
        fm.popBackStack(tag, 0);
    }

    public static void backToStartAndNavigateTo(BaseView view, Integer fragmentId) {
        backAndNavigateTo(view, fragmentId, TAG_START);
    }

    public static void backAndNavigateTo(BaseView view, Integer fragmentId, int backToFragmentId) {
        String tag = getFragmentTag(backToFragmentId);
        backAndNavigateTo(view, fragmentId, tag);
    }

    private static void backAndNavigateTo(BaseView view, Integer fragmentId, String backToTag) {
        FragmentManager fragmentManager = view.getFManager();
        Fragment fragment = FragmentFactory.getFragmentById(fragmentId);
        backAndNavigateTo(fragmentManager, fragment, backToTag);
    }

    private static void backAndNavigateTo(FragmentManager fm, Fragment fragment, String backToTag) {
        fm.popBackStack(backToTag, 0);
        navigateTo(fm, fragment);
    }

    public static void navigateTo(BaseView view, Integer fragmentId) {
        FragmentManager fragmentManager = view.getFManager();
        Fragment fragment = FragmentFactory.getFragmentById(fragmentId);
        navigateTo(fragmentManager, fragment);
    }

    private static void navigateTo(FragmentManager fragmentManager, Fragment fragment) {
        if (isAlreadyLoaded(fragmentManager, fragment)) {
            return;
        }
        String tag = getFragmentTag(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_navigator_container, fragment);
        transaction.addToBackStack(tag);
        transaction.commit();
    }


    public static boolean isAlreadyLoaded(FragmentManager fm, Fragment fragment) {
        return fragment.getClass().equals(getCurrentFragment(fm).getClass());
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

    private static String getFragmentTag(int fragmentId) {
        return FragmentFactory.getFragmentById(fragmentId).getClass().getName();
    }

    private static String getFragmentTag(Fragment fragment) {
        return fragment.getClass().getName();
    }

}
