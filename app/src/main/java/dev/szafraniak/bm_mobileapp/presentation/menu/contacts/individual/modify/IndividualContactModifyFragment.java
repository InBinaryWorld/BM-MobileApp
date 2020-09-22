package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.UpdateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;

@EFragment(R.layout.fragment_base_form)
public class IndividualContactModifyFragment extends BaseFormFragment<UpdateIndividualContactRequest> implements IndividualContactModifyView {

    public final static String KEY_INDIVIDUAL_CONTACT = "INDIVIDUAL_CONTACT_KEY";

    @Inject
    IndividualContactModifyPresenter presenter;

    @Inject
    Gson gson;

    IndividualContact contact;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null || !getArguments().containsKey(KEY_INDIVIDUAL_CONTACT)) {
            Navigator.back(this);
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
        super.initialize();
    }

    @Override
    protected UpdateIndividualContactRequest getFormModel() {
        UpdateIndividualContactRequest model = new UpdateIndividualContactRequest();
        model.setAddress(new Address());
        return model;
    }

    @Override
    protected void onSubmit(UpdateIndividualContactRequest object) {
        presenter.updateCompany(object, contact.getId());
    }

    @Override
    protected FormConfig<UpdateIndividualContactRequest> createFormConfig() {
        return new IndividualContactModifyFormConfig(inflater, formLayout, contact);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_individual_contact_modify;
    }
}
