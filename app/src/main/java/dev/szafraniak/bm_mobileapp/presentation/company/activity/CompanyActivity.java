package dev.szafraniak.bm_mobileapp.presentation.company.activity;

import android.annotation.SuppressLint;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.BaseActivity;

@SuppressLint("Registered")
@EActivity(R.layout.activity_company)
public class CompanyActivity extends BaseActivity {

    @Inject
    CompanyActivityPresenter presenter;

    @AfterViews
    public void initialize() {
        ((BMApplication) getApplication()).getAppComponent().inject(this);
        presenter.setView(this);
        presenter.initializePresenter(this);
        Navigator.startCompanyNavigation(this);
    }

}
