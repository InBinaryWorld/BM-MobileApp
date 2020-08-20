package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.ContactListAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragment;

@EFragment(R.layout.fragment_contact_list)
public class IndividualContactListFragment extends BaseListFragment<IndividualContact>
        implements IndividualContactListView {


    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    IndividualContactListPresenter presenter;

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
    protected BaseAdapter<IndividualContact> createAdapter() {
        return new ContactListAdapter<>(getContext());
    }

    @Override
    public void onItemClick(IndividualContact item) {
    }

    @Click(R.id.flb_create)
    public void createContactAction() {
        Navigator.backOneAndNavigateTo(this, FragmentFactory.FRAGMENT_INDIVIDUAL_CONTACTS_CREATE_ID);
    }
}
