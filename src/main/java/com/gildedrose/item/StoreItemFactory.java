package com.gildedrose.item;

import com.gildedrose.rule.Rule0QualityWhenExpired;
import com.gildedrose.rule.RuleQualityDegrades;
import com.gildedrose.rule.RuleQualityImproves;
import com.gildedrose.rule.RuleQualityImprovesTiered;
import com.gildedrose.rule.RuleQualityDoesNotDegrade;

public class StoreItemFactory {

    private StoreItemFactory() {
    }

    public static StoreItem createCommonItem(String name, int sellIn, int quality) {
        return new StoreItem.Builder()
                .name(name)
                .sellIn(sellIn)
                .quality(quality)
                .ruleCalculateQuality(new RuleQualityDegrades(1))
                .build();
    }

    public static StoreItem createAgedBrie(String name, int sellIn, int quality) {
        return new StoreItem.Builder()
                .name(name)
                .sellIn(sellIn)
                .quality(quality)
                .ruleCalculateQuality(new RuleQualityImproves(1))
                .build();
    }

    public static StoreItem createConjuredItem(String name, int sellIn, int quality) {
        return new StoreItem.Builder()
                .name(name)
                .sellIn(sellIn)
                .quality(quality)
                .ruleCalculateQuality(new RuleQualityDegrades(2))
                .build();
    }

    public static StoreItem createPass(String name, int sellIn, int quality) {
    return new StoreItem.Builder()
            .name(name)
            .sellIn(sellIn)
            .quality(quality)
            .ruleCalculateQuality(new RuleQualityImprovesTiered())
            .expirationRule(new Rule0QualityWhenExpired())
            .build();
    }

    @SuppressWarnings("squid S:71122")
    public static StoreItem createSulfuras(String expectedItemName, int expectedSellIn, int startingBadQuality) {
        final int sulfurasQualityIsAlways = 80;
        return new StoreItem.Builder()
                .name(expectedItemName)
                .sellIn(expectedSellIn)
                .quality(sulfurasQualityIsAlways)
                .ruleCalculateQuality(new RuleQualityDoesNotDegrade())
                .build();
    }
}
