package dev.szafraniak.bm_mobileapp.presentation.company;

import android.annotation.SuppressLint;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.presentation.BaseActivity;

@SuppressLint("Registered")
@EActivity(R.layout.company_activity)
public class CompanyActivity extends BaseActivity {

    @Inject
    CompanyActivityPresenter presenter;

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @AfterViews
    public void initialize() {
        ((BMApplication) getApplication()).getAppComponent().inject(this);
        presenter.initializePresenter(this);
        headerTextView.setText(R.string.header_companies);
    }

    private void showProgressBar() {
    }

    private void showError() {
    }

    private void showData() {
    }

}
