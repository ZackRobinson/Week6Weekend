package com.zackeryrobinson.week6weekend;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * Created by ios on 10/7/17.
 */

public class ScannerActivity extends AppCompatActivity{

    TextView tvScanContent;
    TextView tvScanFormatName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        tvScanContent = (TextView) findViewById(R.id.tvScanContent);
        tvScanFormatName = (TextView) findViewById(R.id.tvScanFormatName);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setContentView(R.layout.activity_scanner);
    }

    public void startCamera(View view) {
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setOrientationLocked(false);
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setBarcodeImageEnabled(true);
        intentIntegrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(intentResult != null)
        {
            if(intentResult.getContents() == null)
            {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            }else{
                tvScanContent.setText(intentResult.getContents());
                tvScanFormatName.setText(intentResult.getFormatName());
            }
        }else
        super.onActivityResult(requestCode, resultCode, data);
    }
}
