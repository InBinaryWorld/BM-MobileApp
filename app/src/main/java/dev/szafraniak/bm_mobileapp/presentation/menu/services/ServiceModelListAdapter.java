package dev.szafraniak.bm_mobileapp.presentation.menu.services;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.serviceModel.ServiceModel;
import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.CurrencyWrapper;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.BaseFilterListAdapter;

public class ServiceModelListAdapter extends BaseFilterListAdapter<CurrencyWrapper<ServiceModel>, CurrencyWrapper<ServiceModel>> {

    private static final int layoutId = R.layout.row_list_resource_item_model;

    public ServiceModelListAdapter(LayoutInflater inflater, List<CurrencyWrapper<ServiceModel>> initialList) {
        super(inflater, initialList);
    }

    static class ViewHolder {
        TextView name;
        TextView price;
        TextView priceCurrency;
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_name);
            viewHolder.price = convertView.findViewById(R.id.tv_price);
            viewHolder.priceCurrency = convertView.findViewById(R.id.tv_price_currency);
            convertView.setTag(viewHolder);
        }
        CurrencyWrapper<ServiceModel> item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        fullFillView(item, holder);
        return convertView;
    }

    private void fullFillView(CurrencyWrapper<ServiceModel> item, ViewHolder holder) {
        holder.name.setText(item.getItem().getName());
        holder.price.setText(Parsers.safeFormatPrice(item.getItem().getPriceSuggestion().getGross()));
        holder.priceCurrency.setText(item.getCurrency());
    }


    @Override
    protected CurrencyWrapper<ServiceModel> extractGetItemValue(CurrencyWrapper<ServiceModel> item) {
        return item;
    }

    @Override
    protected long getItemId(CurrencyWrapper<ServiceModel> item) {
        return item.getItem().getId();
    }

    @Override
    public String getItemFilterValue(CurrencyWrapper<ServiceModel> item) {
        return item.getItem().getFilterValue();
    }

}