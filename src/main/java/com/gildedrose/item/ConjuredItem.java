package com.gildedrose.item;

public class ConjuredItem extends StoreItem {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        sellIn -= 1;
        quality -= sellIn < 0 ? 4 : 2;
        quality = quality < 0 ? 0 : quality;
    }
}
