package dev.szafraniak.bm_mobileapp.presentation.shared.details.fragment;

import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.IdRes;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.DetailsInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.load.BaseSRLLoadFragment;
import timber.log.Timber;

@EFragment
public abstract class BaseDetailsFragment<T> extends BaseSRLLoadFragment implements BaseDetailsView<T> {

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
        this.detailsComponent = createForm(inflater, detailsLayout);
        this.detailsLayout.addView(detailsComponent.getView());
    }

    @Override
    public synchronized void setData(T item) {
        detailsComponent.setValue(item);
        showData();
    }

    @Override
    public void setError(Throwable e) {
        Timber.e(e);
        showError();
    }

    protected abstract DetailsInterface<T> createForm(LayoutInflater inflater, LinearLayout linearLayout);

}
