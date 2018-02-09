package com.avinash.sqlconnect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btn_get;
    ListView LV_Data;
    SimpleAdapter AD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LV_Data = (ListView) findViewById(R.id.LV_Data);
        btn_get = (Button) findViewById(R.id.btnGet);


        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Map<String, String>> MyDataList = null;
                GetData myData = new GetData();

                MyDataList = myData.getdata();

                String[] fromehre = {"User1", "Pass1"};

                int[] viewwhere = {R.id.User1, R.id.Pass1};
                AD = new SimpleAdapter(MainActivity.this, MyDataList, R.layout.listtemplate, fromehre, viewwhere);
                LV_Data.setAdapter(AD);
            }
        });


    }
}
