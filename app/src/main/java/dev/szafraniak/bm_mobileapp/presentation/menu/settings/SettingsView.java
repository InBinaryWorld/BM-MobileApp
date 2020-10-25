package dev.szafraniak.bm_mobileapp.presentation.menu.settings;

import dev.szafraniak.bm_mobileapp.presentation.shared.base.BaseView;

public interface SettingsView extends BaseView {

    void updateUI(boolean silentGoogle, boolean silentFacebook);

}
