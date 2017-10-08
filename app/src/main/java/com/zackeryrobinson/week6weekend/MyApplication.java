package com.zackeryrobinson.week6weekend;
import android.app.Application;
import android.util.Log;

import com.orm.SugarApp;
import com.orm.SugarContext;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Zack on 10/7/2017.
 */

public class MyApplication extends SugarApp {


    private static final String TAG = "MyApplicationTag";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


}
