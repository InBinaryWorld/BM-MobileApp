package dev.szafraniak.bm_mobileapp.presentation.company.list;

import android.view.LayoutInflater;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionPreferences;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.activity.MenuActivity_;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragmentWithBtn;

@EFragment(R.layout.fragment_base_list_with_btn)
public class CompanyListFragment extends BaseListFragmentWithBtn<CompanyListModel, CompanyListAdapter> implements CompanyListView {

    @Inject
    CompanyListPresenter presenter;

    @Inject
    SessionPreferences sessionPreferences;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_company_list;
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    protected CompanyListAdapter createAdapter() {
        return new CompanyListAdapter(LayoutInflater.from(getContext()), new ArrayList<>());
    }

    @Override
    public void onItemClick(CompanyListModel item) {
        sessionPreferences.setCompany(item.getCompany());
        Navigator.startActivity(getContext(), MenuActivity_.class);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_text_company_list;
    }

    @Override
    protected void onButtonClick(View view) {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_COMPANY_CREATE);
    }
    
}
