package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.gson.Gson;

import java.util.ArrayList;

import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.CreateInvoiceItemFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.ItemCommand;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.list.BaseListFormAdapter;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.list.BaseListFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.list.ListFormRowConfig;

public class InvoiceItemsListForm extends BaseListFormRow<InvoiceItemFormModel> {
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


//
//
//    ItemTypeForm itemTypeForm;
//    ProductAutoCompleteForm productForm;
//    ServiceAutoCompleteForm serviceForm;
//
//
//    public InvoiceItemsListForm(LayoutInflater inflater, ViewGroup viewGroup, InvoiceItemFormConfig config) {
//        super(inflater, viewGroup, config);
//    }
//
//    @Override
//    protected void updateView(boolean isValid) {
//    }
//
//    @Override
//    public InvoiceItemFormModel getValue() {
//        ItemType type = itemTypeForm.getValue();
//        if (ItemType.PRODUCT.equals(type)) {
//            return productForm.getValue();
//        } else if (ItemType.SERVICE.equals(type)) {
//            return serviceForm.getValue();
//        }
//        return null;
//    }
//
//    @Override
//    public boolean isValid() {
//        ItemType type = itemTypeForm.getValue();
//        return ItemType.PRODUCT.equals(type) && productForm.isValid()
//            || ItemType.SERVICE.equals(type) && serviceForm.isValid();
//    }
//
//    @Override
//    protected void showValueOnView(InvoiceItemFormModel value) {
//        if (value == null) {
//            return;
//        }
//        ItemType type = value.getType();
//        itemTypeForm.setValue(type);
//        if (ItemType.PRODUCT.equals(type)) {
//            productForm.setValue(value);
//        } else {
//            serviceForm.setValue(value);
//        }
//    }
//
//    @Override
//    protected InvoiceItemViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, InvoiceItemFormConfig config) {
//
//        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
//
//        itemTypeForm = new ItemTypeForm(inflater, groupList, config.getItemTypeForm());
//        productForm = new ProductAutoCompleteForm(inflater, groupList, config.getProductConfig());
//        serviceForm = new ServiceAutoCompleteForm(inflater, groupList, config.getServiceConfig());
//
//        View productFormView = productForm.getView();
//        View serviceFormView = serviceForm.getView();
//        groupList.addView(itemTypeForm.getView());
//        groupList.addView(serviceFormView);
//        groupList.addView(productFormView);
//
//        InvoiceItemViewHolder holder = new InvoiceItemViewHolder();
//        holder.view = groupList;
//        holder.serviceView = serviceFormView;
//        holder.productView = productFormView;
//        return holder;
//    }
//
//    @Override
//    protected void setupView(LayoutInflater inflater, InvoiceItemFormConfig config) {
//        itemTypeForm.setOnValueChange(this::onTypeChange);
//        productForm.setOnValidationStateChanged(this::onValueChange);
//        serviceForm.setOnValidationStateChanged(this::onValueChange);
//    }
//
//    private void onTypeChange(boolean isValid) {
//        InvoiceItemViewHolder holder = getViewHolder();
//        boolean isProduct = ItemType.PRODUCT.equals(itemTypeForm.getValue());
//        holder.productView.setVisibility(isProduct ? View.VISIBLE : View.GONE);
//        holder.serviceView.setVisibility(!isProduct ? View.VISIBLE : View.GONE);
//        onValueChange();
//    }

}
