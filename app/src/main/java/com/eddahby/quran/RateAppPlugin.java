package com.eddahby.quran;

import android.content.Intent;
import android.net.Uri;
import com.getcapacitor.JSObject;
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
        ReviewManager manager = ReviewManagerFactory.create(getContext());
        Task<ReviewInfo> request = manager.requestReviewFlow();
        request.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ReviewInfo reviewInfo = task.getResult();
                Task<Void> flow = manager.launchReviewFlow(getActivity(), reviewInfo);
                flow.addOnCompleteListener(launchTask -> {
                    // The flow has finished. The API does not indicate whether the user
                    // reviewed or not, or even whether the review dialog was shown.
                    call.resolve();
                });
            } else {
                // Flow failed or was not available
                call.reject("Review flow request failed");
            }
        });
    }

    @PluginMethod
    public void openStore(PluginCall call) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.eddahby.quran"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getContext().startActivity(intent);
            call.resolve();
        } catch (Exception e) {
            call.reject("Could not open Play Store");
        }
    }
}
