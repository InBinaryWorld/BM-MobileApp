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
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.presentation.shared.base.BaseView;
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

    public static void back(BaseView view) {
        backTo(view, null);
    }

    public static void backTo(BaseView view, int fragmentId) {
        String tag = getFragmentTag(fragmentId);
        backTo(view, tag);
    }

    private static void backTo(BaseView view, String tag) {
        FragmentManager fm = view.getFManager();
        fm.popBackStack(tag, 0);
    }

    public static void backToStartAndNavigateTo(BaseView view, int fragmentId) {
        backAndNavigateTo(view, fragmentId, TAG_START, null);
    }

    public static void backToStartAndNavigateTo(BaseView view, int fragmentId, Bundle args) {
        backAndNavigateTo(view, fragmentId, TAG_START, args);
    }

    public static void backOneAndNavigateTo(BaseView view, int fragmentId) {
        backOneAndNavigateTo(view, fragmentId, null);
    }

    public static void backOneAndNavigateTo(BaseView view, int fragmentId, Bundle args) {
        backAndNavigateTo(view, fragmentId, null, args);
    }

    public static void backAndNavigateTo(BaseView view, int fragmentId, int backToFragmentId) {
        String tag = getFragmentTag(backToFragmentId);
        backAndNavigateTo(view, fragmentId, tag, null);
    }

    public static void backAndNavigateTo(BaseView view, int fragmentId, int backToFragmentId, Bundle args) {
        String tag = getFragmentTag(backToFragmentId);
        backAndNavigateTo(view, fragmentId, tag, args);
    }

    private static void backAndNavigateTo(BaseView view, int fragmentId, String backToTag, Bundle args) {
        FragmentManager fragmentManager = view.getFManager();
        Fragment fragment = FragmentFactory.getFragmentById(fragmentId);
        backAndNavigateTo(fragmentManager, fragment, backToTag, args);
    }

    private static void backAndNavigateTo(FragmentManager fm, Fragment fragment, String backToTag, Bundle args) {
        if (isAlreadyLoaded(fm, fragment)) {
            return;
        }
        fm.popBackStack(backToTag, 0);
        navigate(fm, fragment, args);
    }

    public static void navigateTo(BaseView view, int fragmentId) {
        FragmentManager fragmentManager = view.getFManager();
        Fragment fragment = FragmentFactory.getFragmentById(fragmentId);
        navigateTo(fragmentManager, fragment, null);
    }

    public static void navigateTo(BaseView view, int fragmentId, Bundle args) {
        FragmentManager fragmentManager = view.getFManager();
        Fragment fragment = FragmentFactory.getFragmentById(fragmentId);
        navigateTo(fragmentManager, fragment, args);
    }

    private static void navigateTo(FragmentManager fragmentManager, Fragment fragment, Bundle args) {
        if (isAlreadyLoaded(fragmentManager, fragment)) {
            return;
        }
        navigate(fragmentManager, fragment, args);
    }

    private static void navigate(FragmentManager fragmentManager, Fragment fragment, Bundle args) {
        fragment.setArguments(args);
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
