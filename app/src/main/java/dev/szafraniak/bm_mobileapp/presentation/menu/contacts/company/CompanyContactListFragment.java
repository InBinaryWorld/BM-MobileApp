package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company;

import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.ContactListAdapter;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details.CompanyContactDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.SearchListFragmentWithBtn;

@EFragment(R.layout.fragment_search_list_with_btn)
public class CompanyContactListFragment extends SearchListFragmentWithBtn<CompanyContact>
        implements CompanyContactListView {

    @Inject
    CompanyContactListPresenter presenter;

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
        return R.string.header_company_contacts_list;
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
        Bundle args = new Bundle();
        args.putString(CompanyContactDetailsFragment.KEY_COMPANY_CONTACT, new Gson().toJson(item));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_COMPANY_CONTACT_DETAILS, args);
    }

    @Override
    protected int getFlButtonTextId() {
        return R.string.contact_list_fl_btn_create;
    }

    @Override
    protected void onFlButtonClick(View view) {
        Navigator.backOneAndNavigateTo(this, FragmentFactory.FRAGMENT_COMPANY_CONTACT_CREATE);
    }
}
