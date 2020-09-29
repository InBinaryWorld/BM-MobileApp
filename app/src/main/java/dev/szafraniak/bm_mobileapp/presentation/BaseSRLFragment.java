package dev.szafraniak.bm_mobileapp.presentation;

import androidx.annotation.IdRes;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;

@EFragment
public abstract class BaseSRLFragment extends BaseHeaderFragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;

    private boolean permanentDisabled = false;

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
                R.color.colorCoral,
                R.color.colorBlueDark);
    }

    protected void hideSRLRefreshing() {
        swipeRefreshLayout.setRefreshing(false);
    }

    protected void setRefreshEnabled(boolean enabled) {
        if (!permanentDisabled) {
            swipeRefreshLayout.setEnabled(enabled);
        }
    }

    protected void setRefreshPermanentDisabled() {
        permanentDisabled = true;
        swipeRefreshLayout.setEnabled(false);
    }

}
