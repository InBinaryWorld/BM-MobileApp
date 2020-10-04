package dev.szafraniak.bm_mobileapp.presentation.shared.search;

import android.widget.BaseAdapter;

import java.util.List;

public abstract class ExtendedBaseAdapter<T> extends BaseAdapter {

    public abstract void setItems(List<T> list);

    @Override
    public abstract T getItem(int position);

}