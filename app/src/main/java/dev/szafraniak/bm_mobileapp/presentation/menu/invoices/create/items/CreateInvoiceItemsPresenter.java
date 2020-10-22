package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items;

import android.app.Application;
import android.os.Bundle;

import com.google.gson.Gson;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.InvoiceService;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsManager;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.CreateInvoiceRequest;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.InvoiceItem;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form.InvoiceItemsConfig;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.details.InvoiceDetailsFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import lombok.Setter;

public class CreateInvoiceItemsPresenter {

    @Setter
    CreateInvoiceItemsView view;

    @Inject
    FormsManager formsManager;

    @Inject
    SessionManager sessionManager;

    @Inject
    InvoiceService invoiceService;

    @Inject
    Gson gson;

    public CreateInvoiceItemsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void loadData() {
        CreateInvoiceFormModel model = formsManager.getCreateInvoiceFormModel();
        List<InvoiceItemFormModel> items = model.getItems();
        view.setData(items);
    }


    public void generateInvoice() {
        Long companyId = sessionManager.getCompanyId();
        CreateInvoiceRequest request = getRequest();
        invoiceService.createInvoice(companyId, request)
            .compose(view.bindToLifecycle())
            .subscribe(this::navigateToDetails, view::setActionFailed);
    }

    private CreateInvoiceRequest getRequest() {
        CreateInvoiceFormModel model = formsManager.getCreateInvoiceFormModel();
        CreateInvoiceRequest request = new CreateInvoiceRequest();
        request.setBuyer(model.getBaseModel().getBuyer());
        request.setReceiver(model.getBaseModel().getReceiver());
        request.setCreationDate(OffsetDateTime.now());
        request.setDueDate(model.getBaseModel().getPayment().getDueDate());
        request.setInvoiceNumber(model.getBaseModel().getInvoiceNumber());
        request.setPaymentMethod(model.getBaseModel().getPayment().getPaymentMethod());
        request.setItems(model.getItems().stream().map(item -> {
            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.setName(item.getName());
            invoiceItem.setNetPrice(item.getPrice().getNet());
            invoiceItem.setTaxRate(item.getPrice().getTaxRate());
            invoiceItem.setQuantity(item.getQuantity());
            invoiceItem.setQuantityUnit(item.getQuantityUnit());
            return invoiceItem;
        }).collect(Collectors.toList()));
        return request;
    }

    protected void navigateToDetails(Invoice invoice) {
        Bundle bundle = new Bundle();
        bundle.putString(InvoiceDetailsFragment.KEY_INVOICE, gson.toJson(invoice));
        Navigator.backOneAndNavigateTo(view, FragmentFactory.FRAGMENT_INVOICES_DETAILS, bundle);
    }

    public InvoiceItemsConfig createConfig() {
        return FormConfigurations.getInvoiceItemsConfig();
    }
}
