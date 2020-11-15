package com.gildedrose.item;

public class Sulfuras extends StoreItem{

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, 80);
    }

    @Override
    public void updateQuality() {
        // Sulfuras always has quality 80
    }
    
}
