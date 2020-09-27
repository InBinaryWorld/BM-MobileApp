package dev.szafraniak.bm_mobileapp.presentation.company.create;

import android.view.LayoutInflater;
import android.widget.LinearLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class CompanyCreateFragment extends BaseFormFragment<CreateCompanyRequest, CreateCompanyFormConfig> implements CompanyCreateView {

    @Inject
    CompanyCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected FormInterface<CreateCompanyRequest> createForm(LayoutInflater inflater, LinearLayout linearLayout, CreateCompanyFormConfig config) {
        return new CreateCompanyForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(CreateCompanyRequest object) {
        presenter.createCompany(object);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.create_company_header;
    }

    @Override
    protected void loadData() {
        CreateCompanyFormConfig config = presenter.createConfig();
        startForm(config);
    }
}
