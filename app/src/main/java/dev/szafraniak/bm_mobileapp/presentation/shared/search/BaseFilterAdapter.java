package dev.szafraniak.bm_mobileapp.presentation.shared.search;

import android.content.Context;

import androidx.annotation.LayoutRes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseAdapter;

public abstract class BaseFilterAdapter<T extends FilterValue> extends BaseAdapter<T> {

    public BaseFilterAdapter(Context context, @LayoutRes int res) {
        super(context, res);
    }

    @Override
    protected List<T> filteringFunction(List<T> allItemsList, String searchText) {
        List<String> keywords = Arrays.asList(searchText.toLowerCase().split(" "));
        List<T> list = new ArrayList<>();
        for (T filterValue : allItemsList) {
            String itemString = filterValue.getDescriptionForFilter();
            if (keywords.stream().allMatch(itemString::contains)) {
                list.add(filterValue);
            }
        }
        return list;
    }
}