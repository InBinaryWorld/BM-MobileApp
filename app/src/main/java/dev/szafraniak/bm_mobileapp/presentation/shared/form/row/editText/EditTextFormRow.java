package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.LayoutRes;

import com.google.android.material.textfield.TextInputLayout;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.EditTextViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.utils.ViewUtils;

public abstract class EditTextFormRow<T, C extends EditTextFormConfig<T>> extends BaseFormRow<T, EditTextViewHolder, C> {

    @LayoutRes
    private final static int layoutId = R.layout.row_edit_text;

    public EditTextFormRow(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        super(inflater, viewGroup, config);
    }

    protected abstract T parseInput(String inputValue);

    protected abstract String parseToDisplay(T value);

    @Override
    protected T getValueFromView() {
        EditTextViewHolder holder = getViewHolder();
        EditText view = holder.getEditText();
        String textValue = view.getText().toString();
        return parseInput(textValue);
    }

    @Override
    protected void showValueOnView(T value) {
        EditTextViewHolder holder = getViewHolder();
        String text = parseToDisplay(value);
        holder.editText.setText(text);
    }

    @Override
    protected void disableView() {
        EditTextViewHolder holder = getViewHolder();
        TextInputLayout layout = holder.getLayout();
        layout.setEndIconVisible(false);
        layout.setEnabled(false);
    }

    @Override
    protected void setupView(C config) {
        EditTextViewHolder holder = getViewHolder();
        showValueOnView(config.getInitValue());
        holder.layout.setHint(config.getLabelText());
        ViewUtils.addOnTextChangeListener(holder.editText, this::onValueChange);
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
    protected void onValueChange() {
        super.onValueChange();
        updateView();
    }

    protected void updateView() {
        boolean isValid = isValid();
        EditTextViewHolder holder = getViewHolder();
        String err = isValid ? null : getConfig().getInvalidMessage();
        holder.layout.setErrorEnabled(!isValid);
        holder.layout.setError(err);
    }

}
