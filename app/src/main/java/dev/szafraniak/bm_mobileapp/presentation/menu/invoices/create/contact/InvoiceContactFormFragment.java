package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.List;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.ContactForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.ContactFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment.BaseFormFragment;

@EFragment(R.layout.fragment_base_form)
public class InvoiceContactFormFragment extends BaseFormFragment<Contact, ContactFormConfig> implements InvoiceContactView {

    public static final String FORM_ID_KEY = "FORM_ID_KEY";
    public static final String FORM_ID_CREATE_INVOICE_BUYER = "CREATE_INVOICE_BUYER";
    public static final String FORM_ID_CREATE_INVOICE_RECEIVER = "CREATE_INVOICE_RECEIVER";

    @Inject
    InvoiceContactPresenter presenter;

    private String keyId;


    @AfterViews
    public void initialize() {
        @SuppressWarnings("ConstantConditions")
        BMApplication app = (BMApplication) getActivity().getApplication();
        app.getAppComponent().inject(this);
        fetchArgumentsData();
        presenter.setView(this);
    }

    private void fetchArgumentsData() {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(FORM_ID_KEY)) {
            Navigator.back(this);
            return;
        }
        this.keyId = args.getString(FORM_ID_KEY);
    }

    @Override
    protected int getButtonTextId() {
        return R.string.btn_text_invoice_create_payment;
    }

    @Override
    protected FormInterface<Contact> createForm(LayoutInflater inflater, LinearLayout linearLayout, ContactFormConfig config) {
        return new ContactForm(inflater, linearLayout, config);
    }

    @Override
    protected void onSubmit(Contact paymentFormModel) {
        presenter.saveContact(keyId, paymentFormModel);
    }

    @Override
    protected int getHeaderTextResourceId() {
        return R.string.header_invoice_create_payment;
    }

    @Override
    protected void loadData() {
        presenter.loadData(keyId);
    }

    @Override
    public void setData(Contact model, List<IndividualContact> individualContacts, List<CompanyContact> companyContacts) {
        ContactFormConfig config = presenter.createConfig(individualContacts, companyContacts);
        startForm(config, model);
    }
}
