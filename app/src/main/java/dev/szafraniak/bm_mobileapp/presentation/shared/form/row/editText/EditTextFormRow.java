package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.editText;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.LayoutRes;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.EditTextViewHolder;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.utils.ViewUtils;

public abstract class EditTextFormRow<T, C extends EditTextFormRowConfig<T>> extends BaseFormRow<T, EditTextViewHolder, C> {

    private final static String REQUIRED_HINT_SUFFIX = "*";

    @LayoutRes
    private final static int layoutId = R.layout.row_edit_text;

    public EditTextFormRow(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        super(inflater, viewGroup, config);
    }

    protected abstract T parseInput(String inputValue);

    protected abstract String parseToDisplay(T value);

    @Override
    public T getValue() {
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
    protected void setupView(C config) {
        EditTextViewHolder holder = getViewHolder();
        String suffix = config.isRequired() ? REQUIRED_HINT_SUFFIX : "";
        String hint = String.format("%s%s", config.getLabelText(), suffix);
        holder.layout.setHint(hint);
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
