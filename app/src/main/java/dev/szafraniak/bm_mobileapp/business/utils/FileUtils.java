package dev.szafraniak.bm_mobileapp.business.utils;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;

import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static android.os.Environment.DIRECTORY_DOWNLOADS;
import static android.os.Environment.getExternalStoragePublicDirectory;
import static dev.szafraniak.bm_mobileapp.business.Constance.ACTIVITY_RESULT_WRITE_EXTERNAL_STORAGE;

public class FileUtils {

    public static boolean checkPermission(Activity activity) {
        int state = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return state == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestPermission(Activity activity) {
        String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(activity, permissions, ACTIVITY_RESULT_WRITE_EXTERNAL_STORAGE);
    }


    public static Uri savePDFFileInDownloads(Activity activity, String fileNameWithExt, byte[] bytes) throws IOException {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, fileNameWithExt);
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "application/pdf");
            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS);
            ContentResolver resolver = activity.getContentResolver();
            Uri uri = resolver.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);
            OutputStream fos = resolver.openOutputStream(uri);
            fos.write(bytes);
            fos.close();
            return uri;
        } else {
            File downloadFile = getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS);
            File pdfFile = new File(downloadFile, fileNameWithExt);

            try (FileOutputStream fos = new FileOutputStream(pdfFile)) {
                fos.write(bytes);
            }
            return FileProvider.getUriForFile(activity, activity.getPackageName() + ".provider", pdfFile);
        }
    }

    public static void openPDFFile(Activity activity, Uri fileUri) throws ActivityNotFoundException {
        Intent target = prepareOpenFileIntent(activity, fileUri);
        activity.startActivity(target);
    }

    private static Intent prepareOpenFileIntent(Activity activity, Uri fileUri) {
        String mime = activity.getContentResolver().getType(fileUri);
        Intent target = new Intent(Intent.ACTION_VIEW);
        target.setDataAndType(fileUri, mime);
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        target.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        return Intent.createChooser(target, "Open File");
    }
}
