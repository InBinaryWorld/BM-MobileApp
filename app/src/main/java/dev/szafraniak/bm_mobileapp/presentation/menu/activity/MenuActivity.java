package dev.szafraniak.bm_mobileapp.presentation.menu.activity;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.dashboard.DashboardFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.base.BaseActivity;

@SuppressLint("Registered")
@EActivity(R.layout.activity_menu)
public class MenuActivity extends BaseActivity implements MenuView, BottomNavigationView.OnNavigationItemSelectedListener {

    @ViewById(R.id.fl_navigator_container)
    FrameLayout navigatorContainer;

    @ViewById(R.id.bottomNavigationView)
    BottomNavigationView navigationView;

    @Inject
    MenuPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BMApplication) getApplication()).getAppComponent().inject(this);
        presenter.setView(this);
    }

    @AfterViews
    public void initialize() {
        Navigator.startMenuNavigation(this);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        presenter.onNavigationItemSelected(item.getItemId());
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Navigator.getCurrentFragment(this) instanceof DashboardFragment) {
            navigationView.getMenu().findItem(R.id.menu_dashboard).setChecked(true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int grantResult : grantResults) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        }
        Fragment fragment = Navigator.getCurrentFragment(this);
        if (fragment instanceof PermissionResultsHandler) {
            ((PermissionResultsHandler) fragment).onPermissionsGranted(requestCode);
        }
    }

}
