package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.individual.create;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.CreateIndividualContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;

@EFragment(R.layout.fragment_base_form)
public class IndividualContactCreateFragment extends BaseFormFragment<CreateIndividualContactRequest> implements IndividualContactCreateView {

    @Inject
    IndividualContactCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        super.initialize();
    }

    @Override
    protected CreateIndividualContactRequest getFormModel() {
        CreateIndividualContactRequest model = new CreateIndividualContactRequest();
        model.setAddress(new Address());
        return model;
    }

    @Override
    protected void onSubmit(CreateIndividualContactRequest object) {
        presenter.createCompany(object);
    }

    @Override
    protected FormConfig<CreateIndividualContactRequest> createFormConfig() {
        return new IndividualContactCreateFormConfig(inflater, formLayout);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_create_contact;
    }
}
