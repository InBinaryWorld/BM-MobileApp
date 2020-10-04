package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;

import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.labeled.LabelFormRow;
import dev.szafraniak.bm_mobileapp.presentation.shared.utils.ViewUtils;

public abstract class TextForm<T, H extends TextFormViewHolder<E>, C extends TextFormConfig<T>, E extends EditText> extends LabelFormRow<T, H, C> {


    public TextForm(LayoutInflater inflater, ViewGroup viewGroup, C config) {
        super(inflater, viewGroup, config);
    }

    protected abstract T parseInput(String inputValue);

    protected abstract String parseToDisplay(T value);

    @Override
    public T getValue() {
        H holder = getViewHolder();
        EditText view = holder.getEditText();
        String textValue = view.getText().toString();
        return parseInput(textValue);
    }

    @Override
    protected void showValueOnView(T value) {
        H holder = getViewHolder();
        String text = parseToDisplay(value);
        holder.editText.setText(text);
    }

    @Override
    protected void setupView(LayoutInflater inflater, C config) {
        H holder = getViewHolder();
        holder.editText.setInputType(config.getInputType());
        ViewUtils.addOnTextChangeListener(holder.editText, this::onValueChange);
    }

    @Override
    protected void setLabel(String label) {
        H holder = getViewHolder();
        holder.layout.setHint(label);
    }

    @Override
    protected void updateView(boolean isValid) {
        H holder = getViewHolder();
        String err = isValid ? null : getConfig().getInvalidMessage();
        holder.layout.setErrorEnabled(!isValid);
        holder.layout.setError(err);
    }

}
