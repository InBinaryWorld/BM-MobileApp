package dev.szafraniak.bm_mobileapp.presentation.menu.company;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.presentation.BaseFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.FinancesView;

@EFragment(R.layout.modify_company_fragment)
public class ModifyCompanyFragment extends BaseFragment implements FinancesView {

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    ModifyCompanyPresenter presenter;

    @AfterViews
    public void initialize() {
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        headerTextView.setText("Modify Company Data");
    }

}
