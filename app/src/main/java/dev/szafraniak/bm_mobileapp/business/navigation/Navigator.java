package dev.szafraniak.bm_mobileapp.business.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import dev.szafraniak.bm_mobileapp.business.memory.SessionManager;
import dev.szafraniak.bm_mobileapp.presentation.BaseView;

public class Navigator {

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
}
