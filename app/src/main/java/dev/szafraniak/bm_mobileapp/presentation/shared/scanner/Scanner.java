package dev.szafraniak.bm_mobileapp.presentation.shared.scanner;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.view.SurfaceView;
import android.view.View;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.util.ArrayList;
import java.util.List;

public class Scanner {

    private static final int PERMISSION_REQUEST_CAMERA = 12344321;

    private Activity activity;
    private SurfaceView surfaceView;
    private List<BarcodeCallback> listeners;
    private int height = 1024;
    private int width = 1024;


    public Scanner(Activity activity, SurfaceView surfaceView) {
        this.activity = activity;
        this.surfaceView = surfaceView;
        this.listeners = new ArrayList<>();
        this.surfaceView.setVisibility(View.GONE);
        this.surfaceView.getHolder().addCallback(new SurfaceCallback(this));
    }

    public void addBarcodeListener(BarcodeCallback listener) {
        listeners.add(listener);
    }

    private boolean checkPermission() {
        int state = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA);
        return state == PackageManager.PERMISSION_GRANTED;
    }

    private void setPreviewDimensions(int height, int width) {
        this.height = height;
        this.width = width;

    }

    private void requestPermission() {
        String[] permissions = new String[]{Manifest.permission.CAMERA};
        ActivityCompat.requestPermissions(activity, permissions, PERMISSION_REQUEST_CAMERA);
    }

    public void onPermissionGranted(int code) {
        if (code == PERMISSION_REQUEST_CAMERA) {
            showCamera();
        }
    }

    public void startScanning() {
        if (!checkPermission()) {
            requestPermission();
            return;
        }
        showCamera();
    }

    private void showCamera() {
        surfaceView.setVisibility(View.VISIBLE);
    }

    public void hideCamera() {
        surfaceView.setVisibility(View.GONE);
    }

    private void setResult(Barcode barcode) {
        surfaceView.setVisibility(View.GONE);
        listeners.forEach(listener -> listener.onBarcode(barcode));
    }

    private BarcodeDetector createBarcodeDetector() {
        BarcodeDetector detector = new BarcodeDetector.Builder(activity).build();
        detector.setProcessor(new ScannerProcessor(this::setResult));
        return detector;
    }

    CameraSource createCameraSource() {
        BarcodeDetector detector = createBarcodeDetector();
        return new CameraSource.Builder(activity, detector)
            .setRequestedPreviewSize(height, width)
            .setAutoFocusEnabled(true).build();
    }

}
