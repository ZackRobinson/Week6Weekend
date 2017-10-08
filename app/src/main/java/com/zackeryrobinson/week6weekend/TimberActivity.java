package com.zackeryrobinson.week6weekend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import timber.log.Timber;

/**
 * Created by ios on 10/7/17.
 */

//This activity shows how timber is implemented

public class TimberActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /*
        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        else{
            Timber.plant(new ReleaseTree());
        }*/
        Timber.plant(new Timber.DebugTree());
        Timber.d("Zack's Test");
    }
}
