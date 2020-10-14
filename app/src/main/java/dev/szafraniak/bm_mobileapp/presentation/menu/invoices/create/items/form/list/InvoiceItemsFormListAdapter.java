package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.items.form.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.InvoiceItemFormModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.list.BaseListFormAdapter;

public class InvoiceItemsFormListAdapter extends BaseListFormAdapter<InvoiceItemFormModel> {

    @LayoutRes
    private static final int layoutId = R.layout.row_invoice_create_items;

    public InvoiceItemsFormListAdapter(LayoutInflater inflater, List<InvoiceItemFormModel> invoiceItems) {
        super(inflater, invoiceItems);
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_item_name);
            viewHolder.removeIcon = convertView.findViewById(R.id.iv_remove);
            convertView.setTag(viewHolder);
        }
        InvoiceItemFormModel item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        String invoiceName = item.getName();
        holder.name.setText(invoiceName);
        holder.removeIcon.setOnClickListener((view) -> removeItem(item));
        return convertView;
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).getId();
    }

    static class ViewHolder {
        TextView name;
        ImageView removeIcon;
    }

}