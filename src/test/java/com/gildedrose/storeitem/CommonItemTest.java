package com.gildedrose.storeitem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CommonItemTest {

    private final String COMMON_ITEM = "common item";

    @Test
    void update_whenSellInGreaterThan0_thenDecreaseQualityBy1() {
        StoreItem commonItem = StoreItemFactory.createCommonItem(COMMON_ITEM, 1, 10);
        commonItem.updateQuality();
        assertEquals(9, commonItem.quality);
    }

    @Test
    void update_whenSellInGreaterThan0_thenDecreaseSellInBy1() {
        StoreItem commonItem = StoreItemFactory.createCommonItem(COMMON_ITEM, 1, 10);
        commonItem.updateQuality();
        assertEquals(0, commonItem.sellIn);
    }

    @Test
    void update_whenSellInEquals0_thenDecreaseQualityBy2() {
        StoreItem commonItem = StoreItemFactory.createCommonItem(COMMON_ITEM, 0, 10);
        commonItem.updateQuality();
        assertEquals(8, commonItem.quality);
    }

    @Test
    void givenCommonItem_whenUpdateWithSellInEquals0_thenDecrementSellIn() {
        StoreItem commonItem = StoreItemFactory.createCommonItem(COMMON_ITEM, 0, 10);
        commonItem.updateQuality();
        assertEquals(-1, commonItem.sellIn);
    }

    @Test
    void givenCommonItemWithNegativeSellIn_whenUpdate_thenDecrementSellin() {
        StoreItem commonItem = StoreItemFactory.createCommonItem(COMMON_ITEM, -1, 10);
        commonItem.updateQuality();
        assertEquals(-2, commonItem.sellIn);
    }

    @Test
    void givenCommonItemWithNegativeSellIn_whenUpdate_thenDecreaseQualityBy2() {
        StoreItem commonItem = StoreItemFactory.createCommonItem(COMMON_ITEM, -1, 10);
        commonItem.updateQuality();
        assertEquals(8, commonItem.quality);
    }

    @Test
    void givenCommonItem_qualityCannotBNegative() {
        StoreItem commonItem = StoreItemFactory.createCommonItem(COMMON_ITEM, -1, 0);
        commonItem.updateQuality();
        assertEquals(0, commonItem.quality);
    }
}