package com.zackeryrobinson.week6weekend;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zackeryrobinson.week6weekend.data.Jungle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createJungle(View view) {

        if (view.getId() == R.id.btnMakeJungle) {
            Jungle jungle = new Jungle();
        }
    }

    public void testLeakCanary (View view) {
        if (view.getId() == R.id.btnTestLeakCanary)
            leakingTask();
    }

    private void leakingTask() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                while (true) {
                    SystemClock.sleep(1000);
                }
            }
        }.execute();
    }


}
