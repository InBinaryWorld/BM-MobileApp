package dev.szafraniak.bm_mobileapp.presentation.menu.finances;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.FinancialRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseAdapter;

public class FinancesListAdapter extends BaseAdapter<FinancialRow> {

    public FinancesListAdapter(Context context) {
        super(context, R.layout.row_list_finances);
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
        FinancialRow item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.name.setText(item.getTitle());
        return convertView;
    }

}