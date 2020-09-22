package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;

@EFragment(R.layout.fragment_base_form)
public class CompanyContactCreateFragment extends BaseFormFragment<CreateCompanyContactRequest> implements CompanyContactCreateView {

    @Inject
    CompanyContactCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        super.initialize();
    }

    @Override
    protected CreateCompanyContactRequest getFormModel() {
        CreateCompanyContactRequest model = new CreateCompanyContactRequest();
        model.setAddress(new Address());
        return model;
    }

    @Override
    protected void onSubmit(CreateCompanyContactRequest object) {
        presenter.createCompany(object);
    }

    @Override
    protected FormConfig<CreateCompanyContactRequest> createFormConfig() {
        return new CompanyContactCreateFormConfig(inflater, formLayout);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_create_contact;
    }
}
