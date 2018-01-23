package com.osmandzhevaha.offlinemaps;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView deviceMemoryView = (TextView) findViewById(R.id.deviceMemoryView);
//        TextView freeMemory = (TextView) findViewById(R.id.freeMemory);
        TextView memoryValue = (TextView) findViewById(R.id.memoryValue);
        TextView memoryIndex = (TextView) findViewById(R.id.memoryIndex);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        long deviceMaxMemory = getExternalCacheDir().getTotalSpace();
        long deviceFreeMemory = getExternalCacheDir().getFreeSpace()/1024;
        long deviceUsableMemory = getExternalCacheDir().getUsableSpace()/1024;
        int percentUsableMemory = (int) (deviceUsableMemory*100/deviceMaxMemory);
        progressBar.setMax(100);
        progressBar.setProgress(percentUsableMemory);


        memoryValue.setText("total = "+deviceMaxMemory
        +"\nfree = "+deviceFreeMemory
        +"\nusable = " +deviceUsableMemory
        +"\nusable % = "+percentUsableMemory);
//        memoryValue.setText(""+getExternalCacheDir().getUsableSpace());
        memoryIndex.setText("Mb");
        if (deviceFreeMemory> 1024){
            memoryIndex.setText("Gb");
        }
    }
}
