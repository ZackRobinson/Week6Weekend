package com.zackeryrobinson.week6weekend;

//import com.orm.SugarRecord;

import com.orm.SugarRecord;

/**
 * Created by ios on 10/7/17.
 */

public class SugarObject extends SugarRecord {
    String name;

    public SugarObject(){
    }

    public SugarObject(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
