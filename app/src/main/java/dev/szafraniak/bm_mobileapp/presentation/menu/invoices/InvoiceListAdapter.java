package dev.szafraniak.bm_mobileapp.presentation.menu.invoices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;
import dev.szafraniak.bm_mobileapp.business.utils.Formatter;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListAdapter;

public class InvoiceListAdapter extends BaseListAdapter<Invoice, Invoice> {

    @LayoutRes
    private static final int layoutId = R.layout.row_list_invoice;
    private final int colorPaid;
    private final int colorUnpaid;

    public InvoiceListAdapter(Context context, List<Invoice> invoices) {
        super(LayoutInflater.from(context), invoices);
        colorPaid = context.getColor(R.color.colorSuccess);
        colorUnpaid = context.getColor(R.color.colorError);
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_name);
            viewHolder.state = convertView.findViewById(R.id.tv_state);
            viewHolder.buyer = convertView.findViewById(R.id.tv_buyer);
            viewHolder.creationDate = convertView.findViewById(R.id.tv_creation_date);
            convertView.setTag(viewHolder);
        }
        Invoice item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        fullFillView(holder, item);
        return convertView;
    }

    private void fullFillView(ViewHolder holder, Invoice item) {
        holder.name.setText(item.getInvoiceName());
        holder.buyer.setText(item.getBuyerName());
        holder.creationDate.setText(Formatter.safeFormatDate(item.getCreationDate()));
        if (item.getIsPaid()) {
            holder.state.setTextColor(colorPaid);
            holder.state.setText(R.string.row_invoice_state_paid);
        } else {
            holder.state.setTextColor(colorUnpaid);
            holder.state.setText(R.string.row_invoice_state_unpaid);
        }
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
        TextView state;
        TextView buyer;
        TextView creationDate;
    }

}