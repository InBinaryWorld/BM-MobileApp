package dev.szafraniak.bm_mobileapp.presentation.menu.product.create.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.price.Price;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.business.utils.Parsers;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.BaseSpinnerAdapter;

public class ProductModelSpinnerAdapter extends BaseSpinnerAdapter<ProductModel, Long> {

    @LayoutRes
    private static final int layoutId = R.layout.row_spinner_base_preview;

    @LayoutRes
    private static final int dropdownLayoutId = R.layout.row_list_product_model;

    public ProductModelSpinnerAdapter(LayoutInflater inflater, ProductModelSpinnerFormConfig config) {
        super(inflater, config.getSpinnerItems());
    }

    @Override
    protected View createDropdownView(LayoutInflater inflater, int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = inflater.inflate(dropdownLayoutId, viewGroup, false);
            DropdownViewHolder viewHolder = new DropdownViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_name);
            viewHolder.price = convertView.findViewById(R.id.tv_price);
            viewHolder.priceCurrency = convertView.findViewById(R.id.tv_price_currency);
            convertView.setTag(viewHolder);
        }
        ProductModel item = getWholeItem(position);
        DropdownViewHolder holder = (DropdownViewHolder) convertView.getTag();
        fullFillView(item, holder);
        return convertView;
    }

    private void fullFillView(ProductModel item, DropdownViewHolder holder) {
        Price price = item.getPriceSuggestion();
        holder.name.setText(item.getName());
        holder.price.setText(Parsers.safeFormatPrice(price.getGross()));
        holder.priceCurrency.setText(price.getCurrency());
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_spinner_value);
            convertView.setTag(viewHolder);
        }
        ProductModel item = getWholeItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.name.setText(item.getName());
        return convertView;
    }

    @Override
    protected Long extractGetItemValue(ProductModel item) {
        return item.getId();
    }

    @Override
    protected long getItemId(ProductModel item) {
        return item.getId();
    }


    private static class ViewHolder {
        TextView name;
    }

    private static class DropdownViewHolder {
        TextView name;
        TextView price;
        TextView priceCurrency;
    }

}
