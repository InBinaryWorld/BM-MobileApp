package dev.szafraniak.bm_mobileapp.presentation.company.list;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.BaseAdapter;
import dev.szafraniak.bm_mobileapp.presentation.BaseListFragment;

@EFragment(R.layout.company_list_fragment)
public class CompanyListFragment extends BaseListFragment<Company> implements CompanyListView {


    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    CompanyListPresenter presenter;

    @AfterViews
    public void initialize() {
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        headerTextView.setText("Choose Company");
        presenter.setView(this);
        loadData();
    }

    @Override
    protected void loadData() {
        presenter.loadListData();
    }

    @Override
    protected BaseAdapter<Company> createAdapter() {
        return new CompanyListAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item);
    }

    @Override
    public void onItemClick(Company item) {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_COMPANY_CREATE_ID);
    }
}
