package dev.szafraniak.bm_mobileapp.presentation.menu.productmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.utils.Formatter;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.BaseFilterListAdapter;

public class ProductModelListAdapter extends BaseFilterListAdapter<ProductModel, ProductModel> {

    private static final int layoutId = R.layout.row_list_product_model;

    public ProductModelListAdapter(LayoutInflater inflater, List<ProductModel> initialList) {
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
        ProductModel item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        fullFillView(item, holder);
        return convertView;
    }

    private void fullFillView(ProductModel item, ViewHolder holder) {
        Price price = item.getPriceSuggestion();
        holder.name.setText(item.getName());
        holder.price.setText(Formatter.safeFormatPrice(price.getGross()));
        holder.priceCurrency.setText(price.getCurrency());
    }

    @Override
    protected ProductModel extractGetItemValue(ProductModel item) {
        return item;
    }

    @Override
    protected long getItemId(ProductModel item) {
        return item.getId();
    }

    @Override
    public String getItemFilterValue(ProductModel item) {
        return item.getFilterValue();
    }

}