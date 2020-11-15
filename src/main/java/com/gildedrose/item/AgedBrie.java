package com.gildedrose.item;

public class AgedBrie extends StoreItem {

    private static final int MAXIMUM_QUALITY = 50;

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        sellIn -= 1;
        quality += sellIn < 0 ? 2 : 1;
        quality = quality > MAXIMUM_QUALITY ? MAXIMUM_QUALITY : quality;
    }
    
}
