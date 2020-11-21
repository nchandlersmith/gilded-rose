package com.gildedrose.item;

import com.gildedrose.rule.RuleCalculateQualityDegrades;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("squid:S5838")
class StoreItemTest {

    @Test
    void storeItemIsEqualToItself() {
        StoreItem item = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .build();

        //noinspection EqualsWithItself
        assertThat(item.equals(item)).isTrue();
    }

    @Test
    void storeItemIsNotEqualToNull() {
        StoreItem item = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .build();

        assertThat(item.equals(null)).isFalse();
    }

    @Test
    void storeItemIsNotEqualToItemOfDifferentClass() {
        StoreItem item = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .build();

        //noinspection EqualsBetweenInconvertibleTypes
        assertThat(item.equals("some object not an item")).isFalse();
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

        assertThat(item1.equals(item2)).isTrue();
    }

}