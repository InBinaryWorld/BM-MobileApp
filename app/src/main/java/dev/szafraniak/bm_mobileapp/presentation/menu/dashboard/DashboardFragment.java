package dev.szafraniak.bm_mobileapp.presentation.menu.dashboard;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.presentation.shared.load.BaseSRLLoadFragment;

@EFragment(R.layout.fragment_dashboard)
public class DashboardFragment extends BaseSRLLoadFragment implements DashboardView {

    @Inject
    DashboardPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_dashboard;
    }

    @Override
    protected void loadData() {
        
    }
}
