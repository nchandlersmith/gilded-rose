package com.gildedrose.item;

public class CommonItem extends StoreItem {

    public CommonItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
	public void updateQuality() {
        safeDecrementQuality();
        sellIn -= 1;
        if (sellIn < 0) {
            safeDecrementQuality();
        }
    }
    private void safeDecrementQuality() {
        if (quality > 0) quality -= 1;
    }
    
}
