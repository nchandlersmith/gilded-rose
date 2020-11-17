package com.gildedrose.item;

import com.gildedrose.rule.Rule;
import com.gildedrose.rule.RuleQualityDegrades;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreItemFactoryTest {

    @Test
    public void createCommonItem_returnsCommonItem() {
        String expectedItemName = "some common item";
        int expectedSellIn = 11;
        int expectedQuality = 22;
        Rule ruleItemDegrades = new RuleQualityDegrades(1);

        StoreItem commonItem = StoreItemFactory.createCommonItem(expectedItemName, expectedSellIn, expectedQuality);

        assertEquals(expectedItemName, commonItem.name);
        assertEquals(expectedSellIn, commonItem.sellIn);
        assertEquals(expectedQuality, commonItem.quality);
        assertEquals(ruleItemDegrades, commonItem.getCalculatedQualityRule());
    }
}
