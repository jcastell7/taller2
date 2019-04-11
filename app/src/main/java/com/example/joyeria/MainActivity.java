package com.example.joyeria;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private String opc[];
    private Resources resources;
    private Intent intent;
    public static ArrayList<Jewel> jewelArrayList  = new ArrayList<>();
    public static String jewelType[];
    public static String metals[];
    public static String stones[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.lstMenu);
        resources = this.getResources();
        jewelType= resources.getStringArray(R.array.type);
        metals = resources.getStringArray(R.array.metals);
        stones = resources.getStringArray(R.array.stones);
        opc = resources.getStringArray(R.array.menu);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, opc);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent = new Intent(MainActivity.this, NewJewel.class );
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, ListOrders.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    public static String getJewelString(int type, int stone , int price){
           return jewelType[type] +" + "+ stones[stone] +"                 "+price;
    }
}
