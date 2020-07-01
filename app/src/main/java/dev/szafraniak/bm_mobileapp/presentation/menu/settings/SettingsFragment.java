package dev.szafraniak.bm_mobileapp.presentation.menu.settings;

import android.widget.Switch;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.presentation.BaseFragment;

@EFragment(R.layout.settings_fragment)
public class SettingsFragment extends BaseFragment implements SettingsView {

    @ViewById(R.id.sw_google)
    Switch switchGoogle;

    @ViewById(R.id.sw_facebook)
    Switch switchFacebook;

    @Inject
    SettingsPresenter presenter;

    @AfterViews
    public void initialize() {
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        presenter.loadSettings();
    }

    public void updateUI(boolean silentGoogle, boolean silentFacebook) {
        switchGoogle.setChecked(silentGoogle);
        switchFacebook.setChecked(silentFacebook);
    }

    @Click(R.id.cl_switch_google)
    public void enableGoogleAutoLogin() {
        presenter.negateGoogleSilentSetting();
    }

    @Click(R.id.cl_switch_facebook)
    public void enableFacebookAutoLogin() {
        presenter.negateFacebookSilentSetting();
    }

    @Click(R.id.cl_modify_company_data)
    public void modifyCompanyData() {
        presenter.modifyCompanyDataAction();
    }

    @Click(R.id.cl_logout)
    public void logout() {
        presenter.logoutAction();
    }
}
