package dev.szafraniak.bm_mobileapp.presentation.shared.details.row.editText;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.EditTextViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetails;

public abstract class EditTextDetails<T, C extends SimpleDetailsConfig<T>> extends BaseDetails<T, EditTextViewHolder, C> {

    @LayoutRes
    private final int layoutId = R.layout.row_edit_text;

    public EditTextDetails(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        super(inflater, viewGroup, config);
    }

    protected abstract String parseToDisplay(T value);

    @Override
    protected void showValueOnView(T value) {
        EditTextViewHolder holder = getViewHolder();
        String text = parseToDisplay(value);
        holder.editText.setText(text);
    }

    @Override
    protected EditTextViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        EditTextViewHolder holder = new EditTextViewHolder();
        holder.view = inflater.inflate(layoutId, viewGroup, false);
        holder.layout = holder.view.findViewById(R.id.til_edit_text);
        holder.editText = holder.view.findViewById(R.id.et_edit_text);
        return holder;
    }

    @Override
    protected void setupView(C config) {
        EditTextViewHolder holder = getViewHolder();
        holder.layout.setHint(config.getLabel());
        holder.layout.setEndIconVisible(false);
        holder.layout.setEnabled(false);

        showValueOnView(config.getInitValue());
    }

}
