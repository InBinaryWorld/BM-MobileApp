package dev.szafraniak.bm_mobileapp.presentation.company.create;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.presentation.BaseFragment;

@EFragment(R.layout.company_create_fragment)
public class CompanyCreateFragment extends BaseFragment implements CompanyCreateView {

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    CompanyCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        headerTextView.setText("Create Company");
    }
}
