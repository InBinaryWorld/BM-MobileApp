package dev.szafraniak.bm_mobileapp.presentation.menu.bank;

import android.view.LayoutInflater;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.bankAccount.BankAccount;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragmentWithBtn;

@EFragment(R.layout.fragment_base_list_with_btn)
public class BankAccountListFragment extends BaseListFragmentWithBtn<BankAccount, BankAccountListAdapter>
    implements BankAccountListView {

    @Inject
    BankAccountListPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_bank_accounts_list;
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    protected BankAccountListAdapter createAdapter() {
        return new BankAccountListAdapter(LayoutInflater.from(getContext()), new ArrayList<>());
    }

    @Override
    public void onItemClick(BankAccount item) {
        presenter.modifyModel(item);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_bank_account_list;
    }

    @Override
    protected void onButtonClick(View view) {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_BANK_ACCOUNT_CREATE);
    }
}
