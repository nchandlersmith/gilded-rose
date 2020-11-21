package com.gildedrose.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.rule.calculatequality.RuleCalculateQualityDegrades;

import org.junit.jupiter.api.Test;

class CommonItemTest {

    private final String COMMON_ITEM = "common item";

    @Test
    void update_whenSellInGreaterThan0_thenDecreaseQualityBy1() {
        StoreItem commonItem = new StoreItem.Builder()
                                        .name(COMMON_ITEM)
                                        .sellIn(1)
                                        .quality(10)
                                        .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                                        .build();

        commonItem.updateQuality();

        assertEquals(9, commonItem.quality);
    }

    @Test
    void update_whenSellInGreaterThan0_thenDecreaseSellInBy1() {
        StoreItem commonItem = new StoreItem.Builder()
                                        .name(COMMON_ITEM)
                                        .sellIn(1)
                                        .quality(10)
                                        .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                                        .build();

        commonItem.updateQuality();

        assertEquals(0, commonItem.sellIn);
    }

    @Test
    void update_whenSellInEquals0_thenDecreaseQualityBy2() {
        StoreItem commonItem = new StoreItem.Builder()
                                        .name(COMMON_ITEM)
                                        .sellIn(0)
                                        .quality(10)
                                        .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                                        .build();

        commonItem.updateQuality();

        assertEquals(8, commonItem.quality);
    }

    @Test
    void givenCommonItem_whenUpdateWithSellInEquals0_thenDecrementSellIn() {
        StoreItem commonItem = new StoreItem.Builder()
                                        .name(COMMON_ITEM)
                                        .sellIn(0)
                                        .quality(10)
                                        .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                                        .build();

        commonItem.updateQuality();

        assertEquals(-1, commonItem.sellIn);
    }

    @Test
    void givenCommonItemWithNegativeSellIn_whenUpdate_thenDecrementSellin() {
        StoreItem commonItem = new StoreItem.Builder()
                                        .name(COMMON_ITEM)
                                        .sellIn(-1)
                                        .quality(10)
                                        .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                                        .build();

        commonItem.updateQuality();

        assertEquals(-2, commonItem.sellIn);
    }

    @Test
    void givenCommonItemWithNegativeSellIn_whenUpdate_thenDecreaseQualityBy2() {
        StoreItem commonItem = new StoreItem.Builder()
                                        .name(COMMON_ITEM)
                                        .sellIn(-1)
                                        .quality(10)
                                        .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                                        .build();

        commonItem.updateQuality();

        assertEquals(8, commonItem.quality);
    }

    @Test
    void givenCommonItemWith0QualityAnd0SellIn_whenUpdate_thenQualityRemains0() {
        StoreItem commonItem = new StoreItem.Builder()
                                        .name(COMMON_ITEM)
                                        .sellIn(0)
                                        .quality(0)
                                        .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                                        .build();

        commonItem.updateQuality();

        assertEquals(0, commonItem.quality);
    }
}
