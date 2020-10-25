package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.modify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.UpdateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class IndividualContactModifyFragment extends BaseFormFragment<UpdateIndividualContactRequest, IndividualContactModifyFormConfig> implements IndividualContactModifyView {

    public final static String KEY_INDIVIDUAL_CONTACT = "INDIVIDUAL_CONTACT_KEY";

    @Inject
    IndividualContactModifyPresenter presenter;

    @Inject
    Gson gson;

    IndividualContact contact;


    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_INDIVIDUAL_CONTACT)) {
            Navigator.back(this);
            return;
        }
        String companyJSON = args.getString(KEY_INDIVIDUAL_CONTACT);
        contact = gson.fromJson(companyJSON, IndividualContact.class);
    }

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        fetchArgumentsData();
        presenter.setView(this);
    }

    @Override
    protected void loadData() {
        presenter.loadData(contact.getId());
    }

    @Override
    protected int getButtonTextId() {
        return R.string.header_contact_modify;
    }

    @Override
    protected FormInterface<UpdateIndividualContactRequest> createForm(LayoutInflater inflater, ViewGroup linearLayout, IndividualContactModifyFormConfig config) {
        return new IndividualContactModifyForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(UpdateIndividualContactRequest object) {
        presenter.updateCompany(object, contact.getId());
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_contact_modify;
    }

    @Override
    public void setModifyModel(IndividualContact individualContact) {

        UpdateIndividualContactRequest model = new UpdateIndividualContactRequest();
        model.setFirstName(contact.getFirstName());
        model.setLastName(contact.getLastName());
        model.setPhone(contact.getPhone());
        model.setAddress(contact.getAddress());

        IndividualContactModifyFormConfig config = presenter.createConfig();
        startForm(config, model);
    }
}
