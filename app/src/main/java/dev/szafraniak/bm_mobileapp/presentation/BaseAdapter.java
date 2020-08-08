package dev.szafraniak.bm_mobileapp.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T> extends ArrayAdapter<T> {

    @LayoutRes
    protected int resourceId;
    protected List<T> items;
    protected LayoutInflater inflater;

    public BaseAdapter(Context context, @LayoutRes int res) {
        this(context, res, new ArrayList<>());
        inflater = LayoutInflater.from(context);
        resourceId = res;
    }

    public BaseAdapter(Context context, @LayoutRes int res, List<T> list) {
        super(context, res, list);
        this.items = list;
    }

    public void setItems(List<T> list) {
        this.items = list;
        notifyDataSetChanged();
    }

    protected abstract View createView(int position, View convertView, ViewGroup parent);

    @Override
    public T getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    @NonNull
    public final View getView(int position, View convertView, @NonNull ViewGroup parent) {
        return createView(position, convertView, parent);
    }
}
