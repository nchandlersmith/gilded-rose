package com.gildedrose.rule.qualitybounds;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("squid:S5838")
class RuleQualityBoundsInRangeTest {

    @Test
    void run_doesNotAllowValueLesserThanMinimum() {
        int startingQuality = 123;
        int minimumAllowedValue = 234;
        int maximumAllowedValue = 345;
        RuleQualityBounds rule = new RuleQualityBoundsInRange(minimumAllowedValue, maximumAllowedValue);

        int actualQuality = rule.run(startingQuality);

        assertThat(actualQuality).isEqualTo(minimumAllowedValue);
    }

    @Test
    void run_doesNotAllowValueGreaterThanMaximum() {
        int startingQuality = 456;
        int minimumAllowedValue = 234;
        int maximumAllowedValue = 345;
        RuleQualityBounds rule = new RuleQualityBoundsInRange(minimumAllowedValue, maximumAllowedValue);

        int actualQuality = rule.run(startingQuality);

        assertThat(actualQuality).isEqualTo(maximumAllowedValue);
    }

    @Test
    void isEqualToItself() {
        RuleQualityBounds rule = new RuleQualityBoundsInRange(123, 456);
        //noinspection EqualsWithItself
        assertThat(rule.equals(rule)).isTrue();
    }

    @Test
    void isNotEqualToNull() {
        RuleQualityBounds rule = new RuleQualityBoundsInRange(123, 456);
        assertThat(rule.equals(null)).isFalse();
    }

    @Test
    void isNotEqualObjectofOtherClass() {
        RuleQualityBounds rule = new RuleQualityBoundsInRange(123, 456);
        //noinspection EqualsBetweenInconvertibleTypes
        assertThat(rule.equals("some other class")).isFalse();
    }

    @Test
    void isEqualToRuleQualityBoundsInRangeWithSameFieldValues() {
        RuleQualityBounds rule1 = new RuleQualityBoundsInRange(123, 456);
        RuleQualityBounds rule2 = new RuleQualityBoundsInRange(123, 456);
        assertThat(rule1.equals(rule2)).isTrue();
    }

    @Test
    void isNotEqualToRuleQualityBoundsInRangeWithDifferentFieldValues() {
        RuleQualityBounds rule1 = new RuleQualityBoundsInRange(234, 456);
        RuleQualityBounds rule2 = new RuleQualityBoundsInRange(123, 456);
        assertThat(rule1.equals(rule2)).isFalse();
    }
}
