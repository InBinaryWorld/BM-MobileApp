package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Pair;

import java.util.List;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.http.service.ProductModelService;
import dev.szafraniak.bm_mobileapp.business.http.service.ServiceModelService;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsManager;
import dev.szafraniak.bm_mobileapp.business.memory.session.SessionManager;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.InvoiceItemFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormConfigurations;
import io.reactivex.Observable;
import lombok.Setter;

public class InvoiceCreateItemFormPresenter {

    @Inject
    ProductModelService productModelService;

    @Inject
    ServiceModelService serviceModelService;

    @Inject
    SessionManager sessionManager;

    @Inject
    FormsManager formsManager;

    @Setter
    protected CrateInvoiceItemFormView view;

    public InvoiceCreateItemFormPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    @SuppressLint("CheckResult")
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void loadData(ItemCommand command) {
        Long companyId = sessionManager.getCompanyId();
        InvoiceItemFormModel initModel = getInitValue(command);
        Observable
            .zip(
                productModelService.getProductModels(companyId),
                serviceModelService.getServiceModels(companyId),
                (a, b) -> new Pair<>(a.getItems(), b.getItems())
            )
            .compose(view.bindToLifecycle())
            .subscribe(lists -> view.setData(initModel, lists.first, lists.second), view::setError);
    }

    private InvoiceItemFormModel getInitValue(ItemCommand command) {
        if (ItemCommand.CREATE.equals(command.getType())) {
            return null;
        }
        List<InvoiceItemFormModel> items = formsManager.getCreateInvoiceFormModel().getItems();
        return findItemById(items, command.getItemId());
    }

    public void saveItem(ItemCommand command, InvoiceItemFormModel item) {
        CreateInvoiceFormModel model = formsManager.getCreateInvoiceFormModel();
        List<InvoiceItemFormModel> items = model.getItems();
        if (ItemCommand.CREATE.equals(command.getType())) {
            item.setId(model.getNextItemsId());
            items.add(item);
            formsManager.setCreateInvoiceFormModel(model);
        } else {
            replaceItem(items, item, command.getItemId());
        }
        Navigator.back(view);
    }

    private void replaceItem(List<InvoiceItemFormModel> items, InvoiceItemFormModel newItem, Long itemId) {
        InvoiceItemFormModel listItem = findItemById(items, itemId);
        int idx = items.indexOf(listItem);
        items.remove(idx);
        newItem.setId(itemId);
        items.add(idx, newItem);
    }

    private InvoiceItemFormModel findItemById(List<InvoiceItemFormModel> items, Long id) {
        return items.stream().filter(item -> item.getId().equals(id)).findFirst().get();
    }

    public InvoiceItemFormConfig createConfig(List<ProductModel> products, List<ServiceModel> services) {
        return FormConfigurations.getInvoiceItemConfig(products, services);
    }
}
