package dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.SimpleDetailsConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.base.BaseDetails;

public abstract class TextViewDetails<T, C extends SimpleDetailsConfig<T>> extends BaseDetails<T, TextViewHolder, C> {

    @LayoutRes
    private final int layoutId = R.layout.row_details_text_view;

    public TextViewDetails(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected TextViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        TextViewHolder holder = new TextViewHolder();
        holder.view = inflater.inflate(layoutId, viewGroup, false);
        holder.label = holder.view.findViewById(R.id.tv_label);
        holder.value = holder.view.findViewById(R.id.tv_value);
        return holder;
    }

    protected abstract String parseToDisplay(T value);

    @Override
    protected void showValueOnView(T value) {
        TextViewHolder holder = getViewHolder();
        String text = parseToDisplay(value);
        holder.value.setText(text);
    }

    @Override
    protected void setupView(C config) {
        TextViewHolder holder = getViewHolder();
        holder.label.setText(config.getLabel());
    }


}
