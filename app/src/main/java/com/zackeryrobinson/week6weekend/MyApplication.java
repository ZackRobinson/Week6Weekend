package com.zackeryrobinson.week6weekend;
import android.app.Application;

import com.orm.SugarContext;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Zack on 10/7/2017.
 */

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }


}
