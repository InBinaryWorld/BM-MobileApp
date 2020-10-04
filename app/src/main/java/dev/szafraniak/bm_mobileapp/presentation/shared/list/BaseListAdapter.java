package dev.szafraniak.bm_mobileapp.presentation.shared.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.shared.search.ExtendedBaseAdapter;

public abstract class BaseListAdapter<T> extends ExtendedBaseAdapter<T> {

    protected List<T> items;
    protected LayoutInflater inflater;

    public BaseListAdapter(LayoutInflater inflater, List<T> initialList) {
        this.inflater = inflater;
        items = initialList;
    }

    protected abstract View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent);

    @Override
    public void setItems(List<T> list) {
        this.items = list;
        notifyDataSetChanged();
    }

    @Override
    public T getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @NonNull
    @Override
    public final View getView(int position, View convertView, @NonNull ViewGroup parent) {
        return createView(inflater, position, convertView, parent);
    }

}
