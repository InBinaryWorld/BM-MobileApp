package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.edittext;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.LayoutRes;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.BaseFormFragment;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.base.BaseFormRow;

public class EditTextFormRow<T> extends BaseFormRow<T, String, EditTextViewHolder, EditTextFormRowConfig<T>> {

    @LayoutRes
    private final int layoutId = R.layout.row_form_edit_text;

    public EditTextFormRow(LayoutInflater inflater, ViewGroup viewGroup, EditTextFormRowConfig<T> config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected EditTextViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup,
                                                  EditTextFormRowConfig<T> config) {
        View view = inflater.inflate(layoutId, viewGroup, false);
        TextInputLayout textInputLayout = view.findViewById(R.id.til_edit_text_layout);
        TextInputEditText textInputEditText = view.findViewById(R.id.et_form_row);

        EditTextViewHolder holder = new EditTextViewHolder();
        holder.setView(view);
        holder.setTextInputLayout(textInputLayout);
        holder.setTextInputEditText(textInputEditText);

        textInputEditText.setText(config.getInitValue());
        textInputLayout.setHint(config.getLabelText());
        textInputLayout.setEnabled(config.isEnabled());
        textInputEditText.addTextChangedListener(new AfterTextChangeListener() {
            @Override
            public void afterTextChanged(Editable editable) {
                setError(!isValid());
            }
        });
        return holder;
    }

    @Override
    protected String getOriginalValue() {
        EditTextViewHolder holder = getViewHolder();
        EditText view = holder.getTextInputEditText();
        return view.getText().toString();
    }

    @Override
    protected boolean isEnabled() {
        EditTextViewHolder holder = getViewHolder();
        TextInputLayout layout = holder.getTextInputLayout();
        return layout.isEnabled();
    }

    @Override
    protected void setEnabled(boolean enabled) {
        EditTextViewHolder holder = getViewHolder();
        TextInputLayout layout = holder.getTextInputLayout();
        layout.setEndIconVisible(enabled);
        layout.setEnabled(enabled);
    }

    protected void setError(boolean enabled) {
        EditTextViewHolder holder = getViewHolder();
        TextInputLayout layout = holder.getTextInputLayout();
        String err = enabled ? getConfig().getInvalidMessage() : null;
        layout.setErrorEnabled(enabled);
        layout.setError(err);
    }

    @Override
    public void setOnValueChange(BaseFormFragment.Callback onValueChange) {
        EditTextViewHolder holder = getViewHolder();
        EditText inputEditText = holder.getTextInputEditText();
        inputEditText.addTextChangedListener(new AfterTextChangeListener() {
            @Override
            public void afterTextChanged(Editable editable) {
                onValueChange.call();
            }
        });

    }

    private abstract static class AfterTextChangeListener implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }
    }
}
