package dev.szafraniak.bm_mobileapp.presentation.menu.company;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.Address;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.UpdateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class ModifyCompanyFragment extends BaseFormFragment<UpdateCompanyRequest> implements ModifyCompanyView {

    @Inject
    ModifyCompanyPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        super.initialize();
    }

    @Override
    protected FormConfig<UpdateCompanyRequest> createFormConfig() {
        Company activeCompany = presenter.getActiveCompany();
        return new ModifyCompanyFormConfig(inflater, formLayout, activeCompany);
    }

    @Override
    protected void onSubmit(UpdateCompanyRequest request) {
        presenter.modifyCompanyData(request);
    }

    @Override
    protected UpdateCompanyRequest getFormModel() {
        UpdateCompanyRequest model = new UpdateCompanyRequest();
        model.setHeadquarter(new Address());
        return model;
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_modify_company;
    }
}
