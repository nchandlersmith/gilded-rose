package com.gildedrose.item;

public class AgedBrie extends StoreItem {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        super.setQualityIncrement(1);
    }
    
}
