package dev.szafraniak.bm_mobileapp.business.utils;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import dev.szafraniak.bm_mobileapp.business.models.entity.invoice.Invoice;

import static android.os.Environment.DIRECTORY_DOWNLOADS;
import static android.os.Environment.getExternalStoragePublicDirectory;
import static dev.szafraniak.bm_mobileapp.business.Constance.ACTIVITY_RESULT_WRITE_EXTERNAL_STORAGE;

public class FileUtils {
    private final static String PDF_EXTENSION = ".pdf";

    public static boolean checkPermission(Activity activity) {
        int state = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return state == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestPermission(Activity activity) {
        String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(activity, permissions, ACTIVITY_RESULT_WRITE_EXTERNAL_STORAGE);
    }

    public static File saveInvoice(Invoice invoice, byte[] bytes) throws IOException {
        String fileName = generateFileNameForInvoice(invoice);
        return saveFileInDownloads(bytes, fileName);
    }

    private static File saveFileInDownloads(byte[] bytes, String fileNameWithExt) throws IOException {
        File downloadFile = getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS);
        File pdfFile = new File(downloadFile, fileNameWithExt);
        try (FileOutputStream fos = new FileOutputStream(pdfFile)) {
            fos.write(bytes);
        }
        return pdfFile;
    }

    public static String generateFileNameForInvoice(Invoice invoice) {
        String safeInvoiceName = invoice.getInvoiceName().replaceAll("[/:*?\"<>|]+", "_");
        return String.format("%s%s", safeInvoiceName, PDF_EXTENSION);
    }

    public static void openPDFFile(Activity activity, File file) throws ActivityNotFoundException {
        Uri fileUri = FileProvider.getUriForFile(activity, activity.getPackageName() + ".provider", file);
        openPDFFile(activity, fileUri);
    }

    // Throw Error if no PDF reader Is available
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
