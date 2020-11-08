package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private final String COMMON_ITEM = "common item";

    @Test
    void commonItem_whenUpdate_thenDecreaseQualityBy1() {
        Item[] items = new Item[] { new Item(COMMON_ITEM, 5, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].quality);
    }

    @Test
    void givenCommonItem_whenUpdate_thenDecreaseSellInBy1() {
        Item[] items = new Item[] { new Item(COMMON_ITEM, 5, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void givenCommonItem_whenUpdateWithSellInEquals0_thenDecreaseQualityBy2() {
        Item[] items = new Item[] { new Item(COMMON_ITEM, 0, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        
        assertEquals(8, app.items[0].quality);
    }
}
