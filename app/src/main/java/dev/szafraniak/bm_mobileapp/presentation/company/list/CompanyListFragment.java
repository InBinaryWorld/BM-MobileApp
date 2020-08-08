package dev.szafraniak.bm_mobileapp.presentation.company.list;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.memory.UserPreferences;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.BaseAdapter;
import dev.szafraniak.bm_mobileapp.presentation.BaseListFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.activity.MenuActivity_;

@EFragment(R.layout.company_list_fragment)
public class CompanyListFragment extends BaseListFragment<CompanyListModel> implements CompanyListView {


    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    CompanyListPresenter presenter;

    @Inject
    UserPreferences userPreferences;

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
    protected BaseAdapter<CompanyListModel> createAdapter() {
        return new CompanyListAdapter(getContext(), R.layout.list_item_company_card);
    }

    @Override
    public void onItemClick(CompanyListModel item) {
        userPreferences.setCompany(item.getCompany());
        Navigator.startActivity(getContext(), MenuActivity_.class);
    }

    @Click(R.id.flb_create_company)
    public void createCompanyAction() {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_COMPANY_CREATE_ID);
    }
}
