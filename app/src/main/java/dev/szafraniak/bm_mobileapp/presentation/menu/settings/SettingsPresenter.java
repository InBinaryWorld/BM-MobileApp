package dev.szafraniak.bm_mobileapp.presentation.menu.settings;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.memory.SessionManager;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import lombok.Setter;

import static dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory.FRAGMENT_SETTINGS_COMPANY_ID;

public class SettingsPresenter {

    @Setter
    SettingsView view;

    @Inject
    UserPreferences userPreferences;

    @Inject
    SessionManager sessionManager;


    public SettingsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    private void saveSettingsAndUpdateUI(boolean silentGoogle, boolean silentFacebook) {
        userPreferences.setFacebookSilentLoginEnabled(silentFacebook);
        userPreferences.setGoogleSilentLoginEnabled(silentGoogle);
        view.updateUI(silentGoogle, silentFacebook);
    }

    public void loadSettings() {
        boolean silentGoogle = userPreferences.getGoogleSilentLoginEnabled();
        boolean silentFacebook = userPreferences.getFacebookSilentLoginEnabled();
        view.updateUI(silentGoogle, silentFacebook);
    }

    public void negateFacebookSilentSetting() {
        boolean silentFacebook = userPreferences.getFacebookSilentLoginEnabled();
        saveSettingsAndUpdateUI(false, !silentFacebook);
    }

    public void negateGoogleSilentSetting() {
        boolean silentGoogle = userPreferences.getGoogleSilentLoginEnabled();
        saveSettingsAndUpdateUI(!silentGoogle, false);
    }

    public void logoutAction() {
        Navigator.logout(view.getContext(), sessionManager);
    }

    public void modifyCompanyDataAction() {
        Navigator.navigateTo(view, FRAGMENT_SETTINGS_COMPANY_ID);
    }
}
