package dev.szafraniak.bm_mobileapp.presentation.shared.list;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.IdRes;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.BMCollection;
import dev.szafraniak.bm_mobileapp.presentation.BaseSRLFragment;
import timber.log.Timber;

@EFragment
public abstract class BaseListFragment<T> extends BaseSRLFragment implements BaseListView<T>, AdapterView.OnItemClickListener {

    private View progressBar;

    protected View errorView;

    protected ListView listView;

    protected BaseAdapter<T> adapter;

    @IdRes
    protected int getListViewId() {
        return R.id.list;
    }

    @IdRes
    protected int getErrorViewId() {
        return R.id.error;
    }

    @IdRes
    protected int getProgressBarViewId() {
        return R.id.progress_bar;
    }

    @AfterViews
    public void initializeBaseListFragment() {
        listView = (ListView) findViewById(getListViewId());
        errorView = findViewById(getErrorViewId());
        progressBar = findViewById(getProgressBarViewId());
        listView.setOnItemClickListener(this);

        adapter = createAdapter();
        listView.setAdapter(adapter);
    }

    protected abstract void loadData();

    public abstract void onItemClick(T item);

    protected abstract BaseAdapter<T> createAdapter();

    private void clearList() {
        adapter.setItems(new ArrayList<>());
    }

    @Override
    public synchronized void setData(BMCollection<T> collection) {
        setData(collection.getItems());
    }

    @Override
    public synchronized void setData(List<T> items) {
        adapter.setItems(items);
        showData();
    }

    @Override
    public void setError(Throwable e) {
        Timber.e(e);
        showError();
    }

    protected void showFirstProgress() {
        listView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        setRefreshEnabled(false);
    }

    protected void showError() {
        listView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        setRefreshEnabled(true);
        setRefreshing(false);
    }

    protected void showData() {
        listView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        setRefreshEnabled(true);
        setRefreshing(false);
    }

    protected void viewOnRefresh() {
        listView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        clearList();
    }

    @Override
    public void onRefresh() {
        viewOnRefresh();
        loadData();
    }

    protected void firstLoadData() {
        showFirstProgress();
        loadData();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        T item = adapter.getItem(position);
        onItemClick(item);
    }

}