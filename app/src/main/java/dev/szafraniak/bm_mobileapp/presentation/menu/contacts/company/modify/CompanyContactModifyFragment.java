package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.UpdateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class CompanyContactModifyFragment extends BaseFormFragment<UpdateCompanyContactRequest,
        CompanyContactModifyFormConfig> implements CompanyContactModifyView {

    public final static String KEY_COMPANY_CONTACT = "COMPANY_CONTACT_KEY";

    @Inject
    CompanyContactModifyPresenter presenter;

    @Inject
    Gson gson;

    CompanyContact contact;


    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(KEY_COMPANY_CONTACT)) {
            Navigator.back(this);
            return;
        }
        String companyJSON = args.getString(KEY_COMPANY_CONTACT);
        contact = gson.fromJson(companyJSON, CompanyContact.class);
    }

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        fetchArgumentsData();
        presenter.setView(this);
    }

    @Override
    protected FormInterface<UpdateCompanyContactRequest> createForm(
            LayoutInflater inflater, LinearLayout linearLayout, CompanyContactModifyFormConfig config) {
        return new CompanyContactModifyForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(UpdateCompanyContactRequest object) {
        presenter.updateCompanyContact(object, contact.getId());
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_contact_modify;
    }

    @Override
    protected void loadData() {
        presenter.loadData(contact.getId());
    }

    @Override
    public void setModifyModel(CompanyContact contact) {
        UpdateCompanyContactRequest model = new UpdateCompanyContactRequest();
        model.setName(contact.getName());
        model.setPhone(contact.getPhone());
        model.setTaxIdentityNumber(contact.getTaxIdentityNumber());
        model.setAddress(contact.getAddress());

        CompanyContactModifyFormConfig config = presenter.createConfig();
        startForm(config, model);
    }
}
