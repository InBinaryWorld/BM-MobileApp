package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListAdapter;

public class CreateInvoiceItemsListAdapter extends BaseListAdapter<InvoiceItemFormModel, InvoiceItemFormModel> {

    @LayoutRes
    private static final int layoutId = R.layout.row_invoice_create_items;

    public CreateInvoiceItemsListAdapter(LayoutInflater inflater, List<InvoiceItemFormModel> invoiceItems) {
        super(inflater, invoiceItems);
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_item_name);
            convertView.setTag(viewHolder);
        }
        InvoiceItemFormModel item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        String invoiceName = item.getName();
        holder.name.setText(invoiceName);
        return convertView;
    }

    @Override
    protected InvoiceItemFormModel extractGetItemValue(InvoiceItemFormModel item) {
        return item;
    }

    @Override
    protected long getItemId(InvoiceItemFormModel item) {
        return item.getId();
    }

    static class ViewHolder {
        TextView name;
    }

}