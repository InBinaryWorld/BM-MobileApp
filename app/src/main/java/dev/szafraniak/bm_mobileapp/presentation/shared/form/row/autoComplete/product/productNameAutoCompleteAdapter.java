package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.entity.productmodel.ProductModel;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete.BaseAutoCompleteListAdapter;

public class productNameAutoCompleteAdapter extends BaseAutoCompleteListAdapter<ProductModel> {

    @LayoutRes
    private static final int layoutId = R.layout.row_dropdown_product_model;

    public productNameAutoCompleteAdapter(LayoutInflater inflater, List<ProductModel> initialList) {
        super(inflater, initialList);
    }

    @Override
    public String getItemFilterValue(ProductModel item) {
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
        ProductModel item = getWholeItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.productName.setText(item.getName());
        return convertView;
    }

    @Override
    protected String extractGetItemValue(ProductModel item) {
        return item.getName();
    }

    @Override
    protected long getItemId(ProductModel item) {
        return item.getId();
    }

}
