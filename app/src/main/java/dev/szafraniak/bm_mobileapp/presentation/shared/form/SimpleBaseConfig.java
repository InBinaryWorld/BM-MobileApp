package dev.szafraniak.bm_mobileapp.presentation.shared.form;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.progress.BaseProgressRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.progress.SimpleProgressFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.submit.BaseSubmitRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.submit.FormSubmitRowConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.submit.SimpleSubmitFormRow;

public abstract class SimpleBaseConfig<T> extends FormConfig<T> {

    protected final LayoutInflater inflater;
    protected final ViewGroup viewGroup;

    public SimpleBaseConfig(LayoutInflater inflater, ViewGroup viewGroup) {
        this.inflater = inflater;
        this.viewGroup = viewGroup;
    }

    protected abstract String getSubmitButtonText();

    @Override
    public BaseSubmitRow createSubmitRow() {
        FormSubmitRowConfig submitConfig = prepareSubmitConfig();
        return new SimpleSubmitFormRow(inflater, viewGroup, submitConfig);
    }

    private FormSubmitRowConfig prepareSubmitConfig() {
        FormSubmitRowConfig config = new FormSubmitRowConfig();
        config.setSubmitText(getSubmitButtonText());
        return config;
    }

    @Override
    protected BaseProgressRow createProgressRow() {
        return new SimpleProgressFormRow(inflater, viewGroup);
    }

}
