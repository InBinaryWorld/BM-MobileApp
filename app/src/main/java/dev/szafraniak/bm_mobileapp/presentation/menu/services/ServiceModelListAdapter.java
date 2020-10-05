package dev.szafraniak.bm_mobileapp.presentation.menu.services;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.BaseFilterListAdapter;

public class ServiceModelListAdapter extends BaseFilterListAdapter<ServiceModel, ServiceModel> {

    private static final int layoutId = R.layout.row_list_service_model;

    public ServiceModelListAdapter(LayoutInflater inflater, List<ServiceModel> initialList) {
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
        ServiceModel item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.name.setText(item.getName());
        return convertView;
    }

    @Override
    protected ServiceModel extractGetItemValue(ServiceModel item) {
        return item;
    }

    @Override
    public String getItemFilterValue(ServiceModel item) {
        return item.getFilterValue();
    }

}