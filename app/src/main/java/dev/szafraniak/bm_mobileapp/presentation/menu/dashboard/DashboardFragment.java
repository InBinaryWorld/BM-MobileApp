package dev.szafraniak.bm_mobileapp.presentation.menu.dashboard;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.auth.AuthorizationService;
import dev.szafraniak.bm_mobileapp.business.memory.SessionManager;
import dev.szafraniak.bm_mobileapp.presentation.BaseFragment;

@EFragment(R.layout.dashboard_fragment)
public class DashboardFragment extends BaseFragment implements DashboardView {

    @Inject
    AuthorizationService service;

    @Inject
    SessionManager session;

    @Inject
    DashboardPresenter presenter;

    @ViewById(R.id.tv_response)
    TextView messageTextView;

    @AfterViews
    public void initialize() {
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
    }

    @Click(R.id.btn_logout)
    public void logoutBtnOnClick() {
    }

    @Click(R.id.not_secured)
    public void notSecured() {
        presenter.notSecured();
    }

    @Click(R.id.secured)
    public void secured() {
        presenter.secured();
    }

    public void setData(String data) {
        messageTextView.setText(data);
    }

}
