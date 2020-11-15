package com.gildedrose.item;

public class Pass extends StoreItem {

    private static final int MAXIMUM_QUALITY = 50;

    public Pass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        sellIn -= 1;
        quality += 1;
        quality += sellIn < 10 ? 1 : 0;
        quality += sellIn < 5 ? 1 : 0;
        quality = quality > MAXIMUM_QUALITY ? MAXIMUM_QUALITY : quality;
        quality = sellIn < 0 ? 0 : quality;

    }
    
}
