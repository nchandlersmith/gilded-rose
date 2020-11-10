package com.gildedrose.item;

public class AgedBrie extends StoreItem {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality < 50) quality += 1;
        sellIn -= 1;
        if (sellIn < 0 && quality < 50) {
            quality += 1;
        }
    }
    
}
