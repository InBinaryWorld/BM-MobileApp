package dev.szafraniak.bm_mobileapp.presentation.shared.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T> extends ArrayAdapter<T> {

    @LayoutRes
    protected int resourceId;
    protected List<T> allItems;
    protected List<T> filteredItems;
    protected LayoutInflater inflater;
    protected Filter filter;

    public BaseAdapter(Context context, @LayoutRes int res) {
        this(context, res, new ArrayList<>());
        inflater = LayoutInflater.from(context);
        resourceId = res;
    }

    public BaseAdapter(Context context, @LayoutRes int res, List<T> list) {
        super(context, res, list);
        this.allItems = list;
        this.filteredItems = list;
    }

    public void setAllItems(List<T> list) {
        this.filter = null;
        this.allItems = list;
        this.filteredItems = list;
        notifyDataSetChanged();
    }

    protected abstract View createView(int position, View convertView, ViewGroup parent);

    @Override
    public T getItem(int position) {
        return filteredItems.get(position);
    }

    @Override
    public int getCount() {
        return filteredItems.size();
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

    @NonNull
    @Override
    public Filter getFilter() {
        if (this.filter == null) {
            this.filter = createFilter();
        }
        return this.filter;
    }


    protected Filter createFilter() {
        return new BaseFilter();
    }

    protected List<T> filteringFunction(List<T> allItemsList, String searchText) {
        return new ArrayList<T>(allItemsList);
    }


    class BaseFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();

            if (charSequence != null && charSequence.length() > 0) {
                String searchText = charSequence.toString();
                List<T> filteredList = filteringFunction(allItems, searchText);
                results.count = filteredList.size();
                results.values = filteredList;
            } else {
                results.count = allItems.size();
                results.values = allItems;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            filteredItems = (List<T>) results.values;
            notifyDataSetChanged();
        }
    }

}
