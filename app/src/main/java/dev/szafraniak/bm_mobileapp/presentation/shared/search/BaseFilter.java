package dev.szafraniak.bm_mobileapp.presentation.shared.search;

import android.widget.Filter;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseFilter<T, R> extends Filter {

    private final BaseFilterListAdapter<T, R> adapter;
    private final List<T> baseItems;

    public BaseFilter(BaseFilterListAdapter<T, R> adapter, List<T> allItems) {
        this.adapter = adapter;
        this.baseItems = allItems;
    }

    protected List<T> filterFunction(List<T> allItemsList, @NonNull String searchText) {
        List<String> keywords = Arrays.asList(searchText.toLowerCase().split(" "));
        return allItemsList.stream().filter(filterValue -> {
            String itemString = adapter.getItemFilterValue(filterValue).toLowerCase();
            return keywords.stream().allMatch(itemString::contains);
        }).collect(Collectors.toList());
    }

    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        boolean isEmpty = charSequence == null || charSequence.toString().isEmpty();
        List<T> items = isEmpty ? baseItems : filterFunction(baseItems, charSequence.toString());
        FilterResults result = new FilterResults();
        result.values = items;
        result.count = items.size();
        return result;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        adapter.setFilteredItems((List<T>) filterResults.values);
    }
}
