package dev.szafraniak.bm_mobileapp.presentation.shared.details;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.IdRes;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.BaseSRLFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.config.DetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.DetailsRowInterface;
import timber.log.Timber;

@EFragment
public abstract class BaseDetailsFragment<T> extends BaseSRLFragment implements BaseDetailsView<T> {

    protected View errorView;
    protected View progressBar;
    protected LinearLayout layout;
    protected LayoutInflater inflater;
    protected DetailsConfig<T> detailsConfig;

    @IdRes
    protected int getLinearLayoutId() {
        return R.id.ll_details;
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
    public void initializeBaseDetailsFragment() {
        this.inflater = LayoutInflater.from(getContext());
        this.errorView = findViewById(getErrorViewId());
        this.progressBar = findViewById(getProgressBarViewId());
        this.layout = (LinearLayout) findViewById(getLinearLayoutId());
    }


    protected void firstLoadData() {
        showFirstProgress();
        loadData();
    }

    protected abstract void loadData();

    @Override
    public synchronized void setData(T item) {
        DetailsConfig<T> config = getFormConfig();
        layout.removeAllViews();
        for (DetailsRowInterface<T> row : config.getRowsConfiguration()) {
            row.setData(item);
            layout.addView(row.getView());
        }
        showData();
    }


    @Override
    public void setError(Throwable e) {
        Timber.e(e);
        showError();
    }

    protected void showFirstProgress() {
        layout.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        setRefreshEnabled(false);
    }

    protected void showError() {
        layout.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        setRefreshEnabled(true);
        setRefreshing(false);
    }

    protected void showData() {
        layout.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        setRefreshEnabled(true);
        setRefreshing(false);
    }

    protected void viewOnRefresh() {
        layout.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onRefresh() {
        viewOnRefresh();
        loadData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        detailsConfig = null;
    }

    protected abstract DetailsConfig<T> createDetailsConfig();

    protected DetailsConfig<T> getFormConfig() {
        if (detailsConfig == null) {
            detailsConfig = createDetailsConfig();
        }
        return detailsConfig;
    }

}
