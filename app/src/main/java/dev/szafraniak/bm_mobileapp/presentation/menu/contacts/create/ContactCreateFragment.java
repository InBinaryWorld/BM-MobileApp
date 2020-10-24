package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.create;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.CreateContactRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class ContactCreateFragment extends BaseFormFragment<CreateContactRequest, ContactCreateFormConfig> implements ContactCreateView {

    @Inject
    ContactCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_create_form;
    }


    @Override
    protected FormInterface<CreateContactRequest> createForm(LayoutInflater inflater, ViewGroup linearLayout, ContactCreateFormConfig config) {
        return new ContactCreateForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(CreateContactRequest object) {
        if (object instanceof CreateCompanyContactRequest) {
            presenter.createCompany((CreateCompanyContactRequest) object);
        } else {
            presenter.createIndividual((CreateIndividualContactRequest) object);
        }
    }

    @Override
    protected void loadData() {
        // Nothing to load, just show form
        ContactCreateFormConfig config = presenter.createConfig();
        startForm(config);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_contact_create;
    }
}
