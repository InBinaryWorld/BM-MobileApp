package dev.szafraniak.bm_mobileapp.presentation.menu.product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.BaseFilterListAdapter;

public class ProductListAdapter extends BaseFilterListAdapter<Product, Product> {

    private static final int layoutId = R.layout.row_list_product;

    public ProductListAdapter(LayoutInflater inflater, List<Product> initialList) {
        super(inflater, initialList);
    }

    static class ViewHolder {
        TextView name;
        TextView quantity;
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_payment_type);
            viewHolder.quantity = convertView.findViewById(R.id.tv_quantity);
            convertView.setTag(viewHolder);
        }
        Product item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.name.setText(item.getProductModel().getName());
        holder.quantity.setText(Parsers.safeFormatWithFraction(item.getQuantity()));
        return convertView;
    }

    @Override
    protected Product extractGetItemValue(Product item) {
        return item;
    }

    @Override
    protected long getItemId(Product item) {
        return item.getId();
    }

    @Override
    public String getItemFilterValue(Product item) {
        return item.getProductModel().getFilterValue();
    }

}