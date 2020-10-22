package dev.szafraniak.bm_mobileapp.presentation.menu.invoices.create.item.form.type;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.HashMap;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner.BaseSpinnerAdapter;

public class ItemTypeAdapter extends BaseSpinnerAdapter<ItemType, ItemType> {

    @LayoutRes
    private static final int layoutId = R.layout.row_dropdown_item_type;
    private ItemTypeFormConfig config;

    public ItemTypeAdapter(LayoutInflater inflater, ItemTypeFormConfig config) {
        super(inflater, config.getSpinnerItems());
        this.config = config;
    }

    @Override
    protected ItemType extractGetItemValue(ItemType item) {
        return item;
    }

    @Override
    protected long getItemId(ItemType item) {
        return 0;
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup viewGroup) {
        return createPaymentView(inflater, position, convertView, viewGroup);
    }

    @Override
    protected View createDropdownView(LayoutInflater inflater, int position, View convertView, ViewGroup viewGroup) {
        return createPaymentView(inflater, position, convertView, viewGroup);
    }


    private View createPaymentView(LayoutInflater inflater, int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.displayValue = convertView.findViewById(R.id.tv_item_type);
            convertView.setTag(viewHolder);
        }
        ItemType item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        HashMap<ItemType, String> displayValues = config.getDisplayValues();
        holder.displayValue.setText(displayValues.get(item));
        return convertView;
    }

    private class ViewHolder {
        TextView displayValue;
    }

}
