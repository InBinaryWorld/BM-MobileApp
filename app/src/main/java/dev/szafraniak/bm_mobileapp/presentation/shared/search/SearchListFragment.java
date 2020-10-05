package dev.szafraniak.bm_mobileapp.presentation.shared.search;

import android.widget.SearchView;

import androidx.annotation.IdRes;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.list.BaseListFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.utils.ViewUtils;

@EFragment
public abstract class SearchListFragment<T extends FilterValue> extends BaseListFragment<T, BaseFilterListAdapter<T, T>> {

    SearchView searchView;

    @IdRes
    protected int getSearchViewId() {
        return R.id.sv_search;
    }

    @AfterViews
    public void initializeSearchList() {
        searchView = (SearchView) findViewById(getSearchViewId());
        ViewUtils.addOnQueryListener(searchView, s -> adapter.getFilter().filter(s));
    }

}
