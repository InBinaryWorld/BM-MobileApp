package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.create;

import android.view.LayoutInflater;
import android.widget.LinearLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CreateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class CompanyContactCreateFragment extends BaseFormFragment<CreateCompanyContactRequest, CompanyContactCreateFormConfig> implements CompanyContactCreateView {

    @Inject
    CompanyContactCreatePresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_text_warehouse_list;
    }


    @Override
    protected FormInterface<CreateCompanyContactRequest> createForm(LayoutInflater inflater, LinearLayout linearLayout, CompanyContactCreateFormConfig config) {
        return new CompanyContactCreateForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(CreateCompanyContactRequest object) {
        presenter.createCompany(object);
    }

    @Override
    protected void loadData() {
        // Nothing to load, just show form
        CompanyContactCreateFormConfig config = presenter.createConfig();
        startForm(config);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_contact_create;
    }
}
