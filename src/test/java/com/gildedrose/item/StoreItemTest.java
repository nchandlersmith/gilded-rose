package com.gildedrose.item;

import com.gildedrose.rule.RuleCalculateQualityDegrades;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreItemTest {

    @Test
    void storeItemIsEqualToItself() {
        StoreItem item = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .build();

        assertEquals(item, item);
    }

    @Test
    void storeItemIsNotEqualToNull() {
        StoreItem item = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .build();

        assertNotEquals(item, null);
    }

    @Test
    void storeItemIsNotEqualToItemOfDifferentClass() {
        StoreItem item = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .build();

        assertNotEquals("not an item", item);
    }

    @Test
    void twoStoreItemsAreEqualWhenTheirFieldsAreEqual() {
        StoreItem item1 = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .build();

        StoreItem item2 = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .build();

        assertEquals(item1, item2);
    }

}