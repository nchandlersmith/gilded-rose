package com.gildedrose;

import com.gildedrose.exception.ObjectIsNotAnInstanceOfStoreItem;
import com.gildedrose.item.StoreItem;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] instanceof StoreItem) {
                ((StoreItem) items[i]).updateQuality();
            } else {
                throw new ObjectIsNotAnInstanceOfStoreItem("some exception");
            }
        }
    }
}