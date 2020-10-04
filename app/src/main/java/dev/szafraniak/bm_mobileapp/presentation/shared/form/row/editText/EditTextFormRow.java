package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import com.google.android.material.textfield.TextInputEditText;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormViewHolder;

public abstract class EditTextFormRow<T, C extends TextFormConfig<T>> extends TextForm<T, TextFormViewHolder<TextInputEditText>, C, TextInputEditText> {

    @LayoutRes
    private final static int layoutId = R.layout.row_edit_text;

    public EditTextFormRow(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected TextFormViewHolder<TextInputEditText> createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        TextFormViewHolder<TextInputEditText> holder = new TextFormViewHolder<>();
        holder.view = inflater.inflate(layoutId, viewGroup, false);
        holder.layout = holder.view.findViewById(R.id.til_edit_text);
        holder.editText = holder.view.findViewById(R.id.et_edit_text);
        return holder;
    }

}
