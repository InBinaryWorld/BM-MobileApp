package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.InvoiceItemViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form.list.InvoiceItemsListForm;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form.summary.InvoiceItemsSummaryForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.shared.BaseViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.base.BaseForm;

public class InvoiceItemsForm extends BaseForm<List<InvoiceItemFormModel>, BaseViewHolder, InvoiceItemsConfig> {

    @LayoutRes
    private static final int layoutId = R.layout.form_base_group;

    InvoiceItemsSummaryForm summaryForm;
    InvoiceItemsListForm listForm;


    public InvoiceItemsForm(LayoutInflater inflater, ViewGroup viewGroup, InvoiceItemsConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    public List<InvoiceItemFormModel> getValue() {
        return listForm.getValue();
    }

    @Override
    public boolean isValid() {
        return listForm.isValid();
    }

    @Override
    protected void showValueOnView(List<InvoiceItemFormModel> value) {
        if (value == null) {
            listForm.setValue(new ArrayList<>());
            summaryForm.setValue(new ArrayList<>());
            return;
        }
        listForm.setValue(value);
        summaryForm.setValue(value);
    }

    @Override
    protected InvoiceItemViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, InvoiceItemsConfig config) {

        LinearLayout groupList = (LinearLayout) inflater.inflate(layoutId, viewGroup, false);
        summaryForm = new InvoiceItemsSummaryForm(inflater, groupList, config.getSummaryConfig());
        listForm = new InvoiceItemsListForm(inflater, groupList, config.getItemsConfig());

        groupList.addView(summaryForm.getView());
        groupList.addView(listForm.getView());

        InvoiceItemViewHolder holder = new InvoiceItemViewHolder();
        holder.view = groupList;
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, InvoiceItemsConfig config) {
        summaryForm.setSafeNavigationExecutor(this::executeSafeNavigation);
        listForm.setSafeNavigationExecutor(this::executeSafeNavigation);
        listForm.setOnValueChange(this::onItemListChange);
    }

    private void onItemListChange(boolean isValid) {
        summaryForm.setValue(listForm.getValue());
        onValueChange();
    }

}
