package com.gildedrose.rule;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("squid:S5838")
class RuleQualityDoesNotDegradeTest {

    @Test
    void run_qualityDoesNotDegrade() {
        int sellIn = 0;
        int startingQuality = 1234;
        Rule rule = new RuleQualityDoesNotDegrade();

        int actualQuality = rule.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(startingQuality);
    }

    @Test
    void run_isEqualToItself() {
        Rule rule = new RuleQualityDoesNotDegrade();
        //noinspection EqualsWithItself
        assertThat(rule.equals(rule)).isTrue();
    }

    @Test
    void run_isNotEqualToNull() {
        Rule rule = new RuleQualityDoesNotDegrade();
        assertThat(rule.equals(null)).isFalse();
    }

    @Test
    void run_isNotEqualToObjectOfOtherClass() {
        Rule rule = new RuleQualityDoesNotDegrade();
        //noinspection EqualsBetweenInconvertibleTypes
        assertThat(rule.equals("object of some other class")).isFalse();
    }

    @Test
    void run_isEqualToOtherRuleQualityDoesNotDegradeObject() {
        Rule rule1 = new RuleQualityDoesNotDegrade();
        Rule rule2 = new RuleQualityDoesNotDegrade();
        assertThat(rule1.equals(rule2)).isTrue();
    }
}