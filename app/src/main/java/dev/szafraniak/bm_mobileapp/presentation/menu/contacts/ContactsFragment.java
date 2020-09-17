package dev.szafraniak.bm_mobileapp.presentation.menu.contacts;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.BaseHeaderFragment;

@EFragment(R.layout.fragment_contacts)
public class ContactsFragment extends BaseHeaderFragment implements ContactsView {


    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @Inject
    ContactsPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
    }

    @Click(R.id.btn_individual)
    public void onIndividualClick() {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_INDIVIDUAL_CONTACT_LIST);
    }

    @Click(R.id.btn_company)
    public void onCompanyClick() {
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_COMPANY_CONTACT_LIST);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_contacts;
    }
}
