package dev.szafraniak.bm_mobileapp.presentation.menu.settings;

import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.BaseFragment;
import dev.szafraniak.bm_mobileapp.presentation.company.activity.CompanyActivity_;

@EFragment(R.layout.settings_fragment)
public class SettingsFragment extends BaseFragment implements SettingsView {

    @ViewById(R.id.sw_google)
    SwitchMaterial switchGoogle;

    @ViewById(R.id.sw_facebook)
    SwitchMaterial switchFacebook;

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    SettingsPresenter presenter;

    @AfterViews
    public void initialize() {
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        headerTextView.setText(R.string.header_settings);
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

    @Click(R.id.cl_change_company)
    public void changeCompany() {
        Navigator.startActivityOnEmptyStack(getContext(), CompanyActivity_.class);
    }

    @Click(R.id.cl_logout)
    public void logout() {
        presenter.logoutAction();
    }
}
