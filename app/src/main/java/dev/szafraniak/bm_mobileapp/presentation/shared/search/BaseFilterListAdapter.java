package dev.szafraniak.bm_mobileapp.presentation.shared.search;

import android.view.LayoutInflater;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListAdapter;

public abstract class BaseFilterListAdapter<T> extends BaseListAdapter<T> implements Filterable {

    private List<T> allItems;

    public BaseFilterListAdapter(LayoutInflater inflater, List<T> initialList) {
        super(inflater, initialList);
        allItems = initialList;
    }

    public void setItems(List<T> list) {
        allItems = list;
        super.setItems(list);
    }

    private void setFilteredItems(List<T> list) {
        super.setItems(list);
    }

    @Override
    public Filter getFilter() {
        return new BaseFilter();
    }

    public void filter(String filterText) {
        getFilter().filter(filterText);
    }

    protected abstract String getItemFilterValue(T item);

    protected List<T> filterFunction(List<T> allItemsList, @NonNull String searchText) {
        List<String> keywords = Arrays.asList(searchText.toLowerCase().split(" "));
        return allItemsList.stream().filter(filterValue -> {
            String itemString = getItemFilterValue(filterValue).toLowerCase();
            return keywords.stream().allMatch(itemString::contains);
        }).collect(Collectors.toList());
    }

    private class BaseFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            boolean isEmpty = charSequence == null || charSequence.toString().isEmpty();
            List<T> items = isEmpty ? allItems : filterFunction(allItems, charSequence.toString());
            FilterResults result = new FilterResults();
            result.values = items;
            result.count = items.size();
            return result;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            setFilteredItems((List<T>) filterResults.values);
        }
    }

}