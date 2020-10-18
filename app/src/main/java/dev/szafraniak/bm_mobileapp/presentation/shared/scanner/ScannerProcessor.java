package dev.szafraniak.bm_mobileapp.presentation.shared.scanner;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;

class ScannerProcessor implements Detector.Processor<Barcode> {
    private final BarcodeCallback barcodeCallback;
    private boolean hasFirstResult = false;

    public ScannerProcessor(BarcodeCallback barcodeCallback) {
        this.barcodeCallback = barcodeCallback;
    }

    @Override
    public void release() {
    }

    @Override
    public void receiveDetections(Detector.Detections<Barcode> detections) {
        if (detections != null && detections.getDetectedItems().size() > 0 & !hasFirstResult) {
            hasFirstResult = true;
            SparseArray<Barcode> codes = detections.getDetectedItems();
            Barcode code = codes.valueAt(0);
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(() -> barcodeCallback.onBarcode(code));
        }
    }
}
