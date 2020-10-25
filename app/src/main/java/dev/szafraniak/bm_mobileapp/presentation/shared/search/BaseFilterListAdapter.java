package dev.szafraniak.bm_mobileapp.presentation.shared.search;

import android.view.LayoutInflater;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListAdapter;

public abstract class BaseFilterListAdapter<T, R> extends BaseListAdapter<T, R> implements Filterable {

    private final List<T> allItems = new ArrayList<>();

    private Filter _filter;

    public BaseFilterListAdapter(LayoutInflater inflater, List<T> initialList) {
        super(inflater, initialList);
        allItems.addAll(initialList);
    }

    @Override
    public void setItems(List<T> list) {
        allItems.clear();
        allItems.addAll(list);
        super.setItems(list);
    }

    public void setFilteredItems(List<T> list) {
        super.setItems(list);
    }

    @Override
    public Filter getFilter() {
        if (_filter == null) {
            _filter = new BaseFilter<>(this, allItems);
        }
        return _filter;
    }

    public abstract String getItemFilterValue(T item);

}