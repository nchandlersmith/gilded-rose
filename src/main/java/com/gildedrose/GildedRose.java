package com.gildedrose;

import java.util.ArrayList;

import com.gildedrose.exception.ObjectIsNotAnInstanceOfStoreItem;
import com.gildedrose.item.StoreItem;

class GildedRose {

    Item[] items;
    ArrayList<String> exceptions;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] instanceof StoreItem) {
                ((StoreItem) items[i]).updateQuality();
            } else {
                String className = items[i].getClass().getName();
                throw new ObjectIsNotAnInstanceOfStoreItem(className + " is not a StoreItem class or subclass.");
            }
        }
    }
}