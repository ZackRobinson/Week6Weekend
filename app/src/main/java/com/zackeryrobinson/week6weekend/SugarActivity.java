package com.zackeryrobinson.week6weekend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ios on 10/7/17.
 */

public class SugarActivity extends AppCompatActivity{
    EditText etName;
    TextView tvResult;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugar);

        etName = (EditText) findViewById(R.id.etName);
        tvResult = (TextView) findViewById(R.id.tvResults);
    }

    public void createSugarObject()
    {
        String name = String.valueOf(etName.getText());
        if (name != null) {
            SugarObject sugarObject = new SugarObject(name);
            sugarObject.save();
            Toast.makeText(this, "Object Created", Toast.LENGTH_SHORT).show();
            etName.setText("");
        }
    }

    public void bulkRetrieve()
    {
        String name ="";
        List<SugarObject> sugarObjectList = SugarObject.listAll(SugarObject.class);
        for (int i = 0; i <sugarObjectList.size() ; i++) {
            name += sugarObjectList.get(i).getName() +" ";
        }
        tvResult.setText(name);
    }
    public void userAction(View view) {
        switch (view.getId()) {
            case R.id.btnCreate:
                createSugarObject();
                break;
            case R.id.btnLoad:
                bulkRetrieve();
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SugarObject.deleteAll(SugarObject.class);

    }
}