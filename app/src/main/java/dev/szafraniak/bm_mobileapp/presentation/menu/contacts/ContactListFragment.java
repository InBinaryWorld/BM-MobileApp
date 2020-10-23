package dev.szafraniak.bm_mobileapp.presentation.menu.contacts;

import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details.CompanyContactDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details.IndividualContactDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.SearchListFragmentWithBtn;

@EFragment(R.layout.fragment_search_list_with_btn)
public class ContactListFragment extends SearchListFragmentWithBtn<Contact, ContactListAdapter<Contact>>
    implements ContactListView {

    @Inject
    ContactListPresenter presenter;

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
        return R.string.header_contacts;
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    protected ContactListAdapter<Contact> createAdapter() {
        return new ContactListAdapter<>(getContext(), new ArrayList<>());
    }

    @Override
    public void onItemClick(Contact item) {
        Bundle args = new Bundle();
        if (item instanceof IndividualContact) {
            args.putString(IndividualContactDetailsFragment.KEY_INDIVIDUAL_CONTACT, gson.toJson(item));
            Navigator.navigateTo(this, FragmentFactory.FRAGMENT_INDIVIDUAL_CONTACT_DETAILS, args);
        } else {
            args.putString(CompanyContactDetailsFragment.KEY_COMPANY_CONTACT, gson.toJson(item));
            Navigator.navigateTo(this, FragmentFactory.FRAGMENT_COMPANY_CONTACT_DETAILS, args);
        }
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_text_contact_list;
    }

    @Override
    protected void onButtonClick(View view) {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_CONTACT_CREATE);
    }
}
