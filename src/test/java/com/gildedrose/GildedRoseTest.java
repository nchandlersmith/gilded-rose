package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private final String COMMON_ITEM = "common item";
    private final String PASSES = "Backstage passes to a TAFKAL80ETC concert";

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

    @Test
    void givenPassesWithSellInGreaterThan10_whenUpdate_thenIncreaseQualityBy1() {
        Item[] items = new Item[] { new Item(PASSES, 11, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(21, app.items[0].quality);
    }

    @Test
    void givenPassesWithSellInEquals10_whenUpdate_thenIncreaseQualityBy2() {
        Item[] items = new Item[] { new Item(PASSES, 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(22, app.items[0].quality);
    }

    @Test
    void givenPassesWithSellInAtOrBetween6And10_whenUpdate_thenIncreaseQualityBy2() {
        Item[] items = new Item[] { new Item(PASSES, 6, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(22, app.items[0].quality);
    }

    @Test
    void givenPassesWithSellInEquals5_whenUpdate_thenIncreaseQualityBy3() {
        Item[] items = new Item[] { new Item(PASSES, 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(23, app.items[0].quality);
    }

    @Test
    void givenPassesWithSellInAtOrBetween1And5_whenUpdate_thenIncreaseQualityBy3() {
        Item[] items = new Item[] { new Item(PASSES, 1, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(23, app.items[0].quality);
    }

    @Test
    void givenPassesWithSellInEquals0_whenUpdate_thenQualityEquals0() {
        Item[] items = new Item[] { new Item(PASSES, 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }
}
