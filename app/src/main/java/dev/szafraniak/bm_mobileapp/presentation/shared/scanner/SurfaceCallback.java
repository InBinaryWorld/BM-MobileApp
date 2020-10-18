package dev.szafraniak.bm_mobileapp.presentation.shared.scanner;

import android.annotation.SuppressLint;
import android.view.SurfaceHolder;

import androidx.annotation.NonNull;

import com.google.android.gms.vision.CameraSource;

import java.io.IOException;

class SurfaceCallback implements SurfaceHolder.Callback {

    private final CameraSource cameraSource;

    public SurfaceCallback(CameraSource cameraSource) {
        this.cameraSource = cameraSource;
    }

    @Override
    @SuppressLint("MissingPermission")
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        try {
            cameraSource.start(holder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        cameraSource.stop();
    }


}
