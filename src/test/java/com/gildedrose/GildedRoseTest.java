package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gildedrose.exception.ObjectIsNotAnInstanceOfStoreItem;
import com.gildedrose.item.Pass;
import com.gildedrose.item.StoreItem;
import com.gildedrose.item.StoreItemFactory;
import com.gildedrose.item.Sulfuras;

import com.gildedrose.rule.RuleQualityDegrades;
import com.gildedrose.rule.RuleQualityImproves;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void updateQuality_processesStoreItems() {
        StoreItem[] items = new StoreItem[] {
                StoreItemFactory.createCommonItem("common item", 1, 20),
                StoreItemFactory.createAgedBrie("aged brie", 1, 20),
            new Pass("pass", 1, 20),
            new Sulfuras("sulfuras", 1, 20)
        };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();

        assertEquals(19, items[0].quality);
        assertEquals(21, items[1].quality);
        assertEquals(23, items[2].quality);
        assertEquals(80, items[3].quality);
    }

    @Test
    void updateQuality_whenItemNotStoreItem_shouldThrowException() {
        Item[] items = new Item[] { new Item("non store item", 5, 5) };
        GildedRose app = new GildedRose(items);

        Exception exception = assertThrows(ObjectIsNotAnInstanceOfStoreItem.class, app::updateQuality);

        assertEquals("com.gildedrose.Item is not a StoreItem class or subclass.", exception.getMessage());
    }
}
