package com.gildedrose.item;

public class CommonItem extends StoreItem {

    private static final int MINIMUM_QUALITY = 0;

    public CommonItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
	public void updateQuality() {
        sellIn -= 1;
        quality -= sellIn < 0 ? 2 : 1;
        quality = quality < MINIMUM_QUALITY ? MINIMUM_QUALITY : quality;
    }
    
}
