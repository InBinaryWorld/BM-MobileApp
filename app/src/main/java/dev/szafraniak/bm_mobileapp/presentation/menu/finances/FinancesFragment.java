package dev.szafraniak.bm_mobileapp.presentation.menu.finances;

import android.view.View;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.FinancialRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragmentWithBtn;

@EFragment(R.layout.fragment_base_list_with_btn)
public class FinancesFragment extends BaseListFragmentWithBtn<FinancialRow> implements FinancesView {

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    FinancesPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        firstLoadData();
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
    protected BaseAdapter<FinancialRow> createAdapter() {
        return new FinancesListAdapter(getContext());
    }

    @Override
    public void onItemClick(FinancialRow item) {
//        Bundle args = new Bundle();
//        args.putString(IndividualContactDetailsFragment.KEY_INDIVIDUAL_CONTACT, new Gson().toJson(item));
//        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_INDIVIDUAL_CONTACT_DETAILS, args);
    }

    @Override
    protected int getFlButtonTextId() {
        return R.string.finances_list_fl_btn_text;
    }

    @Override
    protected void onFlButtonClick(View view) {

    }
}
