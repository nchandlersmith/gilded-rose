package com.gildedrose.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.rule.RuleQualityImproves;
import org.junit.jupiter.api.Test;

class AgedBrieTest {

    private final String AGED_BRIE = "Aged Brie";

    @Test
    void givenAgedBrieWithPositiveSellIn_whenUpdate_thenQualityIncreasesBy1() {
        StoreItem agedBrie = new StoreItem.Builder()
                .name(AGED_BRIE)
                .sellIn(5)
                .quality(20)
                .ruleCalculateQuality(new RuleQualityImproves(1))
                .build();

        agedBrie.updateQuality();

        assertEquals(21, agedBrie.quality);
    }

    @Test
    void givenAgedBrieWithSellInEquals0_whenUpdate_thenQualityIncreasesBy2() {
        StoreItem agedBrie = new StoreItem.Builder()
                .name(AGED_BRIE)
                .sellIn(0)
                .quality(20)
                .ruleCalculateQuality(new RuleQualityImproves(1))
                .build();

        agedBrie.updateQuality();

        assertEquals(22, agedBrie.quality);
    }

    @Test
    void givenAgedBrieWithNegativeSellIn_whenUpdate_thenQualityIncreasesBy2() {
        StoreItem agedBrie = new StoreItem.Builder()
                .name(AGED_BRIE)
                .sellIn(-1)
                .quality(20)
                .ruleCalculateQuality(new RuleQualityImproves(1))
                .build();

        agedBrie.updateQuality();

        assertEquals(22, agedBrie.quality);
    }

    @Test
    void givenAgedBrie_whenUpdate_thenQualityCannotBeGreaterThan50() {
        StoreItem agedBrie = new StoreItem.Builder()
                .name(AGED_BRIE)
                .sellIn(-1)
                .quality(50)
                .ruleCalculateQuality(new RuleQualityImproves(1))
                .build();

        agedBrie.updateQuality();

        assertEquals(50, agedBrie.quality);
    }

    @Test
    void givenAgedBrieWithPositiveSellin_whenUpdate_thenSellinDecreasesBy1() {
        StoreItem agedBrie = new StoreItem.Builder()
                .name(AGED_BRIE)
                .sellIn(10)
                .quality(20)
                .ruleCalculateQuality(new RuleQualityImproves(1))
                .build();

        agedBrie.updateQuality();

        assertEquals(9, agedBrie.sellIn);
    }

    @Test
    void givenAgedBrieWithSellinEquals0_whenUpdate_thenSellinDecreasesBy1() {
        StoreItem agedBrie = new StoreItem.Builder()
                .name(AGED_BRIE)
                .sellIn(0)
                .quality(20)
                .ruleCalculateQuality(new RuleQualityImproves(1))
                .build();

        agedBrie.updateQuality();

        assertEquals(-1, agedBrie.sellIn);
    }

    @Test
    void givenAgedBrieWithNegativeSellIn_whenUpdate_thenSellinDecreasesBy1() {
        StoreItem agedBrie = new StoreItem.Builder()
                .name(AGED_BRIE)
                .sellIn(-1)
                .quality(20)
                .ruleCalculateQuality(new RuleQualityImproves(1))
                .build();

        agedBrie.updateQuality();

        assertEquals(-2, agedBrie.sellIn);
    }
}
