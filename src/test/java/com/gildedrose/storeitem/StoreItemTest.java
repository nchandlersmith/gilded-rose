package com.gildedrose.storeitem;

import com.gildedrose.rule.calculatequality.RuleCalculateQualityDegrades;
import com.gildedrose.rule.qualitybounds.RuleQualityBoundsInRange;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
                .ruleQualityBounds(new RuleQualityBoundsInRange(1,6))
                .build();

        StoreItem item2 = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(1,6))
                .build();

        assertThat(item1.equals(item2)).isTrue();
    }

    @Test
    void twoStoreItemsAreNotEqualWhenTheirQualityCalculationRulesAreNotEqual() {
        StoreItem item1 = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(2))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 30))
                .build();

        StoreItem item2 = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 30))
                .build();

        assertThat(item1.equals(item2)).isFalse();
    }

    @Test
    void twoStoreItemsAreNotEqualWhenTheirQualityBoundsRulesAreNotEqual() {
        StoreItem item1 = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(25, 30))
                .build();

        StoreItem item2 = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(15, 30))
                .build();

        assertThat(item1.equals(item2)).isFalse();
    }

    @Test
    void twoStoreItemsAreNotEqualWhenTheirNamesAreNotEqual() {
        StoreItem item1 = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .build();

        StoreItem item2 = new StoreItem.Builder()
                .name("some other item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .build();

        assertThat(item1.equals(item2)).isFalse();
    }

    @Test
    void twoStoreItemsAreNotEqualWhenTheirSellInValuesAreNotEqual() {
        StoreItem item1 = new StoreItem.Builder()
                .name("some item")
                .sellIn(10)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .build();

        StoreItem item2 = new StoreItem.Builder()
                .name("some item")
                .sellIn(0)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .build();

        assertThat(item1.equals(item2)).isFalse();
    }

    @Test
    void twoStoreItemsAreNotEqualWhenTheirQualityValuesAreNotEqual() {
        StoreItem item1 = new StoreItem.Builder()
                .name("some item")
                .sellIn(10)
                .quality(100)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .build();

        StoreItem item2 = new StoreItem.Builder()
                .name("some item")
                .sellIn(10)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .build();

        assertThat(item1.equals(item2)).isFalse();
    }
}