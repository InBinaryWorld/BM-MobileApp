package dev.szafraniak.bm_mobileapp.presentation.shared.search;

import android.widget.BaseAdapter;

import java.util.List;

public abstract class ExtendedBaseAdapter<T, R> extends BaseAdapter {

    public abstract void setItems(List<T> list);

    @Override
    public abstract R getItem(int position);

    public abstract T getWholeItem(int position);

    public abstract List<T> getVisibleItems();

}