package dev.szafraniak.bm_mobileapp.presentation.shared.scanner;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.util.ArrayList;
import java.util.List;

import dev.szafraniak.bm_mobileapp.R;

import static dev.szafraniak.bm_mobileapp.business.Constance.ACTIVITY_RESULT_CAMERA;

public class ScannerDialog {

    @LayoutRes
    private final static int layoutId = R.layout.dialog_scanner;

    private final int sourceWidth = 1024;
    private final int sourceHeight = 1024;

    private final Activity activity;
    private final List<BarcodeCallback> listeners;


    public ScannerDialog(Activity activity) {
        this.activity = activity;
        this.listeners = new ArrayList<>();
    }

    public void addBarcodeListener(BarcodeCallback listener) {
        listeners.add(listener);
    }

    public void openScanner() {
        if (!checkPermission()) {
            requestPermission();
            return;
        }
        openDialog();
    }

    private void openDialog() {
        AlertDialog dialog = this.buildDialog();
        dialog.show();
    }

    private boolean checkPermission() {
        int state = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA);
        return state == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        String[] permissions = new String[]{Manifest.permission.CAMERA};
        ActivityCompat.requestPermissions(activity, permissions, ACTIVITY_RESULT_CAMERA);
    }

    private AlertDialog buildDialog() {
        DialogViewHolder dialogViewHolder = createDialogViewHolder();

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(dialogViewHolder.view);
        AlertDialog dialog = builder.create();

        CameraSource cameraSource = createCameraSource(barcode -> {
            listeners.forEach(listener -> listener.onBarcode(barcode));
            dialog.dismiss();
        });

        SurfaceCallback callback = new SurfaceCallback(cameraSource);
        dialogViewHolder.surfaceView.getHolder().addCallback(callback);
        dialog.setOnDismissListener(dialogInterface -> cameraSource.release());
        return dialog;
    }


    private CameraSource createCameraSource(BarcodeCallback resultCallback) {
        BarcodeDetector detector = createBarcodeDetector(resultCallback);
        return new CameraSource.Builder(activity, detector)
            .setRequestedPreviewSize(sourceHeight, sourceWidth)
            .setAutoFocusEnabled(true).build();
    }

    private BarcodeDetector createBarcodeDetector(BarcodeCallback resultCallback) {
        BarcodeDetector detector = new BarcodeDetector.Builder(activity).build();
        detector.setProcessor(new ScannerProcessor(resultCallback));
        return detector;
    }

    private DialogViewHolder createDialogViewHolder() {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View dialogView = inflater.inflate(layoutId, null);

        DialogViewHolder viewHolder = new DialogViewHolder();
        viewHolder.view = dialogView;
        viewHolder.surfaceView = dialogView.findViewById(R.id.sv_cameraSurface);
        return viewHolder;
    }


    static class DialogViewHolder {
        View view;
        SurfaceView surfaceView;
    }


    public void onPermissionGranted(int code) {
        if (code == ACTIVITY_RESULT_CAMERA) {
            openDialog();
        }
    }

}
