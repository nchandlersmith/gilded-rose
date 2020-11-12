package com.gildedrose.item;

public class ConjuredItem extends StoreItem {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality == 1) quality = 0;
        if (quality > 0) quality -= 2;
        sellIn -= 1;
        if (sellIn < 0 && quality == 1) quality = 0;
        if (sellIn < 0 && quality > 0) quality -= 2;
    }
}
