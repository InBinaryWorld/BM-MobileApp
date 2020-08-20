package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.ContactListAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragment;

@EFragment(R.layout.fragment_contact_list)
public class CompanyContactListFragment extends BaseListFragment<CompanyContact>
        implements CompanyContactListView {


    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    CompanyContactListPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        headerTextView.setText(R.string.header_individual_contact_list);
        presenter.setView(this);
        firstLoadData();
    }

    @Override
    protected void loadData() {
        presenter.loadListData();
    }

    @Override
    protected BaseAdapter<CompanyContact> createAdapter() {
        return new ContactListAdapter<>(getContext());
    }

    @Override
    public void onItemClick(CompanyContact item) {
    }

    @Click(R.id.flb_create)
    public void createContactAction() {
        Navigator.backOneAndNavigateTo(this, FragmentFactory.FRAGMENT_COMPANY_CONTACTS_CREATE_ID);
    }
}
