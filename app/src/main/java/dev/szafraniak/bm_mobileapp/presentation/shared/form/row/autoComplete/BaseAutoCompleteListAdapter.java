package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.autoComplete;

import android.view.LayoutInflater;

import java.util.List;

import dev.szafraniak.bm_mobileapp.presentation.shared.search.BaseFilterListAdapter;

public abstract class BaseAutoCompleteListAdapter<T> extends BaseFilterListAdapter<T, String> {
    public BaseAutoCompleteListAdapter(LayoutInflater inflater, List<T> initialList) {
        super(inflater, initialList);
    }

}