package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.spinner;

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

    public abstract int getItemPosition(T value);

    public View getDropDownView(int position, View convertView, ViewGroup viewGroup) {
        return createDropdownView(inflater, position, convertView, viewGroup);
    }

}
