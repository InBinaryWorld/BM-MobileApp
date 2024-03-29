package dev.szafraniak.bm_mobileapp.presentation.shared.search;

import android.widget.SearchView;

import androidx.annotation.IdRes;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragmentWithBtn;

@EFragment
public abstract class SearchListFragmentWithBtn<T, A extends BaseFilterListAdapter<T, T>> extends BaseListFragmentWithBtn<T, A> {

    protected SearchView searchView;

    @IdRes
    protected int getSearchViewId() {
        return R.id.sv_search;
    }

    @AfterViews
    public void initializeSearchList() {
        searchView = (SearchView) findViewById(getSearchViewId());
        searchView.setOnQueryTextListener(new QueryListener());
    }

    class QueryListener implements SearchView.OnQueryTextListener {

        @Override
        public boolean onQueryTextSubmit(String s) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String s) {
            if (adapter != null) {
                adapter.getFilter().filter(s);
            }
            return false;
        }
    }
}
