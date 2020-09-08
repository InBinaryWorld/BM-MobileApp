package dev.szafraniak.bm_mobileapp.presentation.shared.result;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.button.MaterialButton;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.BaseFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.dashboard.DashboardPresenter;

@EFragment(R.layout.fragment_action_status)
public class ActionStatusFragment extends BaseFragment {
    public final static String BUTTON_TEXT_KEY = "BUTTON_TEXT_KEY";
    public final static String STATE_KEY = "STATE_KEY";
    public final static String STATE_FAILED = "STATE_FAILED";
    public final static String STATE_SUCCEEDED = "STATE_SUCCEEDED";

    @ViewById(R.id.cl_success_container)
    ConstraintLayout successContainer;

    @ViewById(R.id.cl_failed_container)
    ConstraintLayout failedContainer;

    @ViewById(R.id.btn_action_status)
    MaterialButton button;

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    DashboardPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        headerTextView.setText(R.string.header_action_status);
        Bundle bundle = getArguments();
        if (bundle != null) {
            updateUI(bundle);
        }
    }

    @Click(R.id.btn_action_status)
    public void buttonAction() {
        Navigator.backToStart(this);
//        Navigator.back(this);
    }

    public void updateUI(Bundle bundle) {
        String buttonText = bundle.getString(BUTTON_TEXT_KEY, "Go Back");
        String state = bundle.getString(STATE_KEY, "");
        button.setText(buttonText);
        switch (state) {
            case STATE_SUCCEEDED:
                failedContainer.setVisibility(View.GONE);
                successContainer.setVisibility(View.VISIBLE);
                break;
            case STATE_FAILED:
                successContainer.setVisibility(View.GONE);
                failedContainer.setVisibility(View.VISIBLE);
                break;
        }
    }

}
