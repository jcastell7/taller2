package com.example.joyeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListOrders extends AppCompatActivity {
    private ListView listView;
    private String opt[];
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_orders);
        listView = (ListView) findViewById(R.id.lstOrders);
        opt = Jewels.listJewels();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opt);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(ListOrders.this, NewJewel.class);
                intent.putExtra("from", "list");
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

}
