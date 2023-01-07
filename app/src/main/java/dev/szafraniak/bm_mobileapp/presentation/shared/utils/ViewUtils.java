package dev.szafraniak.bm_mobileapp.presentation.shared.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Spinner;

import com.google.android.material.switchmaterial.SwitchMaterial;

import dev.szafraniak.bm_mobileapp.presentation.shared.search.ExtendedBaseAdapter;

public class ViewUtils {

    public static <T> void addOnItemSelectedListener(Spinner spinner, OnNewValue<T> onNewValue) {
        spinner.setOnItemSelectedListener(getOnItemSelectedListener(onNewValue, true));
    }

    public static <T> void addOnItemSelectedListener(Spinner spinner, OnChange onChange) {
        spinner.setOnItemSelectedListener(getOnItemSelectedListener((item) -> onChange.onChange(), true));
    }

    public static <T> void addOnItemSelectedListener(AutoCompleteTextView autoCompleteTextView, OnNewValue<T> onNewValue) {
        autoCompleteTextView.setOnItemClickListener(getOnItemClickListener(onNewValue));
    }

    public static <T> void addOnItemSelectedListener(AutoCompleteTextView autoCompleteTextView, OnChange onChange) {
        autoCompleteTextView.setOnItemClickListener(getOnItemClickListener((item) -> onChange.onChange()));
    }

    public static void addOnTextChangeListener(EditText editText, OnNewValue<String> onNewValue) {
        editText.addTextChangedListener(getTextWatcher(onNewValue));
    }

    public static void addOnTextChangeListener(EditText editText, OnChange onTextChange) {
        ViewUtils.addOnTextChangeListener(editText, (text) -> onTextChange.onChange());
    }

    public static void addOnToggleChangeListener(SwitchMaterial toggle, OnNewValue<Boolean> onNewValue) {
        toggle.setOnCheckedChangeListener((toggleBtn, value) -> onNewValue.onNewValue(value));
    }

    public static void addOnToggleChangeListener(SwitchMaterial toggle, OnChange onToggleChange) {
        ViewUtils.addOnToggleChangeListener(toggle, (value) -> onToggleChange.onChange());
    }

    public static void addOnQueryListener(SearchView editText, OnQuery onQuery) {
        editText.setOnQueryTextListener(getOnQueryListener(onQuery));
    }

    private static SearchView.OnQueryTextListener getOnQueryListener(OnQuery onQuery) {
        return new SearchView.OnQueryTextListener() {
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            public boolean onQueryTextChange(String newText) {
                onQuery.execute(newText);
                return false;
            }
        };
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


    private static <T, R> AdapterView.OnItemClickListener getOnItemClickListener(OnNewValue<T> onNewValue) {
        return (adapterView, view, i, l) -> {
            Adapter adapter = adapterView.getAdapter();
            if (adapter instanceof ExtendedBaseAdapter) {
                onNewValue.onNewValue((T) ((ExtendedBaseAdapter<T, R>) adapterView.getAdapter()).getWholeItem(i));
            } else {
                onNewValue.onNewValue((T) adapterView.getAdapter().getItem(i));
            }
        };
    }

    public interface OnQuery {
        void execute(String query);
    }

    public interface OnNewValue<T> {
        void onNewValue(T newValue);
    }

    public interface OnChange {
        void onChange();
    }

}
