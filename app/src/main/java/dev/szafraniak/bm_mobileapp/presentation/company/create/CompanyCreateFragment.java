package dev.szafraniak.bm_mobileapp.presentation.company.create;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.CreateAddressRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;

@EFragment(R.layout.fragment_base_form)
public class CompanyCreateFragment extends BaseFormFragment<CreateCompanyRequest> implements CompanyCreateView {

    @Inject
    CompanyCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        super.initialize();
    }

    @Override
    protected CreateCompanyRequest getFormModel() {
        CreateCompanyRequest model = new CreateCompanyRequest();
        model.setHeadquarter(new CreateAddressRequest());
        return model;
    }

    @Override
    protected void onSubmit(CreateCompanyRequest object) {
        presenter.createCompany(object);
    }

    @Override
    protected FormConfig<CreateCompanyRequest> createFormConfig() {
        return new CompanyCreateFormConfig(inflater, layout);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.create_company_header;
    }
}
