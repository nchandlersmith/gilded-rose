package com.gildedrose.rule;

import org.junit.jupiter.api.Test;

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

        assertNotEquals(rule1, null);

    }

    @Test
    void ruleQualityDegradesIsNotEqualAnObjectOfAnotherClass() {
        Rule rule1 = new RuleQualityDegrades(1);
        Rule rule2 = new RuleQualityImproves(1);

        assertNotEquals(rule2, rule1);

    }
}