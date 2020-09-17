package dev.szafraniak.bm_mobileapp.presentation.menu.dashboard;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.presentation.BaseHeaderFragment;

@EFragment(R.layout.fragment_dashboard)
public class DashboardFragment extends BaseHeaderFragment implements DashboardView {

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    DashboardPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
    }


    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_dashboard;
    }
}
