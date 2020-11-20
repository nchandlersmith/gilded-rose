package com.gildedrose.rule;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RuleQualityImprovesTest {

    @Test
    void run_improvesQuality() {
        int startingQuality = 123;
        int expectedQuality = 124;
        int sellIn = 1;
        int increaseQuality = 1;
        RuleQualityImproves rule = new RuleQualityImproves(increaseQuality);

        int actualQuality = rule.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);

    }

    @Test
    void run_improvesQualityBySpecifiedAmount() {
        int startingQuality = 1234;
        int expectedQuality = 1244;
        int sellIn = 1;
        int increaseQuality = 10;
        RuleQualityImproves rule = new RuleQualityImproves(increaseQuality);

        int actualQuality = rule.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);

    }

    @Test
    void run_whenExpiredDoublesImprovedAmount() {
        int startingQuality = 123;
        int expectedQuality = 143;
        int sellIn = -1;
        int increasedQuality = 10;
        RuleQualityImproves rule = new RuleQualityImproves(increasedQuality);

        int actualQuality = rule.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);

    }

    @Test
    void ruleQualityImproves_isEqualToItself() {
        RuleQualityImproves rule = new RuleQualityImproves(1);

        //noinspection EqualsWithItself
        assertThat(rule.equals(rule)).isTrue();

    }

    @Test
    void ruleQualityImproves_notEqualToNull() {
        RuleQualityImproves rule = new RuleQualityImproves(1);
        assertThat(rule.equals(null)).isFalse();

    }

    @Test
    void ruleQualityImproves_notEqualToObjectOfOtherClass() {
        RuleQualityImproves rule = new RuleQualityImproves(1);

        //noinspection EqualsBetweenInconvertibleTypes
        assertThat(rule.equals("object from some other class")).isFalse();

    }

    @Test
    void twoRuleQualityImproves_areEqual_whenTheirFieldsAreEqual() {
        RuleQualityImproves rule1 = new RuleQualityImproves(1);
        RuleQualityImproves rule2 = new RuleQualityImproves(1);

        assertThat(rule1.equals(rule2)).isTrue();

    }
    
}
