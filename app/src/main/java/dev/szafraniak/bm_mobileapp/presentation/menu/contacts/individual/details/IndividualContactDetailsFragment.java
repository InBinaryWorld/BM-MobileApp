package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details;

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
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify.IndividualContactModifyFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment.BaseDetailsFragmentWithBtn;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.DetailsInterface;

@EFragment(R.layout.fragment_base_details)
public class IndividualContactDetailsFragment extends BaseDetailsFragmentWithBtn<IndividualContact>
        implements IndividualContactDetailsView {

    public final static String KEY_INDIVIDUAL_CONTACT = "INDIVIDUAL_CONTACT_KEY";

    @Inject
    IndividualContactDetailsPresenter presenter;

    @Inject
    Gson gson;

    IndividualContact contact;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchArgumentsData();
    }

    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_INDIVIDUAL_CONTACT)) {
            Navigator.back(this);
            return;
        }
        String companyJSON = getArguments().getString(KEY_INDIVIDUAL_CONTACT);
        contact = gson.fromJson(companyJSON, IndividualContact.class);
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
    protected DetailsInterface<IndividualContact> createForm(LayoutInflater inflater, LinearLayout linearLayout) {
        IndividualContactDetailsConfig config = presenter.createConfig();
        return new IndividualContactDetails(inflater, detailsLayout, config);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_contact_details;
    }

    @Override
    protected int getFlBtnTextResourceId() {
        return R.string.contact_details_fl_btn_text;
    }

    @Override
    protected void onFblClick(View view) {
        Bundle args = new Bundle();
        args.putString(IndividualContactModifyFragment.KEY_INDIVIDUAL_CONTACT, gson.toJson(contact));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_INDIVIDUAL_CONTACT_MODIFY, args);
    }

}
