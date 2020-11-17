package com.gildedrose.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class RuleQualityDegradesTest {
    
    @Test
    void run_degradesQuality() {
        int startingQuality = 1234;
        int expectedQuality = 1233;
        int amountToDegrade = 1;
        int sellIn = 123;
        RuleQualityDegrades ruleQualityDegrades = new RuleQualityDegrades(amountToDegrade);

        int actualQuality = ruleQualityDegrades.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    void run_degradesQualityBySpecifiedAmount() {
        int startingQuality = 1234;
        int expectedQuality = 1232;
        int amountToDegrade = 2;
        int sellIn = 123;
        RuleQualityDegrades ruleQualityDegrades = new RuleQualityDegrades(amountToDegrade);

        int actualQuality = ruleQualityDegrades.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);

    }

    @Test
    void run_whenExpiredDoublesDegradeAmount() {
        int startingQuality = 1234;
        int expectedQuality = 1230;
        int amountToDegrade = 2;
        int sellIn = -1;
        RuleQualityDegrades ruleQualityDegrades = new RuleQualityDegrades(amountToDegrade);

        int actualQuality = ruleQualityDegrades.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);

    }

    @Test
    void twoRuleQualityDegradesAreEqualWhenTheirAmountToDegradeAreEqual() {
        Rule rule1 = new RuleQualityDegrades(1);
        Rule rule2 = new RuleQualityDegrades(1);

        assertEquals(rule1, rule2);
    }
    
    @Test
    void ruleQualityDegradesIsEqualToItself() {
        Rule rule1 = new RuleQualityDegrades(1);

        assertEquals(rule1, rule1);

    }

    @Test
    void ruleQualityDegradesIsNotEqualToNull() {
        Rule rule1 = new RuleQualityDegrades(1);

        assertFalse(rule1.equals(null));

    }

    @Test
    void ruleQualityDegradesIsNotEqualAnObjectOfAnotherClass() {
        Rule rule1 = new RuleQualityDegrades(1);
        Rule rule2 = new RuleQualityImproves(1);

        assertFalse(rule1.equals(rule2));

    }
}
