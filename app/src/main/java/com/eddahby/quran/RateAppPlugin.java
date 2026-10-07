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

    private static final String TAG = "RateAppPlugin";

    @PluginMethod
    public void requestReview(PluginCall call) {
        if (getActivity() == null) {
            call.reject("Activity not available");
            return;
        }

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
        if (getActivity() == null) {
            call.reject("Activity not available");
            return;
        }

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
        if (getActivity() == null) return;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.eddahby.quran"));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getActivity().startActivity(intent);
    }

    @PluginMethod
    public void shareAyah(PluginCall call) {
        String text = call.getString("text");
        String title = call.getString("title", "مشاركة الآية");
        Log.d(TAG, "shareAyah called. Text: " + text);

        if (text == null || text.trim().isEmpty()) {
            call.reject("Text is required");
            return;
        }

        if (getActivity() == null) {
            call.reject("Activity not available");
            return;
        }

        getActivity().runOnUiThread(() -> {
            try {
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, text);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, title);

                Intent shareIntent = Intent.createChooser(sendIntent, title);
                getActivity().startActivity(shareIntent);
                call.resolve();
            } catch (Exception e) {
                Log.e(TAG, "Share failed", e);
                call.reject("Could not open Share Sheet: " + e.getMessage());
            }
        });
    }
}
