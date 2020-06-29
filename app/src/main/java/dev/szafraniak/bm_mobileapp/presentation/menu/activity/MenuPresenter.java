package dev.szafraniak.bm_mobileapp.presentation.menu.activity;

import android.app.Application;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import lombok.Setter;

public class MenuPresenter {

    @Setter
    MenuView view;

    public MenuPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void onNavigationItemSelected(int menuId) {
        int fragmentId = FragmentFactory.parseMenuIdToFragmentId(menuId);
        Navigator.navigateTo(fragmentId, view, true, true);
    }

}
