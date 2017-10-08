package com.zackeryrobinson.week6weekend;

//import com.orm.SugarRecord;

import com.orm.SugarRecord;

/**
 * Created by ios on 10/7/17.
 */

public class SObject extends SugarRecord {
    String name;

    public SObject(){
    }

    public SObject(String name)
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
