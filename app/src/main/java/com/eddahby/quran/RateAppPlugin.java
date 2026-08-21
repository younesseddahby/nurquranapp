package com.eddahby.quran;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.gms.tasks.Task;

@CapacitorPlugin(name = "RateApp")
public class RateAppPlugin extends Plugin {

    @PluginMethod
    public void requestReview(PluginCall call) {
        getActivity().runOnUiThread(() -> {
            try {
                ReviewManager manager = ReviewManagerFactory.create(getActivity());
                Task<ReviewInfo> request = manager.requestReviewFlow();
                request.addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        ReviewInfo reviewInfo = task.getResult();
                        Task<Void> flow = manager.launchReviewFlow(getActivity(), reviewInfo);
                        flow.addOnCompleteListener(launchTask -> {
                            call.resolve();
                        });
                    } else {
                        openStoreInternal();
                        call.resolve();
                    }
                });
            } catch (Exception e) {
                openStoreInternal();
                call.resolve();
            }
        });
    }

    @PluginMethod
    public void openStore(PluginCall call) {
        getActivity().runOnUiThread(() -> {
            try {
                openStoreInternal();
                call.resolve();
            } catch (Exception e) {
                call.reject("Could not open Play Store: " + e.getMessage());
            }
        });
    }

    private void openStoreInternal() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.eddahby.quran"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getActivity().startActivity(intent);
    }

    @PluginMethod
    public void shareAyah(PluginCall call) {
        String text = call.getString("text");
        if (text == null) {
            call.reject("Text is required");
            return;
        }
        
        getActivity().runOnUiThread(() -> {
            try {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, text);
                
                Intent chooser = Intent.createChooser(intent, "Share Ayah");
                // When starting from Activity, we don't strictly need NEW_TASK but it doesn't hurt
                getActivity().startActivity(chooser);
                call.resolve();
            } catch (Exception e) {
                Log.e("RateApp", "Share failed", e);
                call.reject("Could not open Share Sheet: " + e.getMessage());
            }
        });
    }
}
