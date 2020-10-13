package dev.szafraniak.bm_mobileapp.presentation.menu.dashboard;

import android.view.SurfaceView;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.presentation.BaseHeaderFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.activity.PermissionResultsHandler;
import dev.szafraniak.bm_mobileapp.presentation.shared.scanner.Scanner;

@EFragment(R.layout.fragment_dashboard)
public class DashboardFragment extends BaseHeaderFragment implements DashboardView, PermissionResultsHandler {

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @ViewById(R.id.button)
    Button button;

    @ViewById(R.id.sv_cameraSurface)
    SurfaceView surfaceView;

    @Inject
    DashboardPresenter presenter;

    private Scanner scanner;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        scanner = new Scanner(getActivity(), surfaceView);
        scanner.addBarcodeListener(barcode -> System.out.println("!!!!!!!!! " + barcode.displayValue));
    }


    @Override
    public void onPermissionsGranted(int code) {
        if (scanner != null) {
            scanner.onPermissionGranted(code);
        }
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
        scanner.startScanning();
    }


    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_dashboard;
    }
}
