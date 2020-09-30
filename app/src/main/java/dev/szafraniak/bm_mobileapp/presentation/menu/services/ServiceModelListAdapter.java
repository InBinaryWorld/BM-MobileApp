package dev.szafraniak.bm_mobileapp.presentation.menu.services;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.BaseFilterAdapter;

public class ServiceModelListAdapter extends BaseFilterAdapter<ServiceModel> {

    public ServiceModelListAdapter(Context context) {
        super(context, R.layout.row_list_service_model);
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
        ServiceModel item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.name.setText(item.getName());
        return convertView;
    }

}