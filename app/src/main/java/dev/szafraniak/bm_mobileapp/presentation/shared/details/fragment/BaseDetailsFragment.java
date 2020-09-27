package dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment;

import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.IdRes;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.DetailsInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.load.BaseSRLLoadFragment;
import timber.log.Timber;

@EFragment
public abstract class BaseDetailsFragment<T, C extends BaseDetailsConfig<T>> extends BaseSRLLoadFragment implements BaseDetailsView<T> {

    protected LinearLayout detailsLayout;
    protected DetailsInterface<T> detailsComponent;

    @Override
    protected int getDataContainerId() {
        return R.id.ll_details;
    }

    @IdRes
    protected int getDetailsLayoutId() {
        return R.id.ll_details;
    }

    @AfterViews
    public void initializeBaseDetailsFragment() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        this.detailsLayout = (LinearLayout) findViewById(getDetailsLayoutId());
    }

    protected void startForm(C config, T item) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        detailsComponent = createForm(inflater, detailsLayout, config);
        detailsLayout.removeAllViews();
        detailsLayout.addView(detailsComponent.getView());
        detailsComponent.setValue(item);
        showData();
    }

    protected void startForm(C config) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        detailsComponent = createForm(inflater, detailsLayout, config);
        detailsLayout.removeAllViews();
        detailsLayout.addView(detailsComponent.getView());
        showData();
    }

    @Override
    public void setError(Throwable e) {
        Timber.e(e);
        showError();
    }

    protected abstract DetailsInterface<T> createForm(LayoutInflater inflater, LinearLayout linearLayout, C config);

}
