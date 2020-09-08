package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.details;

import android.os.Bundle;
import android.view.View;

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
import dev.szafraniak.bm_mobileapp.presentation.shared.details.BaseDetailsFragmentWithBtn;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.config.DetailsConfig;

@EFragment(R.layout.fragment_base_details)
public class IndividualContactDetailsFragment extends BaseDetailsFragmentWithBtn<IndividualContact>
        implements IndividualContactDetailsView {

    public final static String KEY_INDIVIDUAL_CONTACT = "INDIVIDUAL_CONTACT_KEY";

    @Inject
    IndividualContactDetailsPresenter presenter;

    IndividualContact contact;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null || !getArguments().containsKey(KEY_INDIVIDUAL_CONTACT)) {
            Navigator.back(this);
        }
        String companyJSON = getArguments().getString(KEY_INDIVIDUAL_CONTACT);
        contact = new Gson().fromJson(companyJSON, IndividualContact.class);
    }

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
        return R.string.header_contact_details;
    }

    @Override
    protected int getFblBtnTextResourceId() {
        return R.string.contact_details_fl_btn_text;
    }

    @Override
    protected void onFblClick(View view) {
        Bundle args = new Bundle();
        args.putString(IndividualContactModifyFragment.KEY_INDIVIDUAL_CONTACT, new Gson().toJson(contact));
        Navigator.navigateTo(this, FragmentFactory.FRAGMENT_INDIVIDUAL_CONTACT_MODIFY_ID, args);

    }

    @Override
    protected void loadData() {
        presenter.loadData(contact);
    }

    @Override
    protected DetailsConfig<IndividualContact> createDetailsConfig() {
        return new IndividualContactDetailsConfig(inflater, layout);
    }
}
