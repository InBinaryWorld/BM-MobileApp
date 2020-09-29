package dev.szafraniak.bm_mobileapp.presentation.shared.load;

import android.view.View;

import androidx.annotation.IdRes;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.BaseSRLFragment;

@EFragment
public abstract class BaseSRLLoadFragment extends BaseSRLFragment {

    protected View progressBar;

    protected View errorView;

    protected View dataContainerView;

    @IdRes
    protected int getErrorViewId() {
        return R.id.error;
    }

    @IdRes
    protected int getProgressBarViewId() {
        return R.id.progress_bar;
    }

    @IdRes
    protected int getDataContainerId() {
        return R.id.ll_data_container;
    }

    @Override
    public void onStart() {
        super.onStart();
        firstLoadData();
    }

    @AfterViews
    public void initializeBaseSRLLoadFragment() {
        errorView = findViewById(getErrorViewId());
        progressBar = findViewById(getProgressBarViewId());
        dataContainerView = findViewById(getDataContainerId());
    }

    protected void firstLoadData() {
        showFirstProgress();
        loadData();
    }

    /**
     * loadData method should invoke process that ends
     * with calling showError or showData methods
     * ex. loadData() -> fetch data form api -> fulfill views -> invoke showData()
     */
    protected abstract void loadData();

    protected void showFirstProgress() {
        errorView.setVisibility(View.GONE);
        dataContainerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        setRefreshEnabled(false);
    }

    protected void showError() {
        progressBar.setVisibility(View.GONE);
        dataContainerView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        setRefreshEnabled(true);
        hideSRLRefreshing();
    }

    protected void showData() {
        errorView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        dataContainerView.setVisibility(View.VISIBLE);
        setRefreshEnabled(true);
        hideSRLRefreshing();
    }

    protected void viewOnSRLRefresh() {
        errorView.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
        dataContainerView.setVisibility(View.GONE);
    }

    @Override
    public void onRefresh() {
        viewOnSRLRefresh();
        loadData();
    }

}
