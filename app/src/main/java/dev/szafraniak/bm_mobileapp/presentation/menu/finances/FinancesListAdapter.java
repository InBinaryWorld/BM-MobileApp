package dev.szafraniak.bm_mobileapp.presentation.menu.finances;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.finantialRow.FinancialRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListAdapter;

public class FinancesListAdapter extends BaseListAdapter<FinancialRow> {
    private static final int layoutId = R.layout.row_list_finances;

    public FinancesListAdapter(LayoutInflater inflater, List<FinancialRow> initialList) {
        super(inflater, initialList);
    }

    static class ViewHolder {
        TextView name;
    }


    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
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