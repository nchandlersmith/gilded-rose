package com.gildedrose.item;

import com.gildedrose.rule.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StoreItemFactoryTest {

    @Test
    void createCommonItem_returnsCommonItem() {
        String expectedItemName = "some common item";
        int expectedSellIn = 11;
        int expectedQuality = 22;
        RuleCalculateQuality ruleCalculateQualityItemDegrades = new RuleCalculateQualityDegrades(1);
        StoreItem builderCommonItem = new StoreItem.Builder()
                .name(expectedItemName)
                .sellIn(expectedSellIn)
                .quality(expectedQuality)
                .ruleCalculateQuality(ruleCalculateQualityItemDegrades)
                .build();

        StoreItem factoyCommonItem = StoreItemFactory.createCommonItem(expectedItemName, expectedSellIn, expectedQuality);

        assertThat(factoyCommonItem).isEqualTo(builderCommonItem);
    }

    @Test
    void createAgedBrie_returnsAgedBrie() {
        String expectedItemName = "aged brie item";
        int exppectedSellIn = 11;
        int expectedQuality = 13;
        StoreItem builderAgedBrie = new StoreItem.Builder()
                .name(expectedItemName)
                .sellIn(exppectedSellIn)
                .quality(expectedQuality)
                .ruleCalculateQuality(new RuleCalculateQualityImproves(1))
                .build();

        StoreItem factoryAgedBrie = StoreItemFactory.createAgedBrie(expectedItemName, exppectedSellIn, expectedQuality);

        assertThat(factoryAgedBrie).isEqualTo(builderAgedBrie);
    }

    @Test
    void createConjuredItem_returnsConjuredItem() {
        String expectedItemName = "some conjured item";
        int expectedSellIn = 11;
        int expectedQuality = 13;
        StoreItem builderConjuredItem = new StoreItem.Builder()
                .name(expectedItemName)
                .sellIn(expectedSellIn)
                .quality(expectedQuality)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(2))
                .build();

        StoreItem factoryConjuredItem = StoreItemFactory.createConjuredItem(expectedItemName, expectedSellIn, expectedQuality);

        assertThat(factoryConjuredItem).isEqualTo(builderConjuredItem);
    }

    @Test
    void createPassItem_returnsPassItem() {
        String expectedItemName = "some pass";
        int expectedSellIn = 21;
        int expectedQuality = 12;
        StoreItem builderPassItem = new StoreItem.Builder()
                .name(expectedItemName)
                .sellIn(expectedSellIn)
                .quality(expectedQuality)
                .ruleCalculateQuality(new RuleCalculateQualityImprovesTiered())
                .build();

        StoreItem factoryPassItem = StoreItemFactory.createPass(expectedItemName, expectedSellIn, expectedQuality);

        assertThat(factoryPassItem).isEqualTo(builderPassItem);
    }

    @Test
    void createSulfuras_returnsSulfurasItem() {
        String expectedItemName = "sulfuras";
        int expectedSellIn = 34;
        int startingBadQuality = 75;
        int expectedQuality = 80;
        StoreItem builderSulfuras = new StoreItem.Builder()
                .name(expectedItemName)
                .sellIn(expectedSellIn)
                .quality(expectedQuality)
                .ruleCalculateQuality(new RuleCalculateQualityDoesNotDegrade())
                .build();

        StoreItem factorySulfuras = StoreItemFactory.createSulfuras(expectedItemName, expectedSellIn);

        assertThat(factorySulfuras).isEqualTo(builderSulfuras);
    }
}
