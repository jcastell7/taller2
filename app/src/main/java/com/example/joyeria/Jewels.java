package com.example.joyeria;

import android.content.Context;

public class Jewels {

 public void addNewJewel(Jewel jewel){ MainActivity.jewelArrayList.add(jewel); }

 public static String[] listJewels(){
     String jewels[]= new String[MainActivity.jewelArrayList.size()];
     for (int i =0 ; i< MainActivity.jewelArrayList.size(); i++){
         jewels[i]= MainActivity.getJewelString(MainActivity.jewelArrayList.get(i).getType(), MainActivity.jewelArrayList.get(i).getStone(), MainActivity.jewelArrayList.get(i).getPrice());
     }
     return jewels;
 }
}
