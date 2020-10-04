package dev.szafraniak.bm_mobileapp.presentation.menu.finances;

import android.view.LayoutInflater;
import android.view.View;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.FinancialRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragmentWithBtn;

@EFragment(R.layout.fragment_base_list_with_btn)
public class FinancesFragment extends BaseListFragmentWithBtn<FinancialRow, FinancesListAdapter> implements FinancesView {

    @Inject
    FinancesPresenter presenter;

    @Inject
    Gson gson;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_finances;
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    protected FinancesListAdapter createAdapter() {
        return new FinancesListAdapter(LayoutInflater.from(getContext()), new ArrayList<>());
    }

    @Override
    public void onItemClick(FinancialRow item) {
//        Bundle args = new Bundle();
//        args.putString(IndividualContactDetailsFragment.KEY_INDIVIDUAL_CONTACT, gson.toJson(item));
//        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_INDIVIDUAL_CONTACT_DETAILS, args);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_text_finances_list;
    }

    @Override
    protected void onButtonClick(View view) {

    }
}
