package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void commonItem_whenUpdate_thenDecreaseQualityBy1() {
        Item[] items = new Item[] { new Item("commonItem", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void givenCommonItem_whenUpdate_thenDecreaseSellInBy1() {
        Item[] items = new Item[] { new Item("commonItem", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
    }

}
