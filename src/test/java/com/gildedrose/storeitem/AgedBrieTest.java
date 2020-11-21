package com.gildedrose.storeitem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AgedBrieTest {

    private final String AGED_BRIE = "Aged Brie";

    @Test
    void givenAgedBrieWithPositiveSellIn_whenUpdate_thenQualityIncreasesBy1() {
        StoreItem agedBrie = StoreItemFactory.createAgedBrie(AGED_BRIE, 5, 20);
        agedBrie.updateQuality();
        assertEquals(21, agedBrie.quality);
    }

    @Test
    void givenAgedBrieWithSellInEquals0_whenUpdate_thenQualityIncreasesBy2() {
        StoreItem agedBrie = StoreItemFactory.createAgedBrie(AGED_BRIE, 0, 20);
        agedBrie.updateQuality();
        assertEquals(22, agedBrie.quality);
    }

    @Test
    void givenAgedBrieWithNegativeSellIn_whenUpdate_thenQualityIncreasesBy2() {
        StoreItem agedBrie = StoreItemFactory.createAgedBrie(AGED_BRIE, -1, 20);
        agedBrie.updateQuality();
        assertEquals(22, agedBrie.quality);
    }

    @Test
    void givenAgedBrie_whenUpdate_thenQualityCannotBeGreaterThan50() {
        StoreItem agedBrie = StoreItemFactory.createAgedBrie(AGED_BRIE, -1, 50);
        agedBrie.updateQuality();
        assertEquals(50, agedBrie.quality);
    }

    @Test
    void givenAgedBrieWithPositiveSellin_whenUpdate_thenSellinDecreasesBy1() {
        StoreItem agedBrie = StoreItemFactory.createAgedBrie(AGED_BRIE, 10, 20);
        agedBrie.updateQuality();
        assertEquals(9, agedBrie.sellIn);
    }

    @Test
    void givenAgedBrieWithSellinEquals0_whenUpdate_thenSellinDecreasesBy1() {
        StoreItem agedBrie = StoreItemFactory.createAgedBrie(AGED_BRIE, 0, 20);
        agedBrie.updateQuality();
        assertEquals(-1, agedBrie.sellIn);
    }

    @Test
    void givenAgedBrieWithNegativeSellIn_whenUpdate_thenSellinDecreasesBy1() {
        StoreItem agedBrie = StoreItemFactory.createAgedBrie(AGED_BRIE, -1, 20);
        agedBrie.updateQuality();
        assertEquals(-2, agedBrie.sellIn);
    }
}
