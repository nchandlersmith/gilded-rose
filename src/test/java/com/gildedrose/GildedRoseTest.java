package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private final String COMMON_ITEM = "common item";
    private final String PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private final String AGED_BRIE = "Aged Brie";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";

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
    void givenCommonItemWith0QualityAnd0SellIn_whenUpdate_thenQualityRemains0() {
        Item[] items = new Item[] { new Item(COMMON_ITEM, 0, 0) };
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
    void givenPassesWithSellInLessThan0_whenUpdate_thenQualityEquals0() {
        Item[] items = new Item[] { new Item(PASSES, -10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void givenPassesWithSellInEquals0_whenUpdate_thenQualityEquals0() {
        Item[] items = new Item[] { new Item(PASSES, 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void givenPassesWithSellInEquals0_whenUpdate_thenSellInDecrements() {
        Item[] items = new Item[] { new Item(PASSES, 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void givenPassesWithSellInEqualsNegative1_whenUpdate_thenSellInDecrements() {
        Item[] items = new Item[] { new Item(PASSES, -1, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void givenPassesWithSellInGreaterThan10_whenUpdate_thenQualityMaxesAt50() {
        Item[] items = new Item[] { new Item(PASSES, 11, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    void givenPassesWithSellInBetween5And11_whenUpdate_thenQualityMaxesAt50() {
        Item[] items = new Item[] { new Item(PASSES, 7, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    void givenPassesWithSellInBetween0And6_whenUpdate_thenQualityMaxesAt50() {
        Item[] items = new Item[] { new Item(PASSES, 3, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    void givenAgedBrieWithPositiveSellIn_whenUpdate_thenQualityIncreasesBy1() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(21, app.items[0].quality);
    }

    @Test
    void givenAgedBrieWithSellInEquals0_whenUpdate_thenQualityIncreasesBy2() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(22, app.items[0].quality);
    }

    @Test
    void givenAgedBrieWithNegativeSellIn_whenUpdate_thenQualityIncreasesBy2() {
        Item[] items = new Item[] { new Item(AGED_BRIE, -1, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(22, app.items[0].quality);
    }

    @Test
    void givenAgedBrie_whenUpdate_thenQualityCannotBeGreaterThan50() {
        Item[] items = new Item[] { new Item(AGED_BRIE, -1, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    void givenAgedBrieWithPositiveSellin_whenUpdate_thenSellinDecreasesBy1() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void givenAgedBrieWithSellinEquals0_whenUpdate_thenSellinDecreasesBy1() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void givenAgedBrieWithNegativeSellIn_whenUpdate_thenSellinDecreasesBy1() {
        Item[] items = new Item[] { new Item(AGED_BRIE, -1, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void givenSulfurasWithPositiveSellIn_whenUpdate_thenQualityDoesNotDecrease() {
        Item[] items = new Item[] { new Item(SULFURAS, 5, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(80, app.items[0].quality);
    }

    @Test
    void givenSulfurasWithSellinEquals0_whenUpdate_thenQualityDoesNotDecrease() {
        Item[] items = new Item[] { new Item(SULFURAS, 0, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(80, app.items[0].quality);
    }

    @Test
    void givenSulfurasWithNegativeSellIn_whenUpdate_thenQualityDoesNotDecrease() {
        Item[] items = new Item[] { new Item(SULFURAS, -1, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(80, app.items[0].quality);
    }

    @Test
    void givenSulfuras_whenUpdate_thenSellInDoesNotDecrement() {
        Item[] items = new Item[] { new Item(SULFURAS, 20, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(20, app.items[0].sellIn);
    }
}
