package dev.szafraniak.bm_mobileapp.presentation.shared.form.row.barcode;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import com.google.android.material.textfield.TextInputEditText;

import dev.szafraniak.bm_mobileapp.R;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextForm;
import dev.szafraniak.bm_mobileapp.presentation.shared.form.row.text.TextFormConfig;
import dev.szafraniak.bm_mobileapp.presentation.shared.scanner.Scanner;

public class BarcodeFormRow extends TextForm<String, BarcodeFormViewHolder, BarcodeFormConfig, TextInputEditText> {

    @LayoutRes
    private final static int layoutId = R.layout.row_barcode_edit_text;

    public BarcodeFormRow(LayoutInflater inflater, ViewGroup viewGroup, BarcodeFormConfig config) {
        super(inflater, viewGroup, config);
    }

    @Override
    protected BarcodeFormViewHolder createViewHolder(LayoutInflater inflater, ViewGroup viewGroup, BarcodeFormConfig config) {
        BarcodeFormViewHolder holder = new BarcodeFormViewHolder();
        holder.view = inflater.inflate(layoutId, viewGroup, false);
        holder.layout = holder.view.findViewById(R.id.til_text_layout);
        holder.editText = holder.view.findViewById(R.id.et_edit_text);
        holder.scannerView = holder.view.findViewById(R.id.iv_scanner);
        return holder;
    }

    @Override
    protected void setupView(LayoutInflater inflater, BarcodeFormConfig config) {
        super.setupView(inflater, config);
        BarcodeFormViewHolder holder = getViewHolder();
        Scanner scanner = new Scanner(config.getActivity());
        scanner.addBarcodeListener(barcode -> setValue(barcode.displayValue));
        holder.scannerView.setOnClickListener(view -> scanner.openScanner());
    }

    @Override
    protected String parseInput(String inputValue) {
        TextFormConfig<String> config = getConfig();
        if (config.isReadEmptyAsNull() && inputValue.isEmpty()) {
            return null;
        }
        return inputValue;
    }

    @Override
    protected String parseToDisplay(String value) {
        return value;
    }

}
