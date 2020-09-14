package dev.szafraniak.bm_mobileapp.presentation.shared.form;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.IdRes;

import org.androidannotations.annotations.EFragment;

import java.util.List;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.BaseHeaderFragment;
import dev.szafraniak.bm_mobileapp.presentation.BaseView;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.config.FormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.progress.BaseProgressRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.FormRowInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.submit.BaseSubmitRow;

@EFragment
public abstract class BaseFormFragment<T> extends BaseHeaderFragment implements BaseView {

    private boolean inProgress;
    private FormConfig<T> formConfig;
    protected LayoutInflater inflater;
    protected LinearLayout layout;

    @IdRes
    protected int getLinearLayoutId() {
        return R.id.ll_form;
    }

    protected abstract FormConfig<T> createFormConfig();

    protected void showProgress() {
        View progressBarView = getFormConfig().getProgressRow().getView();
        View submitButtonView = getFormConfig().getBaseSubmitRow().getView();
        submitButtonView.setVisibility(View.GONE);
        progressBarView.setVisibility(View.VISIBLE);
    }

    protected void hideProgress() {
        View progressBarView = getFormConfig().getProgressRow().getView();
        View submitButtonView = getFormConfig().getBaseSubmitRow().getView();
        submitButtonView.setVisibility(View.VISIBLE);
        progressBarView.setVisibility(View.GONE);
    }

    public void errorToast() {
        Toast.makeText(getContext(), "Action Failed", Toast.LENGTH_SHORT).show();
    }

    protected abstract void onSubmit(T object);

    protected abstract T getFormModel();

    public void initialize() {
        inflater = LayoutInflater.from(getContext());
        layout = (LinearLayout) findViewById(getLinearLayoutId());
        this.prepareView();
    }

    protected FormConfig<T> getFormConfig() {
        if (formConfig == null) {
            formConfig = createFormConfig();
        }
        return formConfig;
    }

    protected void prepareView() {
        FormConfig<T> config = getFormConfig();
        layout.removeAllViews();
        for (FormRowInterface<T> row : config.getRowsConfiguration()) {
            row.setOnChangeWithValidValue(this::onValueChangeProvided);
            layout.addView(row.getView());
        }
        BaseSubmitRow submitRow = config.getBaseSubmitRow();
        submitRow.setOnClickListener(this::onClick);
        layout.addView(submitRow.getView());
        BaseProgressRow progressBarRow = config.getProgressRow();
        layout.addView(progressBarRow.getView());
        onValueChangeProvided();
        hideProgress();
    }

    private void onValueChangeProvided() {
        updateSubmitButton();
    }

    private void updateSubmitButton() {
        FormConfig<T> config = getFormConfig();
        boolean allValid = config.getRowsConfiguration()
                .stream().allMatch(FormRowInterface::isValid);
        this.setSubmitEnabled(allValid && !this.inProgress);
    }

    private void fillModel(T model) {
        FormConfig<T> config = getFormConfig();
        List<FormRowInterface<T>> rows = config.getRowsConfiguration();
        rows.forEach(row -> row.fillModel(model));
    }

    private void startProgress() {
        this.inProgress = true;
        this.showProgress();
        this.setSubmitEnabled(false);
    }

    public void stopProgress() {
        this.inProgress = false;
        this.hideProgress();
        this.updateSubmitButton();
    }

    private void onClick() {
        T formModel = getFormModel();
        this.fillModel(formModel);
        this.startProgress();
        this.onSubmit(formModel);
    }

    private void setSubmitEnabled(boolean enabled) {
        FormConfig<T> config = getFormConfig();
        BaseSubmitRow submitRow = config.getBaseSubmitRow();
        submitRow.setSubmitEnabled(enabled);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        formConfig = null;
    }

    public interface Callback {
        void call();
    }
}
