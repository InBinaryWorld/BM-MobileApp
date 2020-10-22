package dev.szafraniak.bm_mobileapp.presentation.menu.invoices;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListAdapter;

public class InvoiceListAdapter extends BaseListAdapter<Invoice, Invoice> {

    @LayoutRes
    private static final int layoutId = R.layout.row_list_invoice;

    public InvoiceListAdapter(LayoutInflater inflater, List<Invoice> invoices) {
        super(inflater, invoices);
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_payment_type);
            convertView.setTag(viewHolder);
        }
        Invoice item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        String invoiceName = item.getInvoiceName();
        holder.name.setText(invoiceName);
        return convertView;
    }

    @Override
    protected Invoice extractGetItemValue(Invoice item) {
        return item;
    }

    @Override
    protected long getItemId(Invoice item) {
        return item.getId();
    }

    static class ViewHolder {
        TextView name;
    }

}