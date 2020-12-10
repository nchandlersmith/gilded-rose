package com.gildedrose.storeitem;

import com.gildedrose.rule.calculatequality.RuleCalculateQualityDegrades;
import com.gildedrose.rule.calculatesellin.RuleSellInDecrements;
import com.gildedrose.rule.calculatesellin.RuleSellInDoesNotChange;
import com.gildedrose.rule.qualitybounds.RuleQualityBoundsInRange;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StoreItemTest {

    @Test
    void storeItemIsEqualToItself() {
        StoreItem item = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .build();

        assertThat(item).isEqualTo(item);
    }

    @Test
    void storeItemIsNotEqualToNull() {
        StoreItem item = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .build();

        assertThat(item).isNotEqualTo(null);
    }

    @Test
    void storeItemIsNotEqualToItemOfDifferentClass() {
        StoreItem item = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .build();

        assertThat(item).isNotEqualTo("some object not an item");
    }

    @Test
    void twoStoreItemsAreEqualWhenTheirFieldsAreEqual() {
        StoreItem item1 = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(1,6))
                .ruleCalculateSellin(new RuleSellInDecrements())
                .build();

        StoreItem item2 = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(1,6))
                .ruleCalculateSellin(new RuleSellInDecrements())
                .build();

        assertThat(item1).isEqualTo(item2);
    }

    @Test
    void twoStoreItemsAreNotEqualWhenTheirQualityCalculationRulesAreNotEqual() {
        StoreItem item1 = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(2))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 30))
                .ruleCalculateSellin(new RuleSellInDecrements())
                .build();

        StoreItem item2 = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 30))
                .ruleCalculateSellin(new RuleSellInDecrements())
                .build();

        assertThat(item1).isNotEqualTo(item2);
    }

    @Test
    void twoStoreItemsAreNotEqualWhenTheirQualityBoundsRulesAreNotEqual() {
        StoreItem item1 = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(25, 30))
                .ruleCalculateSellin(new RuleSellInDoesNotChange())
                .build();

        StoreItem item2 = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(15, 30))
                .ruleCalculateSellin(new RuleSellInDoesNotChange())
                .build();

        assertThat(item1).isNotEqualTo(item2);
    }

    @Test
    void twoStoreItemsAreNotEqualWhenTheirNamesAreNotEqual() {
        StoreItem item1 = new StoreItem.Builder()
                .name("some item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .ruleCalculateSellin(new RuleSellInDoesNotChange())
                .build();

        StoreItem item2 = new StoreItem.Builder()
                .name("some other item")
                .sellIn(1)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .ruleCalculateSellin(new RuleSellInDoesNotChange())
                .build();

        assertThat(item1).isNotEqualTo(item2);
    }

    @Test
    void twoStoreItemsAreNotEqualWhenTheirSellInValuesAreNotEqual() {
        StoreItem item1 = new StoreItem.Builder()
                .name("some item")
                .sellIn(10)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .ruleCalculateSellin(new RuleSellInDoesNotChange())
                .build();

        StoreItem item2 = new StoreItem.Builder()
                .name("some item")
                .sellIn(0)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .ruleCalculateSellin(new RuleSellInDoesNotChange())
                .build();

        assertThat(item1).isNotEqualTo(item2);
    }

    @Test
    void twoStoreItemsAreNotEqualWhenTheirQualityValuesAreNotEqual() {
        StoreItem item1 = new StoreItem.Builder()
                .name("some item")
                .sellIn(10)
                .quality(100)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .ruleCalculateSellin(new RuleSellInDoesNotChange())
                .build();

        StoreItem item2 = new StoreItem.Builder()
                .name("some item")
                .sellIn(10)
                .quality(5)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .ruleCalculateSellin(new RuleSellInDoesNotChange())
                .build();

        assertThat(item1).isNotEqualTo(item2);
    }

    @Test
    void twoStoreItemsAreNotEqualWhenTheirCalculateSellInRulesAreNotEqual() {
        StoreItem item1 = new StoreItem.Builder()
                .name("some item")
                .sellIn(10)
                .quality(100)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .ruleCalculateSellin(new RuleSellInDecrements())
                .build();

        StoreItem item2 = new StoreItem.Builder()
                .name("some item")
                .sellIn(10)
                .quality(100)
                .ruleCalculateQuality(new RuleCalculateQualityDegrades(1))
                .ruleQualityBounds(new RuleQualityBoundsInRange(0, 50))
                .ruleCalculateSellin(new RuleSellInDoesNotChange())
                .build();

        assertThat(item1).isNotEqualTo(item2);
    }
}