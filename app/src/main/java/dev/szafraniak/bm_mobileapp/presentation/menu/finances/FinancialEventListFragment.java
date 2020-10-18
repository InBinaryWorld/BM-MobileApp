package dev.szafraniak.bm_mobileapp.presentation.menu.finances;

import android.view.LayoutInflater;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.FinancialRow;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragmentWithBtn;

@EFragment(R.layout.fragment_base_list_with_btn)
public class FinancialEventListFragment extends BaseListFragmentWithBtn<FinancialRow, FinancialEventListAdapter> implements FinancialEventListView {

    @Inject
    FinancialEventListPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_financial_event_list;
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    protected FinancialEventListAdapter createAdapter() {
        return new FinancialEventListAdapter(LayoutInflater.from(getContext()), new ArrayList<>());
    }

    @Override
    public void onItemClick(FinancialRow item) {
        presenter.modifyModel(item);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_financial_event_list;
    }

    @Override
    protected void onButtonClick(View view) {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_FINANCES_CREATE);
    }
}
