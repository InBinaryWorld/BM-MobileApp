package dev.szafraniak.bm_mobileapp.presentation.menu.company;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.presentation.BaseFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.finances.FinancesView;

@EFragment(R.layout.company_fragment)
public class CompanyFragment extends BaseFragment implements FinancesView {

    @Inject
    CompanyPresenter presenter;

    @AfterViews
    public void initialize() {
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
    }

}
