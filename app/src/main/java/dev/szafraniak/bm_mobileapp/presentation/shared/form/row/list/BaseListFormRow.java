package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.LayoutRes;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;

public abstract class BaseListFormRow<T> extends BaseFormRow<List<T>, ListFormViewHolder, ListFormRowConfig<T>> implements AdapterView.OnItemClickListener {

    protected BaseListFormAdapter<T> adapter;

    @LayoutRes
    protected int getLayoutId() {
        return R.layout.form_base_list;
    }

    public BaseListFormRow(LayoutInflater inflater, ViewGroup viewGroup, ListFormRowConfig<T> config) {
        super(inflater, viewGroup, config);
    }

    protected abstract BaseListFormAdapter<T> createAdapter(LayoutInflater inflater, ListFormRowConfig<T> config);

    @Override
    public List<T> getValue() {
        return adapter.getItems();
    }

    @Override
    protected void showValueOnView(List<T> value) {
        adapter.setItems(value != null ? value : new ArrayList<>());
    }

    @Override
    protected void setupView(LayoutInflater inflater, ListFormRowConfig<T> config) {
        ListFormViewHolder holder = getViewHolder();
        adapter = createAdapter(inflater, config);
        holder.listView.setAdapter(adapter);
        holder.listView.setOnItemClickListener(this);
        adapter.addOnListChangeListener(this::onValueChange);

    }

    @Override
    protected void updateView(boolean isValid) {
        ListFormViewHolder holder = getViewHolder();
        boolean isEmpty = adapter.getCount() == 0;
        holder.emptyView.setVisibility(isEmpty ? View.VISIBLE : View.GONE);
        holder.listView.setVisibility(!isEmpty ? View.VISIBLE : View.GONE);
    }

    @Override
    protected ListFormViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, ListFormRowConfig<T> config) {
        ListFormViewHolder holder = new ListFormViewHolder();
        holder.view = inflater.inflate(getLayoutId(), viewGroup, false);
        holder.listView = holder.view.findViewById(R.id.list);
        holder.emptyView = holder.view.findViewById(R.id.empty_list);
        return holder;
    }

}
