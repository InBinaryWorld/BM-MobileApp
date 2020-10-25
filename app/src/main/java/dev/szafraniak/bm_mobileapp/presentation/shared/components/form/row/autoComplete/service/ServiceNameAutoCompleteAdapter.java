package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.service;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete.BaseAutoCompleteListAdapter;

public class ServiceNameAutoCompleteAdapter extends BaseAutoCompleteListAdapter<ServiceModel> {

    @LayoutRes
    private static final int layoutId = R.layout.row_dropdown_service_model;

    public ServiceNameAutoCompleteAdapter(LayoutInflater inflater, List<ServiceModel> initialList) {
        super(inflater, initialList);
    }

    @Override
    public String getItemFilterValue(ServiceModel item) {
        return item.getName();
    }

    private class ViewHolder {
        TextView productName;
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.productName = convertView.findViewById(R.id.tv_product_name);
            convertView.setTag(viewHolder);
        }
        ServiceModel item = getWholeItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.productName.setText(item.getName());
        return convertView;
    }

    @Override
    protected String extractGetItemValue(ServiceModel item) {
        return item.getName();
    }

    @Override
    protected long getItemId(ServiceModel item) {
        return item.getId();
    }

}
