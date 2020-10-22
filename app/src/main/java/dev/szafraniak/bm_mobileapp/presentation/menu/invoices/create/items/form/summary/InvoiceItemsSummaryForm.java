package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form.summary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import com.google.gson.Gson;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.amount.Amount;
import dev.szafraniak.bm_mobileapp.business.navigation.FragmentFactory;
import dev.szafraniak.bm_mobileapp.business.navigation.Navigator;
import dev.szafraniak.bm_mobileapp.business.utils.FinancesUtils;
import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.CreateInvoiceItemFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.ItemCommand;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.base.BaseForm;

public class InvoiceItemsSummaryForm extends BaseForm<List<InvoiceItemFormModel>, InvoiceItemsSummaryViewHolder, InvoiceItemsSummaryConfig> {

    @LayoutRes
    private final static int layoutId = R.layout.row_form_clickable_items_summary;

    public InvoiceItemsSummaryForm(LayoutInflater inflater, ViewGroup viewGroup, InvoiceItemsSummaryConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void showValueOnView(List<InvoiceItemFormModel> value) {
        InvoiceItemsSummaryViewHolder holder = getViewHolder();
        if (value == null) {
            holder.itemCount.setText("0");
            holder.grossTotalValue.setText("0");
            return;
        }
        Amount amount = FinancesUtils.countAmount(value);
        String totalGross = Parsers.safeFormatPrice(amount.getGross());
        holder.itemCount.setText(Integer.toString(value.size()));
        holder.grossTotalValue.setText(totalGross);
    }

    @Override
    protected void updateView(boolean isValid) {
    }

    @Override
    protected InvoiceItemsSummaryViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, InvoiceItemsSummaryConfig config) {
        InvoiceItemsSummaryViewHolder holder = new InvoiceItemsSummaryViewHolder();
        holder.view = inflater.inflate(layoutId, viewGroup, false);
        holder.itemCount = holder.view.findViewById(R.id.tv_total_items);
        holder.grossTotalValue = holder.view.findViewById(R.id.tv_total_gross);
        holder.addItemBtn = holder.view.findViewById(R.id.btn_add_item);
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, InvoiceItemsSummaryConfig config) {
        InvoiceItemsSummaryViewHolder holder = getViewHolder();
        holder.addItemBtn.setOnClickListener(this::navigateToContactForm);
    }

    protected void navigateToContactForm(View clickedView) {
        executeSafeNavigation(view -> {
            ItemCommand command = new ItemCommand();
            command.setType(ItemCommand.CREATE);
            Bundle bundle = new Bundle();
            String commandJSON = new Gson().toJson(command);
            bundle.putString(CreateInvoiceItemFormFragment.ITEM_COMMAND_KEY, commandJSON);
            Navigator.navigateTo(view, FragmentFactory.FRAGMENT_INVOICES_CREATE_ITEM, bundle);
        });
    }

    @Override
    public List<InvoiceItemFormModel> getValue() {
        return null;
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
