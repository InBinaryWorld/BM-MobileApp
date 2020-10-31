package dev.szafraniak.bm_mobileapp.presentation.menu.company.modify;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.Company;
import dev.szafraniak.bm_mobileapp.business.models.entity.company.UpdateCompanyRequest;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.fragment.BaseFormWithTrashFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.FormInterface;

@EFragment(R.layout.fragment_base_form_with_trash)
public class ModifyCompanyFragment extends BaseFormWithTrashFragment<UpdateCompanyRequest, ModifyCompanyFormConfig> implements ModifyCompanyView {

    @Inject
    ModifyCompanyPresenter presenter;

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
    }


    @Override
    protected int getButtonTextId() {
        return R.string.btn_modify_form;
    }

    @Override
    protected FormInterface<UpdateCompanyRequest> createForm(
        LayoutInflater inflater, ViewGroup linearLayout, ModifyCompanyFormConfig config) {
        return new ModifyCompanyForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(UpdateCompanyRequest request) {
        presenter.modifyCompanyData(request);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_company_modify;
    }

    @Override
    protected void loadData() {
        presenter.loadData();
    }

    @Override
    public void setModifyModel(Company company) {
        UpdateCompanyRequest model = new UpdateCompanyRequest();
        model.setName(company.getName());
        model.setInvoicePrefix(company.getInvoicePrefix());
        model.setTaxIdentityNumber(company.getTaxIdentityNumber());
        model.setHeadquarter(company.getHeadquarter());

        ModifyCompanyFormConfig config = presenter.createConfig();
        startForm(config, model);
    }

    @Override
    protected void onTrash() {
        presenter.deleteCompany();
    }
}
