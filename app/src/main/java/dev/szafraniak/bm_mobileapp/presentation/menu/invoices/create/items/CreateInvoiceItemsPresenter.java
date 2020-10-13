package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items;

import android.app.Application;
import android.os.Bundle;

import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import dev.szafraniak.bm_mobileapp.business.BMApplication;
import dev.szafraniak.bm_mobileapp.business.memory.forms.FormsManager;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.CreateInvoiceFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.CreateInvoiceItemFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.ItemCommand;
import lombok.Setter;

public class CreateInvoiceItemsPresenter {

    @Inject
    Gson gson;

    @Setter
    CreateInvoiceItemsView view;

    @Inject
    FormsManager formsManager;

    public CreateInvoiceItemsPresenter(Application app) {
        ((BMApplication) app).getAppComponent().inject(this);
    }

    public void loadData() {
        CreateInvoiceFormModel model = formsManager.getCreateInvoiceFormModel();
        List<InvoiceItemFormModel> items = model.getItems();
        view.setData(items);
    }

    public void modifyItem(InvoiceItemFormModel item) {
        ItemCommand command = new ItemCommand();
        command.setType(ItemCommand.MODIFY);
        command.setItemId(item.getId());
        navigateToItemFragment(command);
    }

    public void addItem() {
        ItemCommand command = new ItemCommand();
        command.setType(ItemCommand.CREATE);
        navigateToItemFragment(command);
    }

    public void navigateToItemFragment(ItemCommand command) {
        Bundle bundle = new Bundle();
        String commandJSON = gson.toJson(command);
        bundle.putString(CreateInvoiceItemFormFragment.ITEM_COMMAND_KEY, commandJSON);
        Navigator.navigateTo(view, FragmentFactory.FRAGMENT_INVOICES_CREATE_ITEM, bundle);
    }
}
