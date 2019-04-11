package com.example.joyeria;

public class Jewel {
    private int type;
    private int metal;
    private int stone;
    private boolean engraved;
    private int price;

    public Jewel(int type, int metal, int stone, boolean engraved) {
        this.type = type;
        this.metal = metal;
        this.stone = stone;
        this.engraved = engraved;
        this.setPrice();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMetal() {
        return metal;
    }

    public void setMetal(int metal) {
        this.metal = metal;
    }

    public int getStone() {
        return stone;
    }

    public void setStone(int stone) {
        this.stone = stone;
    }

    public boolean isEngraved() {
        return engraved;
    }

    public void setEngraved(boolean engraved) {
        this.engraved = engraved;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice() {
        this.price = 0;
       switch (this.type){
           case 0:
                switch (this.metal){
                    case 0:
                        price += 150000;
                        break;
                    case 1:
                        price += 100000;
                        break;
                    case 2:
                        price += 50000;
                        break;
                }
               break;
           case 1:
               switch (this.metal){
                   case 0:
                       price += 90000;
                       break;
                   case 1:
                       price += 50000;
                       break;
                   case 2:
                       price += 30000;
                       break;
               }
               break;
       }
        switch (this.stone){
            case 0:
                price += 190000;
                break;
            case 1:
                price += 180000;
                break;
            case 2:
                price += 150000;
        }
    }

}
