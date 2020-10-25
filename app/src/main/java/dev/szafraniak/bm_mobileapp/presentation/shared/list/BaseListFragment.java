package dev.szafraniak.bm_mobileapp.presentation.shared.list;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.IdRes;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.business.models.mics.BMCollection;
import dev.szafraniak.bm_mobileapp.presentation.shared.load.BaseSRLLoadFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.search.ExtendedBaseAdapter;
import timber.log.Timber;

@EFragment
public abstract class BaseListFragment<T, A extends ExtendedBaseAdapter<T, T>> extends BaseSRLLoadFragment
    implements BaseListView<T>, AdapterView.OnItemClickListener {

    protected View emptyListView;

    protected ListView listView;

    protected A adapter;

    @IdRes
    protected int getListViewId() {
        return R.id.list;
    }

    @IdRes
    protected int getEmptyViewId() {
        return R.id.empty_list;
    }

    @AfterViews
    public void initializeBaseListFragment() {
        emptyListView = findViewById(getEmptyViewId());
        listView = (ListView) findViewById(getListViewId());

        adapter = createAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    protected abstract void loadData();

    public abstract void onItemClick(T item);

    protected abstract A createAdapter();

    @Override
    public synchronized void setData(BMCollection<T> collection) {
        setData(collection.getItems());
    }

    @Override
    public synchronized void setData(List<T> items) {
        adapter.setItems(items);
        if (items.size() == 0) {
            showEmptyList();
            return;
        }
        showData();
    }

    @Override
    public void setError(Throwable e) {
        Timber.e(e);
        showError();
    }

    protected void showEmptyList() {
        listView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        emptyListView.setVisibility(View.VISIBLE);
        dataContainerView.setVisibility(View.VISIBLE);
        setRefreshEnabled(true);
        hideSRLRefreshing();
    }

    @Override
    protected void showData() {
        super.showData();
        emptyListView.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void viewOnSRLRefresh() {
        super.viewOnSRLRefresh();
        listView.setVisibility(View.GONE);
        emptyListView.setVisibility(View.GONE);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        T item = adapter.getItem(position);
        onItemClick(item);
    }

}
