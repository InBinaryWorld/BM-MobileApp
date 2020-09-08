package dev.szafraniak.bm_mobileapp.presentation.shared.details.row.textview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.details.row.BaseDetailsRow;

public class SimpleTextViewDetailsRow<T> extends BaseDetailsRow<T, String, SimpleTextViewHolder, SimpleTextViewDetailsRowConfig<T>> {

    @LayoutRes
    private final int layoutId = R.layout.row_details_simple_text_view;

    public SimpleTextViewDetailsRow(LayoutInflater inflater, ViewGroup viewGroup, SimpleTextViewDetailsRowConfig<T> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected void setValue(String value) {
        SimpleTextViewHolder holder = getViewHolder();
        TextView valueTv = holder.getValue();
        valueTv.setText(value);
    }

    @Override
    protected SimpleTextViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup,
                                                    SimpleTextViewDetailsRowConfig<T> config) {
        View view = inflater.inflate(layoutId, viewGroup, false);
        TextView label = view.findViewById(R.id.tv_label);
        TextView value = view.findViewById(R.id.tv_value);

        SimpleTextViewHolder holder = new SimpleTextViewHolder();
        holder.setView(view);
        holder.setLabel(label);
        holder.setValue(value);

        label.setText(config.getLabel());
        return holder;
    }


}
