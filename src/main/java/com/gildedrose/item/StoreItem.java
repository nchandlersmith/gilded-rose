package com.gildedrose.item;

import com.gildedrose.Item;

public abstract class StoreItem extends Item{

    protected StoreItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
    }
    
}
