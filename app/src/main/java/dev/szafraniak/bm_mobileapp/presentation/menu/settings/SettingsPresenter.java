package dev.szafraniak.bm_mobileapp.presentation.menu.settings;

import android.app.Application;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.memory.settings.SettingsManager;
import dev.szafraniak.bm_mobileapp.business.memory.settings.SettingsPreferences;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import lombok.Setter;

import static dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory.FRAGMENT_BANK_ACCOUNT_LIST;
import static dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory.FRAGMENT_SETTINGS_COMPANY;
import static dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory.FRAGMENT_SETTINGS_COPYRIGHTS;

public class SettingsPresenter {

    @Setter
    SettingsView view;

    @Inject
    SettingsPreferences settingsPreferences;

    @Inject
    SettingsManager settingsManager;

    @Inject
    SessionManager sessionManager;


    public SettingsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void loadSettings() {
        boolean silentGoogle = settingsManager.getGoogleSilentLoginEnabled();
        boolean silentFacebook = settingsManager.getFacebookSilentLoginEnabled();
        view.updateUI(silentGoogle, silentFacebook);
    }

    public void negateFacebookSilentSetting() {
        settingsManager.negateFacebookSilentSetting();
        loadSettings();
    }

    public void negateGoogleSilentSetting() {
        settingsManager.negateGoogleSilentLoginEnabled();
        loadSettings();
    }

    public void logoutAction() {
        Navigator.logout(view.getContext(), sessionManager);
    }

    public void modifyCompanyDataAction() {
        Navigator.navigateTo(view, FRAGMENT_SETTINGS_COMPANY);
    }

    public void manageBankAccounts() {
        Navigator.navigateTo(view, FRAGMENT_BANK_ACCOUNT_LIST);
    }

    public void showCopyrights() {
        Navigator.navigateTo(view, FRAGMENT_SETTINGS_COPYRIGHTS);
    }
}
