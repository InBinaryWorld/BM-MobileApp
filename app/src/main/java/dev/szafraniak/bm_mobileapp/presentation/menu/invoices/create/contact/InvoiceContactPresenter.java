package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.contact;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Pair;

import java.util.List;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ContactsService;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsManager;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.companyContact.CompanyContact;
import dev.szafraniak.bm_mobileapp.business.models.entity.contact.Contact;
import dev.szafraniak.bm_mobileapp.business.models.entity.individualContact.IndividualContact;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceFormModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.components.contact.ContactFormConfig;
import io.reactivex.Observable;
import lombok.Setter;
import timber.log.Timber;

public class InvoiceContactPresenter {

    @Inject
    ContactsService contactsService;

    @Inject
    SessionManager sessionManager;

    @Inject
    FormsManager formsManager;

    @Setter
    protected InvoiceContactView view;

    public InvoiceContactPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(String keyId) {
        Contact initModel = getInitValue(keyId);
        Long companyId = sessionManager.getCompanyId();
        Observable
            .zip(
                contactsService.getIndividualContacts(companyId),
                contactsService.getCompanyContacts(companyId),
                (a, b) -> new Pair<>(a.getItems(), b.getItems())
            )
            .compose(view.bindToLifecycle())
            .subscribe(lists -> view.setData(initModel, lists.first, lists.second), view::setError);
    }

    private Contact getInitValue(String keyId) {
        switch (keyId) {
            case InvoiceContactFormFragment.FORM_ID_CREATE_INVOICE_BUYER:
                return formsManager.getCreateInvoiceFormModel().getBaseModel().getBuyer();
            case InvoiceContactFormFragment.FORM_ID_CREATE_INVOICE_RECEIVER:
                return formsManager.getCreateInvoiceFormModel().getBaseModel().getReceiver();
            default:
                Timber.e("INCOMPATIBLE KEY !!!");
                Navigator.back(view);
                return null;
        }
    }

    public void saveContact(String keyId, Contact contact) {
        CreateInvoiceFormModel createInvoiceModel = formsManager.getCreateInvoiceFormModel();
        switch (keyId) {
            case InvoiceContactFormFragment.FORM_ID_CREATE_INVOICE_BUYER:
                createInvoiceModel.getBaseModel().setBuyer(contact);
                formsManager.setCreateInvoiceFormModel(createInvoiceModel);
                break;
            case InvoiceContactFormFragment.FORM_ID_CREATE_INVOICE_RECEIVER:
                createInvoiceModel.getBaseModel().setReceiver(contact);
                formsManager.setCreateInvoiceFormModel(createInvoiceModel);
                break;
            default:
                Timber.e("INCOMPATIBLE KEY !!!");
        }
        Navigator.back(view);
    }

    public ContactFormConfig createConfig(List<IndividualContact> individuals, List<CompanyContact> companies) {
        return FormConfigurations.getContactFormConfig(individuals, companies);
    }
}
