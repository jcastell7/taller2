package com.example.joyeria;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class NewJewel extends AppCompatActivity {
    private Resources resources;
    private String jewelType[];
    private String metals[];
    private String stones[];
    Spinner type;
    Spinner metal;
    Spinner stone;
    TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_jewel);
        resources = this.getResources();
        this.loadActivity();
        type = findViewById(R.id.lstJewelType);
        metal = findViewById(R.id.lstMaterial);
        stone = findViewById(R.id.lstStone);
        jewelType= MainActivity.jewelType;
        metals = MainActivity.metals;
        stones = MainActivity.stones;
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, jewelType);
        ArrayAdapter<String> metalAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, metals);
        ArrayAdapter<String> stonesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, stones);
        type.setAdapter(typeAdapter);
        metal.setAdapter(metalAdapter);
        stone.setAdapter(stonesAdapter);
    }


    @Override
    protected void onStart()
    {
        this.loadActivity();
        super.onStart();
    }


    @Override
    protected void onResume()
    {
        this.loadActivity();
        super.onResume();
    }

    public void loadActivity(){
        Intent intent = getIntent();
        String from = intent.getStringExtra("from");
        int position = intent.getIntExtra("position", 0);
        System.out.println("the activity comes from: "+from);
        if(from!=null){
            findViewById(R.id.btnAddJewel).setVisibility(View.GONE);
            findViewById(R.id.lstJewelType).setEnabled(false);
            findViewById(R.id.lstMaterial).setEnabled(false);
            findViewById(R.id.lstStone).setEnabled(false);
            Jewel jewel = MainActivity.jewelArrayList.get(position);
            type = findViewById(R.id.lstJewelType);
            type.setSelection(jewel.getType());
            metal = findViewById(R.id.lstMaterial);
            metal.setSelection(jewel.getMetal());
            stone = findViewById(R.id.lstStone);
            stone.setSelection(jewel.getStone());
            price = findViewById(R.id.lblPrice);
            price.setText(jewel.getPrice()+"");
        }
    }

    public void addNewJewel(View view){
        type = findViewById(R.id.lstJewelType);
        metal = findViewById(R.id.lstMaterial);
        stone = findViewById(R.id.lstStone);
        CheckBox engraved = findViewById(R.id.chkEngraved);
        Jewel jewel = new Jewel(type.getSelectedItemPosition(), metal.getSelectedItemPosition(), stone.getSelectedItemPosition(), engraved.isChecked());
        Jewels jewels = new Jewels();
        jewels.addNewJewel(jewel);
        price = findViewById(R.id.lblPrice);
        price.setText(jewel.getPrice()+"");
    }
}
