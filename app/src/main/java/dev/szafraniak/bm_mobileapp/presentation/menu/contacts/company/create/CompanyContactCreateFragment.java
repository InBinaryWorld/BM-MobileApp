package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create;

import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.CreateAddressRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;

@EFragment(R.layout.fragment_base_form)
public class CompanyContactCreateFragment extends BaseFormFragment<CreateCompanyContactRequest> implements CompanyContactCreateView {

    @ViewById(R.id.tv_header_text)
    TextView headerTextView;


    @Inject
    CompanyContactCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        headerTextView.setText(R.string.header_create_contact);
        presenter.setView(this);
    }

    @Override
    protected CreateCompanyContactRequest getFormModel() {
        CreateCompanyContactRequest model = new CreateCompanyContactRequest();
        model.setAddress(new CreateAddressRequest());
        return model;
    }

    @Override
    protected void onSubmit(CreateCompanyContactRequest object) {
        presenter.createCompany(object);
    }

    @Override
    protected FormConfig<CreateCompanyContactRequest> createFormConfig() {
        return new CompanyContactCreateFormConfig(inflater, layout);
    }

}
