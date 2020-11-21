package com.gildedrose;

import com.gildedrose.exception.ObjectIsNotAnInstanceOfStoreItem;
import com.gildedrose.storeitem.StoreItem;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: this.items) {
            if (item instanceof StoreItem) {
                ((StoreItem) item).updateQuality();
            } else {
                String className = item.getClass().getName();
                throw new ObjectIsNotAnInstanceOfStoreItem(
                        className + " is not a StoreItem class or subclass.");
            }
        }
    }
}