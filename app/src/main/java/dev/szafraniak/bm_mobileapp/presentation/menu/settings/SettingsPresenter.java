package dev.szafraniak.bm_mobileapp.presentation.menu.settings;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.memory.settings.SettingsPreferences;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import lombok.Setter;

import static dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory.FRAGMENT_SETTINGS_COMPANY;

public class SettingsPresenter {

    @Setter
    SettingsView view;

    @Inject
    SettingsPreferences settingsPreferences;

    @Inject
    SessionManager sessionManager;


    public SettingsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    private void saveSettingsAndUpdateUI(boolean silentGoogle, boolean silentFacebook) {
        settingsPreferences.setFacebookSilentLoginEnabled(silentFacebook);
        settingsPreferences.setGoogleSilentLoginEnabled(silentGoogle);
        view.updateUI(silentGoogle, silentFacebook);
    }

    public void loadSettings() {
        boolean silentGoogle = settingsPreferences.getGoogleSilentLoginEnabled();
        boolean silentFacebook = settingsPreferences.getFacebookSilentLoginEnabled();
        view.updateUI(silentGoogle, silentFacebook);
    }

    public void negateFacebookSilentSetting() {
        boolean silentFacebook = settingsPreferences.getFacebookSilentLoginEnabled();
        saveSettingsAndUpdateUI(false, !silentFacebook);
    }

    public void negateGoogleSilentSetting() {
        boolean silentGoogle = settingsPreferences.getGoogleSilentLoginEnabled();
        saveSettingsAndUpdateUI(!silentGoogle, false);
    }

    public void logoutAction() {
        Navigator.logout(view.getContext(), sessionManager);
    }

    public void modifyCompanyDataAction() {
        Navigator.navigateTo(view, FRAGMENT_SETTINGS_COMPANY);
    }
}
