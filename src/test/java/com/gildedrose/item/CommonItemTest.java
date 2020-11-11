package com.gildedrose.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CommonItemTest {

    private final String COMMON_ITEM = "common item";

    @Test
    void update_whenSellInGreaterThan0_thenDecreaseQualityBy1() {
        CommonItem commonItem = new CommonItem(COMMON_ITEM, 1, 10);
        
        commonItem.updateQuality();

        assertEquals(9, commonItem.quality);
    }

    @Test
    void update_whenSellInGreaterThan0_thenDecreaseSellInBy1() {
        CommonItem commonItem = new CommonItem(COMMON_ITEM, 1, 10);

        commonItem.updateQuality();

        assertEquals(0, commonItem.sellIn);
    }

    @Test
    void update_whenSellInEquals0_thenDecreaseQualityBy2() {
        CommonItem commonItem = new CommonItem(COMMON_ITEM, 0, 10);

        commonItem.updateQuality();

        assertEquals(8, commonItem.quality);
    }

    @Test
    void givenCommonItem_whenUpdateWithSellInEquals0_thenDecrementSellIn() {
        CommonItem commonItem = new CommonItem(COMMON_ITEM, 0, 10);

        commonItem.updateQuality();

        assertEquals(-1, commonItem.sellIn);
    }

    @Test
    void givenCommonItemWithNegativeSellIn_whenUpdate_thenDecrementSellin() {
        CommonItem commonItem = new CommonItem(COMMON_ITEM, -1, 10);

        commonItem.updateQuality();

        assertEquals(-2, commonItem.sellIn);
    }

    @Test
    void givenCommonItemWithNegativeSellIn_whenUpdate_thenDecreaseQualityBy2() {
        CommonItem commonItem = new CommonItem(COMMON_ITEM, -1, 10);

        commonItem.updateQuality();

        assertEquals(8, commonItem.quality);
    }

    @Test
    void givenCommonItemWith0QualityAnd0SellIn_whenUpdate_thenQualityRemains0() {
        CommonItem commonItem = new CommonItem(COMMON_ITEM, 0, 0);

        commonItem.updateQuality();

        assertEquals(0, commonItem.quality);
    }
}
