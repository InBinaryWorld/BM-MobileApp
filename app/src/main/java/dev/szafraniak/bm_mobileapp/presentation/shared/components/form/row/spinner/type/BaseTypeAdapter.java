package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.spinner.type;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import java.util.HashMap;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.spinner.BaseSpinnerAdapter;

public class BaseTypeAdapter<T> extends BaseSpinnerAdapter<T, T> {

    @LayoutRes
    private static final int layoutId = R.layout.row_spinner_base_preview;
    @LayoutRes
    private static final int dropdownLayoutId = R.layout.row_spinner_base_dropdown;

    private final BaseTypeFormConfig<T> config;

    public BaseTypeAdapter(LayoutInflater inflater, BaseTypeFormConfig<T> config) {
        super(inflater, config.getSpinnerItems());
        this.config = config;
    }

    @Override
    protected T extractGetItemValue(T item) {
        return item;
    }

    @Override
    protected long getItemId(T item) {
        return 0;
    }

    @Override
    protected View createView(LayoutInflater inflater, int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = inflater.inflate(layoutId, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.value = convertView.findViewById(R.id.tv_spinner_value);
            convertView.setTag(viewHolder);
        }
        T item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        HashMap<T, String> displayValues = config.getDisplayValues();
        holder.value.setText(displayValues.get(item));
        return convertView;
    }

    @Override
    protected View createDropdownView(LayoutInflater inflater, int position, View convertView, ViewGroup viewGroup) {
        return createPaymentView(inflater, position, convertView, viewGroup);
    }

    private View createPaymentView(LayoutInflater inflater, int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = inflater.inflate(dropdownLayoutId, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.value = convertView.findViewById(R.id.tv_spinner_value);
            convertView.setTag(viewHolder);
        }
        T item = getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        HashMap<T, String> displayValues = config.getDisplayValues();
        holder.value.setText(displayValues.get(item));
        return convertView;
    }

    private static class ViewHolder {
        TextView value;
    }

}
