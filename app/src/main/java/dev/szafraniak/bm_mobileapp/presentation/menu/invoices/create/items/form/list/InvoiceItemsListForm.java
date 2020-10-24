package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.gson.Gson;

import java.util.ArrayList;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.CreateInvoiceItemFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.ItemCommand;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.list.BaseListFormAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.list.BaseListFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.list.ListFormRowConfig;

public class InvoiceItemsListForm extends BaseListFormRow<InvoiceItemFormModel> {

    @Override
    protected int getLayoutId() {
        return R.layout.form_invoice_item_list;
    }

    public InvoiceItemsListForm(LayoutInflater inflater, ViewGroup viewGroup, ListFormRowConfig<InvoiceItemFormModel> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected BaseListFormAdapter<InvoiceItemFormModel> createAdapter(LayoutInflater inflater, ListFormRowConfig<InvoiceItemFormModel> config) {
        return new InvoiceItemsFormListAdapter(inflater, new ArrayList<>());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View host, int position, long id) {
        executeSafeNavigation(view -> {
            ItemCommand command = new ItemCommand();
            command.setType(ItemCommand.MODIFY);
            command.setItemId(parent.getItemIdAtPosition(position));
            Bundle bundle = new Bundle();
            String commandJSON = new Gson().toJson(command);
            bundle.putString(CreateInvoiceItemFormFragment.ITEM_COMMAND_KEY, commandJSON);
            Navigator.navigateTo(view, FragmentFactory.FRAGMENT_INVOICES_CREATE_ITEM, bundle);
        });
    }

}
