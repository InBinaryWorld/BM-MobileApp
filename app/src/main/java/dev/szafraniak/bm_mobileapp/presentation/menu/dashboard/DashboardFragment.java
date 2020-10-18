package dev.szafraniak.bm_mobileapp.presentation.menu.dashboard;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.presentation.BaseHeaderFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.scanner.ScannerDialog;

@EFragment(R.layout.fragment_dashboard)
public class DashboardFragment extends BaseHeaderFragment implements DashboardView {

    @Inject
    DashboardPresenter presenter;
    private ScannerDialog scannerDialog;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        scannerDialog = new ScannerDialog(getActivity());
        presenter.setView(this);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Click(R.id.button)
    public void setButtonClick() {
        scannerDialog.openScanner();
    }


    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_dashboard;
    }
}
