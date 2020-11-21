package com.gildedrose.rule.calculatequality;

import com.gildedrose.rule.calculatequality.RuleCalculateQualityImproves;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("squid:S5838")
class RuleCalculateQualityImprovesTest {

    @SuppressWarnings("squid:S5838")
    @Test
    void run_improvesQuality() {
        int startingQuality = 123;
        int expectedQuality = 124;
        int sellIn = 1;
        int increaseQuality = 1;
        RuleCalculateQualityImproves rule = new RuleCalculateQualityImproves(increaseQuality);

        int actualQuality = rule.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);

    }

    @Test
    void run_improvesQualityBySpecifiedAmount() {
        int startingQuality = 1234;
        int expectedQuality = 1244;
        int sellIn = 1;
        int increaseQuality = 10;
        RuleCalculateQualityImproves rule = new RuleCalculateQualityImproves(increaseQuality);

        int actualQuality = rule.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);

    }

    @Test
    void run_whenExpiredDoublesImprovedAmount() {
        int startingQuality = 123;
        int expectedQuality = 143;
        int sellIn = -1;
        int increasedQuality = 10;
        RuleCalculateQualityImproves rule = new RuleCalculateQualityImproves(increasedQuality);

        int actualQuality = rule.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);

    }

    @Test
    void ruleQualityImproves_isEqualToItself() {
        RuleCalculateQualityImproves rule = new RuleCalculateQualityImproves(1);

        //noinspection EqualsWithItself
        assertThat(rule.equals(rule)).isTrue();

    }

    @Test
    void ruleQualityImproves_notEqualToNull() {
        RuleCalculateQualityImproves rule = new RuleCalculateQualityImproves(1);
        assertThat(rule.equals(null)).isFalse();

    }

    @Test
    void ruleQualityImproves_notEqualToObjectOfOtherClass() {
        RuleCalculateQualityImproves rule = new RuleCalculateQualityImproves(1);

        //noinspection EqualsBetweenInconvertibleTypes
        assertThat(rule.equals("object from some other class")).isFalse();

    }

    @Test
    void twoRuleQualityImproves_areEqual_whenTheirFieldsAreEqual() {
        RuleCalculateQualityImproves rule1 = new RuleCalculateQualityImproves(1);
        RuleCalculateQualityImproves rule2 = new RuleCalculateQualityImproves(1);

        assertThat(rule1.equals(rule2)).isTrue();

    }
    
}
