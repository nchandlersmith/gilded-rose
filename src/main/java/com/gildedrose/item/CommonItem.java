package com.gildedrose.item;

import com.gildedrose.Item;

public class CommonItem extends Item {

    public CommonItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

	public void updateQuality() {
        quality -= 1;
	}
    
}
