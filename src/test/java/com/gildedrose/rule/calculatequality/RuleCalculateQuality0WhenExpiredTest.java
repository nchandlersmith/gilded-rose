package com.gildedrose.rule.calculatequality;

import com.gildedrose.rule.calculatequality.RuleCalculateQuality;
import com.gildedrose.rule.calculatequality.RuleCalculateQuality0WhenExpired;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("squid:S5838")
class RuleCalculateQuality0WhenExpiredTest {

    @Test
    void whenNotExpired_qualityUnchanged() {
        int nonexpiredSellIn = 0;
        int startingQuality = 5;
        int expectedQuality = 5;
        RuleCalculateQuality ruleCalculateQuality = new RuleCalculateQuality0WhenExpired();

        int actualQuality = ruleCalculateQuality.run(nonexpiredSellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);
    }

    @Test
    void whenSellInExpired_quality0() {
        int sellIn = -1;
        int startingQuality = 5;
        int expectedQuality = 0;
        RuleCalculateQuality ruleCalculateQuality = new RuleCalculateQuality0WhenExpired();

        int actualQuality = ruleCalculateQuality.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);
    }

    @Test
    void isEqualToItself() {
        RuleCalculateQuality ruleCalculateQuality = new RuleCalculateQuality0WhenExpired();
        //noinspection EqualsWithItself
        assertThat(ruleCalculateQuality.equals(ruleCalculateQuality)).isTrue();
    }

    @Test
    void isNotEqualToNull() {
        RuleCalculateQuality ruleCalculateQuality = new RuleCalculateQuality0WhenExpired();
        assertThat(ruleCalculateQuality.equals(null)).isFalse();
    }

    @Test
    void isNotEqualToObjectOfAnotherClass() {
        RuleCalculateQuality ruleCalculateQuality = new RuleCalculateQuality0WhenExpired();
        //noinspection EqualsBetweenInconvertibleTypes
        assertThat(ruleCalculateQuality.equals("some other class")).isFalse();
    }

    @Test
    void isEqualToObjectOfSameClass() {
        RuleCalculateQuality ruleCalculateQuality1 = new RuleCalculateQuality0WhenExpired();
        RuleCalculateQuality ruleCalculateQuality2 = new RuleCalculateQuality0WhenExpired();
        assertThat(ruleCalculateQuality1.equals(ruleCalculateQuality2)).isTrue();
    }
}