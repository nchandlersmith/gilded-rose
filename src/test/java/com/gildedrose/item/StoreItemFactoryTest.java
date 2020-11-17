package com.gildedrose.item;

import com.gildedrose.rule.Rule;
import com.gildedrose.rule.RuleQualityDegrades;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StoreItemFactoryTest {

    @Test
    void createCommonItem_returnsCommonItem() {
        String expectedItemName = "some common item";
        int expectedSellIn = 11;
        int expectedQuality = 22;
        Rule ruleItemDegrades = new RuleQualityDegrades(1);
        StoreItem builderCommonItem = new StoreItem.Builder()
                .name(expectedItemName)
                .sellIn(expectedSellIn)
                .quality(expectedQuality)
                .ruleCalculateQuality(ruleItemDegrades)
                .build();

        StoreItem factoyCommonItem = StoreItemFactory.createCommonItem(expectedItemName, expectedSellIn, expectedQuality);

        assertEquals(builderCommonItem, factoyCommonItem);
    }
}
