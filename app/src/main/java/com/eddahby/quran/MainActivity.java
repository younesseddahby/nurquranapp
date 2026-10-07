package com.eddahby.quran;

import android.os.Bundle;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        registerPlugin(RateAppPlugin.class);
        super.onCreate(savedInstanceState);
    }
}
