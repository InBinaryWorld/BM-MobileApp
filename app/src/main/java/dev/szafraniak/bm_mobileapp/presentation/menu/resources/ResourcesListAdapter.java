package dev.szafraniak.bm_mobileapp.presentation.menu.resources;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.warehouse.Warehouse;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListAdapter;
import lombok.Setter;

public class ResourcesListAdapter extends BaseListAdapter<Warehouse, Warehouse> {

    @LayoutRes
    private static final int layoutId = R.layout.row_list_warehouse;

    @Setter
    private WarehouseDetailsListener detailsListener;


    public ResourcesListAdapter(LayoutInflater inflater, List<Warehouse> initialList) {
        super(inflater, initialList);
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_warehouse_name);
            viewHolder.address = convertView.findViewById(R.id.tv_warehouse_address);
            viewHolder.warehouseDetails = convertView.findViewById(R.id.iv_warehouse_details);
            convertView.setTag(viewHolder);
        }
        Warehouse item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        fullFillView(item, holder);
        return convertView;
    }

    private void fullFillView(Warehouse item, ViewHolder holder) {
        holder.name.setText(item.getName());
        holder.address.setText(item.getAddress().getShortAddress());
        holder.warehouseDetails.setOnClickListener(view -> requestDetails(item));
    }

    @Override
    protected Warehouse extractGetItemValue(Warehouse item) {
        return item;
    }

    @Override
    protected long getItemId(Warehouse item) {
        return item.getId();
    }

    static class ViewHolder {
        TextView name;
        TextView address;
        ImageView warehouseDetails;
    }

    private void requestDetails(Warehouse warehouse) {
        if (detailsListener != null) {
            detailsListener.onDetailsRequest(warehouse);
        }
    }

    interface WarehouseDetailsListener {
        void onDetailsRequest(Warehouse warehouse);
    }

}