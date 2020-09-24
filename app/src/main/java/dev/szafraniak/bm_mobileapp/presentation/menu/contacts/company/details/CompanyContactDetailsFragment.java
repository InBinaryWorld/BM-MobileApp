package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify.CompanyContactModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment.BaseDetailsFragmentWithBtn;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.DetailsInterface;

@EFragment(R.layout.fragment_base_details)
public class CompanyContactDetailsFragment extends BaseDetailsFragmentWithBtn<CompanyContact>
        implements CompanyContactDetailsView {

    public final static String KEY_COMPANY_CONTACT = "COMPANY_CONTACT_KEY";

    @Inject
    CompanyContactDetailsPresenter presenter;

    @Inject
    Gson gson;

    private CompanyContact contact;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchArgumentsData();
    }

    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_COMPANY_CONTACT)) {
            Navigator.back(this);
            return;
        }
        String companyJSON = args.getString(KEY_COMPANY_CONTACT);
        contact = gson.fromJson(companyJSON, CompanyContact.class);
    }

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected void loadData() {
        presenter.loadData(contact.getId());
    }

    @Override
    protected DetailsInterface<CompanyContact> createForm(LayoutInflater inflater, LinearLayout detailsLayout) {
        CompanyContactDetailsConfig config = presenter.createConfig();
        return new CompanyContactDetails(inflater, detailsLayout, config);
    }

    @Override
    protected void onFblClick(View view) {
        Bundle args = new Bundle();
        args.putString(CompanyContactModifyFragment.KEY_COMPANY_CONTACT, gson.toJson(contact));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_COMPANY_CONTACT_MODIFY, args);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_contact_details;
    }

    @Override
    protected int getFlBtnTextResourceId() {
        return R.string.contact_details_fl_btn_text;
    }

}
