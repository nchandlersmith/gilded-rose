package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private final String COMMON_ITEM = "common item";

    @Test
    void commonItem_whenUpdate_thenDecreaseQualityBy1() {
        Item[] items = new Item[] { new Item(COMMON_ITEM, 1, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].quality);
    }

    @Test
    void givenCommonItem_whenUpdate_thenDecreaseSellInBy1() {
        Item[] items = new Item[] { new Item(COMMON_ITEM, 1, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void givenCommonItem_whenUpdateWithSellInEquals0_thenDecreaseQualityBy2() {
        Item[] items = new Item[] { new Item(COMMON_ITEM, 0, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void givenCommonItem_whenUpdateWithSellInEquals0_thenDecrementSellIn() {
        Item[] items = new Item[] { new Item(COMMON_ITEM, 0, 10 )};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void givenCommonItemWithNegativeSellIn_whenUpdate_thenDecrementSellin() {
        Item[] items = new Item[] { new Item(COMMON_ITEM, 0-1, 10 )};
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void givenCommonItemWithNegativeSellIn_whenUpdate_thenDecreaseQualityBy2() {
        Item[] items = new Item[] { new Item(COMMON_ITEM, -2, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(8, app.items[0].quality);
    }

    @Test
    void givenCommonItemWith0Quality_whenUpdate_thenQualityRemains0() {
        Item[] items = new Item[] { new Item(COMMON_ITEM, 5, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }
}
