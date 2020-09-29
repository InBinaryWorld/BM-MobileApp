package dev.szafraniak.bm_mobileapp.presentation.shared.form.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.FormInterface;
import dev.szafraniak.bm_mobileapp.presentation.shared.load.BaseSRLLoadFragment;
import timber.log.Timber;

@EFragment
public abstract class BaseFormFragment<T, C> extends BaseSRLLoadFragment implements BaseFormView {

    protected View button;
    protected View buttonProgress;
    protected LinearLayout formLayout;
    protected FormInterface<T> formComponent;

    @Override
    protected int getDataContainerId() {
        return R.id.ll_form;
    }

    @IdRes
    protected int getFormLayoutId() {
        return R.id.ll_form;
    }

    @IdRes
    protected int getButtonId() {
        return R.id.flb_form_button;
    }

    @IdRes
    protected int getButtonProgressBarId() {
        return R.id.v_button_progress;
    }

    @StringRes
    protected abstract int getButtonTextId();

    @AfterViews
    public void initializeBaseFormFragment() {
        buttonProgress = findViewById(getButtonProgressBarId());
        formLayout = (LinearLayout) findViewById(getFormLayoutId());
        button = findViewById(getButtonId());
        button.setOnClickListener(this::onButtonClick);
        button.setEnabled(false);
    }

    protected void startForm(C config) {
        formComponent = buildForm(config);
        formLayout.removeAllViews();
        formLayout.addView(formComponent.getView());
        onFormStateChange(formComponent.isValid());
        showData();
    }

    protected void startForm(C config, T modifyValue) {
        formComponent = buildForm(config);
        formComponent.setValue(modifyValue);
        formLayout.removeAllViews();
        formLayout.addView(formComponent.getView());
        onFormStateChange(formComponent.isValid());
        showData();
    }

    private FormInterface<T> buildForm(C config) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        FormInterface<T> form = createForm(inflater, formLayout, config);
        form.setOnValidationStateChanged(this::onFormStateChange);
        return form;
    }

    public void setError(Throwable e) {
        Timber.e(e);
        showError();
    }

    protected abstract FormInterface<T> createForm(LayoutInflater inflater, LinearLayout linearLayout, C config);

    protected void onFormStateChange(boolean isValid) {
        button.setEnabled(isValid);
    }

    protected abstract void onSubmit(T object);

    private void onButtonClick(View view) {
        this.startButtonProgress();
        T formModel = formComponent.getValue();
        this.onSubmit(formModel);
    }

    private void startButtonProgress() {
        button.setVisibility(View.GONE);
        buttonProgress.setVisibility(View.VISIBLE);
    }

    protected void hideButtonProgress() {
        button.setVisibility(View.VISIBLE);
        buttonProgress.setVisibility(View.GONE);
    }

    @Override
    public void setActionFailed(Throwable e) {
        Timber.e(e);
        errorToast();
        hideButtonProgress();
    }

    @Override
    public void setActionSucceed() {
        hideButtonProgress();
    }

    public void errorToast() {
        Toast.makeText(getContext(), "Action Failed", Toast.LENGTH_SHORT).show();
    }

}
