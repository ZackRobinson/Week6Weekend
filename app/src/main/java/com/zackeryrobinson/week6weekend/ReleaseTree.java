package com.zackeryrobinson.week6weekend;

import android.util.Log;

import timber.log.Timber;

/**
 * Created by ios on 10/7/17.
 */

public class ReleaseTree extends Timber.Tree {

    public static final int MAX_LOG_LENGTH = 4000;

    @Override
    protected boolean isLoggable(String tag, int priority) {
        if(priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO){
            return false;
        }
        return true;
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if(isLoggable(priority))
            if(message.length() < MAX_LOG_LENGTH){
                if(priority == Log.ASSERT){
                    Log.wtf(tag, message);
                }else{
                    Log.println(priority, tag, message);
                }
                return;
            }

        for (int i = 0, length = message.length(); i < length; i++) {
            int newline = message.indexOf('\n', i);
            newline = newline != -1 ? newline : length;
            do{
                int end = Math.min(newline, i + MAX_LOG_LENGTH);
                String part = message.substring(i, end);
                if(priority == Log.ASSERT){
                    Log.wtf(tag, part);
                }else{
                    Log.println(priority, tag, part);
                }
                i = end;
            } while(i < newline);
        }
    }
}
