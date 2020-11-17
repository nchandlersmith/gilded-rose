package com.gildedrose.item;

import com.gildedrose.rule.RuleQualityDegrades;

public class StoreItemFactory {

    public static StoreItem createCommonItem(String name, int sellIn, int quality) {
        return new StoreItem.Builder()
                .name(name)
                .sellIn(sellIn)
                .quality(quality)
                .ruleCalculateQuality(new RuleQualityDegrades(1))
                .build();
    }
}
