package dev.szafraniak.bm_mobileapp.presentation.menu.product.create.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.BaseSpinnerAdapter;

public class ProductModelSpinnerAdapter extends BaseSpinnerAdapter<ProductModel, Long> {

    @LayoutRes
    private static final int layoutId = R.layout.row_dropdown_product_model;

    public ProductModelSpinnerAdapter(LayoutInflater inflater, ProductModelSpinnerFormConfig config) {
        super(inflater, config.getSpinnerItems());
    }

    @Override
    protected View createDropdownView(LayoutInflater inflater, int position, View convertView, ViewGroup viewGroup) {
        return createProductModelView(inflater, position, convertView, viewGroup);
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent) {
        return createProductModelView(inflater, position, convertView, parent);
    }

    @Override
    protected Long extractGetItemValue(ProductModel item) {
        return item.getId();
    }

    @Override
    protected long getItemId(ProductModel item) {
        return item.getId();
    }

    private View createProductModelView(LayoutInflater inflater, int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = convertView.findViewById(R.id.tv_product_name);
            convertView.setTag(viewHolder);
        }
        ProductModel item = getWholeItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.name.setText(item.getName());
        return convertView;
    }

    private static class ViewHolder {
        TextView name;
    }

}
