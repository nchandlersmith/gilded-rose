package com.gildedrose.rule;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RuleQualityDegradesTest {
    
    @Test
    void run_degradesQuality() {
        int startingQuality = 1234;
        int expectedQuality = 1233;
        int amountToDegrade = 1;
        int sellIn = 123;
        RuleQualityDegrades ruleQualityDegrades = new RuleQualityDegrades(amountToDegrade);

        int actualQuality = ruleQualityDegrades.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);

    }

    @Test
    void run_degradesQualityBySpecifiedAmount() {
        int startingQuality = 1234;
        int expectedQuality = 1232;
        int amountToDegrade = 2;
        int sellIn = 123;
        RuleQualityDegrades ruleQualityDegrades = new RuleQualityDegrades(amountToDegrade);

        int actualQuality = ruleQualityDegrades.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);

    }

    @Test
    void run_whenExpiredDoublesDegradeAmount() {
        int startingQuality = 1234;
        int expectedQuality = 1230;
        int amountToDegrade = 2;
        int sellIn = -1;
        RuleQualityDegrades ruleQualityDegrades = new RuleQualityDegrades(amountToDegrade);

        int actualQuality = ruleQualityDegrades.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);

    }

    @Test
    void twoRuleQualityDegradesAreEqualWhenTheirAmountToDegradeAreEqual() {
        Rule rule1 = new RuleQualityDegrades(1);
        Rule rule2 = new RuleQualityDegrades(1);

        assertThat(rule1.equals(rule2)).isTrue();

    }

    @Test
    void ruleQualityDegradesIsEqualToItself() {
        Rule rule = new RuleQualityDegrades(1);

        //noinspection EqualsWithItself
        assertThat(rule.equals(rule)).isTrue();

    }

    @Test
    void ruleQualityDegradesIsNotEqualToNull() {
        Rule rule = new RuleQualityDegrades(1);

        assertThat(rule.equals(null)).isFalse();

    }

    @Test
    void ruleQualityDegradesIsNotEqualAnObjectOfAnotherClass() {
        Rule rule = new RuleQualityDegrades(1);

        //noinspection EqualsBetweenInconvertibleTypes
        assertThat(rule.equals("object from some other class")).isFalse();

    }
}
