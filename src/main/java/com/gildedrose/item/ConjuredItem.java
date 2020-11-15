package com.gildedrose.item;

public class ConjuredItem extends StoreItem {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        super.setQualityIncrement(-2);
    }
    
}
