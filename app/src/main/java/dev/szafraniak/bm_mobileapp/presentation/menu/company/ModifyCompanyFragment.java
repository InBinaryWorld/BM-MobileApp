package dev.szafraniak.bm_mobileapp.presentation.menu.company;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.UpdateAddressRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.UpdateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;

@EFragment(R.layout.fragment_base_form)
public class ModifyCompanyFragment extends BaseFormFragment<UpdateCompanyRequest> implements ModifyCompanyView {

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

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
        return new ModifyCompanyFormConfig(inflater, layout, activeCompany);
    }

    @Override
    protected void onSubmit(UpdateCompanyRequest request) {
        presenter.modifyCompanyData(request);
    }

    @Override
    protected UpdateCompanyRequest getFormModel() {
        UpdateCompanyRequest model = new UpdateCompanyRequest();
        model.setHeadquarter(new UpdateAddressRequest());
        return model;
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_modify_company;
    }
}
