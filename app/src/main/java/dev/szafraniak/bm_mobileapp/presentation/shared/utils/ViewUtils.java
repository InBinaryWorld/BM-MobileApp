package dev.szafraniak.bm_mobileapp.presentation.shared.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;

public class ViewUtils {

    public static <T> void addOnItemSelectedListener(Spinner spinner, OnNewValue<T> onNewValue) {
        spinner.setOnItemSelectedListener(getOnItemSelectedListener(onNewValue, true));
    }

    public static <T> void addOnItemSelectedListener(Spinner spinner, OnChange onChange) {
        spinner.setOnItemSelectedListener(getOnItemSelectedListener((item) -> onChange.onChange(), true));
    }

    public static <T> void addOnItemSelectedListener(AutoCompleteTextView autoCompleteTextView, OnNewValue<T> onNewValue, boolean emitNull) {
        autoCompleteTextView.setOnItemClickListener(getOnItemClickListener(onNewValue, emitNull));
    }

    public static <T> void addOnItemSelectedListener(AutoCompleteTextView autoCompleteTextView, OnChange onChange, boolean emitNull) {
        autoCompleteTextView.setOnItemClickListener(getOnItemClickListener((item) -> onChange.onChange(), emitNull));
    }

    public static void addOnTextChangeListener(EditText editText, OnNewValue<String> onNewValue) {
        editText.addTextChangedListener(getTextWatcher(onNewValue));
    }

    public static void addOnTextChangeListener(EditText editText, OnChange onTextChange) {
        ViewUtils.addOnTextChangeListener(editText, (text) -> onTextChange.onChange());
    }

    private static TextWatcher getTextWatcher(OnNewValue<String> onNewValue) {
        return new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void afterTextChanged(Editable editable) {
                onNewValue.onNewValue(editable.toString());
            }
        };
    }

    private static <T> AdapterView.OnItemSelectedListener getOnItemSelectedListener(OnNewValue<T> onNewValue, boolean emitNull) {
        return new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                onNewValue.onNewValue((T) adapterView.getAdapter().getItem(i));
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                if (emitNull) {
                    onNewValue.onNewValue(null);
                }
            }
        };
    }


    private static <T> AdapterView.OnItemClickListener getOnItemClickListener(OnNewValue<T> onNewValue, boolean emitNull) {
        return (adapterView, view, i, l) -> onNewValue.onNewValue((T) adapterView.getAdapter().getItem(i));
    }

    public interface OnNewValue<T> {
        void onNewValue(T newValue);
    }

    public interface OnChange {
        void onChange();
    }

}
