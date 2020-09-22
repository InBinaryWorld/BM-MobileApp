package dev.szafraniak.bm_mobileapp.presentation.shared.details;

import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.IdRes;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.config.DetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.DetailsRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.load.BaseSRLLoadFragment;
import timber.log.Timber;

@EFragment
public abstract class BaseDetailsFragment<T> extends BaseSRLLoadFragment implements BaseDetailsView<T> {

    protected LinearLayout layout;
    protected LayoutInflater inflater;
    protected DetailsConfig<T> detailsConfig;

    @Override
    protected int getDataContainerId() {
        return R.id.ll_details;
    }

    @IdRes
    protected int getLinearLayoutId() {
        return R.id.ll_details;
    }

    @AfterViews
    public void initializeBaseDetailsFragment() {
        this.inflater = LayoutInflater.from(getContext());
        this.errorView = findViewById(getErrorViewId());
        this.progressBar = findViewById(getProgressBarViewId());
        this.layout = (LinearLayout) findViewById(getLinearLayoutId());
    }


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
