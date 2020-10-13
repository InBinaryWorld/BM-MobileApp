package dev.szafraniak.bm_mobileapp.presentation.shared.scanner;

import com.google.android.gms.vision.barcode.Barcode;

public interface BarcodeCallback {
    void onBarcode(Barcode barcode);
}
