package com.gildedrose.item;

import com.gildedrose.Item;

public abstract class StoreItem extends Item{

    private int qualityIncrement = -1;

    private static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;

    protected StoreItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality(){
        sellIn -= 1;
        quality += sellIn < 0 ? 2 * qualityIncrement : qualityIncrement;
        quality = quality < MINIMUM_QUALITY ? MINIMUM_QUALITY : quality;
        quality = quality > MAXIMUM_QUALITY ? MAXIMUM_QUALITY  : quality;
    }

    protected void setQualityIncrement(int qualityIncrement) {
        this.qualityIncrement = qualityIncrement;
    }
    
}
