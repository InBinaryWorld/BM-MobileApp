package dev.szafraniak.bm_mobileapp.presentation.menu.invoices;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseAdapter;

public class InvoiceListAdapter extends BaseAdapter<Invoice> {

    public InvoiceListAdapter(Context context) {
        super(context, R.layout.row_list_invoice);
    }

    static class ViewHolder {
        TextView name;
    }

    @Override
    protected View createView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(resourceId, parent, false);
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


}