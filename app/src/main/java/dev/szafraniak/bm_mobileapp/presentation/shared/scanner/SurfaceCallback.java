package dev.szafraniak.bm_mobileapp.presentation.shared.scanner;

import android.annotation.SuppressLint;
import android.view.SurfaceHolder;

import androidx.annotation.NonNull;

import com.google.android.gms.vision.CameraSource;

import java.io.IOException;

class SurfaceCallback implements SurfaceHolder.Callback {
    private final Scanner scanner;
    private CameraSource cameraSource;

    public SurfaceCallback(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    @SuppressLint("MissingPermission")
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        System.out.println("On Surface Create !!");
        cameraSource = scanner.createCameraSource();
        try {
            cameraSource.start(holder);
        } catch (IOException e) {
            closeScanner();
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        closeScanner();
    }

    private void closeScanner() {
        scanner.hideCamera();
        cameraSource.release();
    }

}
