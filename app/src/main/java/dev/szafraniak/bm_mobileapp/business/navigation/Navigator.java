package dev.szafraniak.bm_mobileapp.business.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.memory.SessionManager;
import dev.szafraniak.bm_mobileapp.presentation.BaseView;

public class Navigator {

    private final static String TAG_MAIN = "main_fragment";

    private static Bundle newActivityAnimation(Context ctx) {
        return null;
    }

    private static void startActivity(Context ctx, Intent intent) {
        ctx.startActivity(intent, newActivityAnimation(ctx));
    }

    private static void startActivityForResult(BaseView view, Intent intent, int requestCode) {
        view.startActivityForResult(intent, requestCode, newActivityAnimation(view.getContext()));
    }

    private static void startActivityOnEmptyStack(Context ctx, Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(ctx, intent);
    }

    public static void restartApplication(Context ctx, SessionManager sessionManager) {
        sessionManager.clearSession();
        Intent intent = ctx.getPackageManager()
                .getLaunchIntentForPackage(ctx.getPackageName());
        startActivityOnEmptyStack(ctx, intent);
    }

    public static void startActivityOnEmptyStack(Context ctx, Class<? extends Activity> cls) {
        Intent intent = new Intent(ctx, cls);
        startActivityOnEmptyStack(ctx, intent);
    }

    public static void startActivity(Context ctx, Class<? extends Activity> cls) {
        Intent intent = new Intent(ctx, cls);
        ctx.startActivity(intent, newActivityAnimation(ctx));
    }

    public static void startActivityForResult(BaseView view, Class<? extends Activity> cls, int requestCode) {
        Intent intent = new Intent(view.getContext(), cls);
        startActivityForResult(view, intent, requestCode);
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
