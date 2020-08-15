package dev.szafraniak.bm_mobileapp.presentation.company.create;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.CreateAddressRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.CreateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfig;

@EFragment(R.layout.fragment_company_create)
public class CompanyCreateFragment extends BaseFormFragment<CreateCompanyRequest> implements CompanyCreateView {

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;

    @ViewById(R.id.ll_form)
    LinearLayout formLayout;

    @ViewById(R.id.progress_bar)
    View progressBar;

    @Inject
    CompanyCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        headerTextView.setText(R.string.create_company_header);
        presenter.setView(this);
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

}
