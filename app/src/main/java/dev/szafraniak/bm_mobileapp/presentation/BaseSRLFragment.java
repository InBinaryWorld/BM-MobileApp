package dev.szafraniak.bm_mobileapp.presentation;

import androidx.annotation.IdRes;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;

@EFragment
public abstract class BaseSRLFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    protected SwipeRefreshLayout swipeRefreshLayout;

    @IdRes
    public int getSwipeRefreshLayoutId() {
        return R.id.srl_swipe_refresh_layout;
    }

    @AfterViews
    public void initializeBaseSwipeRefreshFragment() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(getSwipeRefreshLayoutId());
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(
                R.color.colorBlueLight,
                R.color.colorBlueDark);
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    protected void setRefreshing(boolean visible) {
        swipeRefreshLayout.setRefreshing(visible);
        swipeRefreshLayout.setEnabled(!visible);
    }

}
