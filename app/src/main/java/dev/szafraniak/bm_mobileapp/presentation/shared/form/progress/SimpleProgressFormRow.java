package dev.szafraniak.bm_mobileapp.presentation.shared.form.progress;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import lombok.Getter;

public class SimpleProgressFormRow implements BaseProgressRow {

    @Getter
    private View progressView;

    @LayoutRes
    private final int layoutId = R.layout.row_form_progress_simple;

    public SimpleProgressFormRow(LayoutInflater inflater, ViewGroup viewGroup) {
        progressView = createViewHolder(inflater, viewGroup);
    }

    private View createViewHolder(LayoutInflater inflater, ViewGroup viewGroup) {
        return inflater.inflate(layoutId, viewGroup, false);
    }

    public View getView() {
        return progressView;
    }
}
