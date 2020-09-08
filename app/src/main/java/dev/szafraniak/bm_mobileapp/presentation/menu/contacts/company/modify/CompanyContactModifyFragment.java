package dev.szafraniak.bm_mobileapp.presentation.menu.contacts.company.modify;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.address.UpdateAddressRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.UpdateCompanyContactRequest;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;

@EFragment(R.layout.fragment_base_form)
public class CompanyContactModifyFragment extends BaseFormFragment<UpdateCompanyContactRequest> implements CompanyContactModifyView {

    public final static String KEY_COMPANY_CONTACT = "COMPANY_CONTACT_KEY";

    @Inject
    CompanyContactModifyPresenter presenter;

    CompanyContact contact;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null || !getArguments().containsKey(KEY_COMPANY_CONTACT)) {
            Navigator.back(this);
        }
        String companyJSON = getArguments().getString(KEY_COMPANY_CONTACT);
        contact = new Gson().fromJson(companyJSON, CompanyContact.class);
    }

    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        presenter.setView(this);
        super.initialize();
    }

    @Override
    protected UpdateCompanyContactRequest getFormModel() {
        UpdateCompanyContactRequest model = new UpdateCompanyContactRequest();
        model.setAddress(new UpdateAddressRequest());
        return model;
    }

    @Override
    protected void onSubmit(UpdateCompanyContactRequest object) {
        presenter.updateCompanyContact(object, contact.getId());
    }

    @Override
    protected FormConfig<UpdateCompanyContactRequest> createFormConfig() {
        return new CompanyContactModifyFormConfig(inflater, layout, contact);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_create_contact;
    }
}
