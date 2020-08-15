package dev.szafraniak.bm_mobileapp.presentation.shared.form.submit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;
import lombok.Data;
import lombok.Getter;

public class SimpleSubmitFormRow implements BaseSubmitRow {

    @Getter
    private final ViewHolder viewHolder;
    private final FormSubmitRowConfig config;

    @LayoutRes
    private final int layoutId = R.layout.row_form_submit_simple;

    public SimpleSubmitFormRow(LayoutInflater inflater, ViewGroup viewGroup, FormSubmitRowConfig config) {
        viewHolder = createViewHolder(inflater, viewGroup, config);
        this.config = config;
    }

    private ViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, FormSubmitRowConfig config) {
        View view = inflater.inflate(layoutId, viewGroup, false);
        Button button = view.findViewById(R.id.btn_submit);

        ViewHolder holder = new ViewHolder();
        holder.setButton(button);
        holder.setView(view);

        button.setText(config.getSubmitText());
        return holder;
    }

    @Override
    public void setSubmitEnabled(boolean enabled) {
        viewHolder.getButton().setEnabled(enabled);
    }

    public View getView() {
        return viewHolder.getView();
    }

    @Override
    public void setOnClickListener(BaseFormFragment.Callback onClick) {
        Button button = viewHolder.getButton();
        button.setOnClickListener(view -> onClick.call());
    }


    @Data
    private static class ViewHolder {
        private View view;
        private Button button;
    }

}
