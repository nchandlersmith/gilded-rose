package com.gildedrose.storeitem;

import com.gildedrose.rule.calculatequality.RuleCalculateQualityDegrades;
import com.gildedrose.rule.calculatequality.RuleCalculateQualityImproves;
import com.gildedrose.rule.calculatequality.RuleCalculateQualityImprovesTiered;
import com.gildedrose.rule.calculatequality.RuleCalculateQualityDoesNotDegrade;
import com.gildedrose.rule.calculatesellin.RuleSellInDecrements;
import com.gildedrose.rule.calculatesellin.RuleSellInDoesNotChange;
import com.gildedrose.rule.qualitybounds.RuleQualityBoundsInRange;

public class StoreItemFactory {

    private StoreItemFactory() {
    }

    public static StoreItem createCommonItem(String name, int sellIn, int quality) {
        return new StoreItem.Builder()
                .name(name)
                .sellIn(sellIn)
                .quality(quality)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .ruleCalculateSellin(new RuleSellInDecrements())
                .build();
    }

    public static StoreItem createAgedBrie(String name, int sellIn, int quality) {
        return new StoreItem.Builder()
                .name(name)
                .sellIn(sellIn)
                .quality(quality)
                .ruleCalculateQuality(new RuleCalculateQualityImproves(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .ruleCalculateSellin(new RuleSellInDecrements())
                .build();
    }

    public static StoreItem createConjuredItem(String name, int sellIn, int quality) {
        return new StoreItem.Builder()
                .name(name)
                .sellIn(sellIn)
                .quality(quality)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(2))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .ruleCalculateSellin(new RuleSellInDecrements())
                .build();
    }

    public static StoreItem createPass(String name, int sellIn, int quality) {
    return new StoreItem.Builder()
            .name(name)
            .sellIn(sellIn)
            .quality(quality)
            .ruleCalculateQuality(new RuleCalculateQualityImprovesTiered())
            .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
            .ruleCalculateSellin(new RuleSellInDecrements())
            .build();
    }

    public static StoreItem createSulfuras(String expectedItemName, int expectedSellIn) {
        final int sulfurasQualityIsAlways = 80;
        return new StoreItem.Builder()
                .name(expectedItemName)
                .sellIn(expectedSellIn)
                .quality(sulfurasQualityIsAlways)
                .ruleCalculateQuality(new RuleCalculateQualityDoesNotDegrade())
                .ruleQualityBounds(new RuleQualityBoundsInRange(80, 80))
                .ruleCalculateSellin(new RuleSellInDoesNotChange())
                .build();
    }
}
