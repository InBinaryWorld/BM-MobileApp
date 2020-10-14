package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.shared.utils.ViewUtils;

public abstract class BaseListFormAdapter<T> extends BaseAdapter {

    protected List<T> items;

    protected LayoutInflater inflater;

    private List<ViewUtils.OnChange> listeners = new ArrayList<>();


    public BaseListFormAdapter(LayoutInflater inflater, List<T> initialList) {
        this.inflater = inflater;
        items = initialList;
    }

    protected void removeItem(T item) {
        items.remove(item);
        onListChange();
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
        onListChange();
    }

    protected void onListChange() {
        notifyDataSetChanged();
        listeners.forEach(ViewUtils.OnChange::onChange);
    }

    public void addOnListChangeListener(ViewUtils.OnChange onChange) {
        listeners.add(onChange);
    }

    protected abstract View createView(LayoutInflater inflater, int position, View convertView, ViewGroup parent);

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public T getItem(int position) {
        return items.get(position);
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
