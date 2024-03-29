package dev.szafraniak.bm_mobileapp.presentation.menu.settings;

import com.google.android.material.switchmaterial.SwitchMaterial;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.base.BaseHeaderFragment;
import dev.szafraniak.bm_mobileapp.presentation.company.activity.CompanyActivity_;

@EFragment(R.layout.fragment_settings)
public class SettingsFragment extends BaseHeaderFragment implements SettingsView {

    @ViewById(R.id.sw_google)
    SwitchMaterial switchGoogle;

    @ViewById(R.id.sw_facebook)
    SwitchMaterial switchFacebook;

    @Inject
    SettingsPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
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
    public void negateGoogleAutoLogin() {
        presenter.negateGoogleSilentSetting();
    }

    @Click(R.id.cl_switch_facebook)
    public void negateFacebookAutoLogin() {
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

    @Click(R.id.cl_menage_bank_accounts)
    public void manageBankAccounts() {
        presenter.manageBankAccounts();
    }

    @Click(R.id.cl_copyrights)
    public void showCopyrights() {
        presenter.showCopyrights();
    }

    @Click(R.id.cl_logout)
    public void logout() {
        presenter.logoutAction();
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_settings;
    }
}
