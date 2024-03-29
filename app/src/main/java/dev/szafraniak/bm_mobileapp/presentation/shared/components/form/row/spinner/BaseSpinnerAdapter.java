package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.spinner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListAdapter;

public abstract class BaseSpinnerAdapter<T, R> extends BaseListAdapter<T, R> {

    public BaseSpinnerAdapter(LayoutInflater inflater, List<T> list) {
        super(inflater, list);
    }

    protected abstract View createDropdownView(LayoutInflater inflater, int position, View convertView, ViewGroup viewGroup);

    public int getItemPosition(T value) {
        return items.indexOf(value);
    }

    public int getPositionById(Long id) {
        int position = -1;
        for (T item : items) {
            position = position + 1;
            if (getItemId(item) == id) {
                return position;
            }
        }
        return -1;
    }

    public View getDropDownView(int position, View convertView, ViewGroup viewGroup) {
        return createDropdownView(inflater, position, convertView, viewGroup);
    }


}
