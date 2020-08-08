package dev.szafraniak.bm_mobileapp.presentation.menu.dashboard;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.presentation.BaseFragment;

@EFragment(R.layout.dashboard_fragment)
public class DashboardFragment extends BaseFragment implements DashboardView {

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    DashboardPresenter presenter;

    @AfterViews
    public void initialize() {
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        headerTextView.setText("Dashboard");
    }


}
