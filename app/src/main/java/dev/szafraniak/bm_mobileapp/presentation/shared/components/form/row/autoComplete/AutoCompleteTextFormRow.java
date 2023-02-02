package dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.autoComplete;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.components.form.row.text.TextForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.utils.ViewUtils;

public abstract class AutoCompleteTextFormRow<T, P, C extends AutoCompleteTextFormConfig<T, P>>
    extends TextForm<T, AutoCompleteTextViewViewHolder, C, MaterialAutoCompleteTextView> {

    @LayoutRes
    protected int getLayoutId() {
        return R.layout.row_form_auto_complete_text_view;
    }

    public AutoCompleteTextFormRow(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        super(inflater, viewGroup, config);
    }

    protected abstract BaseAutoCompleteListAdapter<P> createAdapter(LayoutInflater inflater, C config);

    @Override
    protected void setupView(LayoutInflater inflater, C config) {
        super.setupView(inflater, config);
        AutoCompleteTextViewViewHolder holder = getViewHolder();
        holder.editText.setAdapter(createAdapter(inflater, config));
        holder.editText.setAdapter(createAdapter(inflater, config));
        addOnItemSelected(this::viewOnItemSelected);
    }

    public void addOnItemSelected(ViewUtils.OnNewValue<P> onNewValue) {
        AutoCompleteTextViewViewHolder holder = getViewHolder();
        ViewUtils.addOnItemSelectedListener(holder.editText, onNewValue);
    }

    private void viewOnItemSelected(P item) {
        //TODO: analize do we need ui changes
    }

    @Override
    protected AutoCompleteTextViewViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        AutoCompleteTextViewViewHolder holder = new AutoCompleteTextViewViewHolder();
        holder.view = inflater.inflate(getLayoutId(), viewGroup, false);
        holder.editText = holder.view.findViewById(R.id.mactv_auto_complete_text_view);
        holder.layout = holder.view.findViewById(R.id.til_text_layout);
        return holder;
    }

    @Override
    protected void updateView(boolean isValid) {
        AutoCompleteTextViewViewHolder holder = getViewHolder();
        String err = isValid ? null : getConfig().getInvalidMessage();
        holder.layout.setErrorEnabled(!isValid);
        holder.layout.setError(err);
    }

}
