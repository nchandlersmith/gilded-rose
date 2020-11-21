package com.gildedrose.rule;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("squid:S5838")
class RuleCalculateQualityDoesNotDegradeTest {

    @Test
    void run_qualityDoesNotDegrade() {
        int sellIn = 0;
        int startingQuality = 1234;
        RuleCalculateQuality ruleCalculateQuality = new RuleCalculateQualityDoesNotDegrade();

        int actualQuality = ruleCalculateQuality.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(startingQuality);
    }

    @Test
    void run_isEqualToItself() {
        RuleCalculateQuality ruleCalculateQuality = new RuleCalculateQualityDoesNotDegrade();
        //noinspection EqualsWithItself
        assertThat(ruleCalculateQuality.equals(ruleCalculateQuality)).isTrue();
    }

    @Test
    void run_isNotEqualToNull() {
        RuleCalculateQuality ruleCalculateQuality = new RuleCalculateQualityDoesNotDegrade();
        assertThat(ruleCalculateQuality.equals(null)).isFalse();
    }

    @Test
    void run_isNotEqualToObjectOfOtherClass() {
        RuleCalculateQuality ruleCalculateQuality = new RuleCalculateQualityDoesNotDegrade();
        //noinspection EqualsBetweenInconvertibleTypes
        assertThat(ruleCalculateQuality.equals("object of some other class")).isFalse();
    }

    @Test
    void run_isEqualToOtherRuleQualityDoesNotDegradeObject() {
        RuleCalculateQuality ruleCalculateQuality1 = new RuleCalculateQualityDoesNotDegrade();
        RuleCalculateQuality ruleCalculateQuality2 = new RuleCalculateQualityDoesNotDegrade();
        assertThat(ruleCalculateQuality1.equals(ruleCalculateQuality2)).isTrue();
    }
}