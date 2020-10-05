package dev.szafraniak.bm_mobileapp.presentation.menu.warehouse;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListAdapter;

public class WarehouseListAdapter extends BaseListAdapter<Warehouse, Warehouse> {

    @LayoutRes
    private static final int layoutId = R.layout.row_list_product_model;

    public WarehouseListAdapter(LayoutInflater inflater, List<Warehouse> initialList) {
        super(inflater, initialList);
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_payment_type);
            convertView.setTag(viewHolder);
        }
        Warehouse item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.name.setText(item.getName());
        return convertView;
    }

    @Override
    protected Warehouse extractGetItemValue(Warehouse item) {
        return item;
    }

    static class ViewHolder {
        TextView name;
    }

}