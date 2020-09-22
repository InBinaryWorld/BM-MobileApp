package dev.szafraniak.bm_mobileapp.presentation.shared.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class ViewUtils {

    public static void addOnTextChangeListener(EditText editText, OnTextChange onTextChange) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                onTextChange.onChange(editText.getText().toString());
            }
        });
    }

    public interface OnTextChange {
        void onChange(String newValue);
    }

}
