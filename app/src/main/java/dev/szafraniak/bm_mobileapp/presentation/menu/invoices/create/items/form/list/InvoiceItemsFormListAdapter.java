package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.mics.AmountModel;
import dev.szafraniak.bm_mobileapp.business.utils.FinancesUtils;
import dev.szafraniak.bm_mobileapp.business.utils.Formatter;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.list.BaseListFormAdapter;

public class InvoiceItemsFormListAdapter extends BaseListFormAdapter<InvoiceItemFormModel> {

    @LayoutRes
    private static final int layoutId = R.layout.row_invoice_create_item;

    public InvoiceItemsFormListAdapter(LayoutInflater inflater, List<InvoiceItemFormModel> invoiceItems) {
        super(inflater, invoiceItems);
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_name);
            viewHolder.quantity = convertView.findViewById(R.id.tv_quantity);
            viewHolder.quantityUnit = convertView.findViewById(R.id.tv_quantity_unit);
            viewHolder.amount = convertView.findViewById(R.id.tv_amount);
            viewHolder.amountCurrency = convertView.findViewById(R.id.tv_amount_currency);
            viewHolder.removeIcon = convertView.findViewById(R.id.iv_remove);
            convertView.setTag(viewHolder);
        }
        InvoiceItemFormModel item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        fullFillView(item, holder);
        return convertView;
    }

    private void fullFillView(InvoiceItemFormModel item, ViewHolder holder) {
        AmountModel amount = FinancesUtils.countAmount(item);
        holder.name.setText(item.getName());
        holder.quantity.setText(Formatter.safeFormatWithFraction(item.getQuantity()));
        holder.quantityUnit.setText(item.getQuantityUnit());
        holder.amount.setText(Formatter.safeFormatPrice(amount.getGross()));
        holder.amountCurrency.setText(item.getPrice().getCurrency());
        holder.removeIcon.setOnClickListener((view) -> removeItem(item));
    }


    @Override
    public long getItemId(int i) {
        return getItem(i).getId();
    }

    static class ViewHolder {
        TextView name;
        TextView quantity;
        TextView quantityUnit;
        TextView amount;
        TextView amountCurrency;
        ImageView removeIcon;
    }

}