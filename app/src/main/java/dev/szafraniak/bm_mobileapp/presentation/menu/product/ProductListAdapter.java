package dev.szafraniak.bm_mobileapp.presentation.menu.product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.models.entity.product.Product;
import dev.szafraniak.bm_mobileapp.business.utils.Formatter;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.BaseFilterListAdapter;

public class ProductListAdapter extends BaseFilterListAdapter<Product, Product> {

    private static final int layoutId = R.layout.row_list_product;

    public ProductListAdapter(LayoutInflater inflater, List<Product> initialList) {
        super(inflater, initialList);
    }

    static class ViewHolder {
        TextView name;
        TextView grossPrice;
        TextView currency;
        TextView quantity;
        TextView quantityUnit;
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_name);
            viewHolder.grossPrice = convertView.findViewById(R.id.tv_price);
            viewHolder.currency = convertView.findViewById(R.id.tv_price_currency);
            viewHolder.quantity = convertView.findViewById(R.id.tv_quantity);
            viewHolder.quantityUnit = convertView.findViewById(R.id.tv_quantity_unit);
            convertView.setTag(viewHolder);
        }
        Product item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        fullFillView(holder, item);
        return convertView;
    }

    private void fullFillView(ViewHolder holder, Product item) {
        Price price = item.getProductModel().getPriceSuggestion();
        holder.grossPrice.setText(Formatter.safeFormatPrice(price.getGross()));
        holder.currency.setText(price.getCurrency());
        holder.name.setText(item.getProductModel().getName());
        holder.quantity.setText(Formatter.safeFormatWithFraction(item.getQuantity()));
        holder.quantityUnit.setText(item.getProductModel().getQuantityUnit());
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