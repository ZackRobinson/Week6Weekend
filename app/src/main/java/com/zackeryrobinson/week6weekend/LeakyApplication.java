package com.zackeryrobinson.week6weekend;
import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Zack on 10/7/2017.
 */

public class LeakyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
    }


}
