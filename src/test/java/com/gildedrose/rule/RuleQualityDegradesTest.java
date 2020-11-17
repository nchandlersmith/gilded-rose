package com.gildedrose.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RuleQualityDegradesTest {
    
    @Test
    public void run_degradesQuality() {
        int startingQuality = 1234;
        int expectedQuality = 1233;
        int amountToDegrade = 1;
        int sellIn = 123;
        RuleQualityDegrades ruleQualityDegrades = new RuleQualityDegrades(amountToDegrade);

        int actualQuality = ruleQualityDegrades.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void run_degradesQualityBySpecifiedAmount() {
        int startingQuality = 1234;
        int expectedQuality = 1232;
        int amountToDegrade = 2;
        int sellIn = 123;
        RuleQualityDegrades ruleQualityDegrades = new RuleQualityDegrades(amountToDegrade);

        int actualQuality = ruleQualityDegrades.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);

    }

    @Test
    public void run_whenExpiredDoublesDegradeAmount() {
        int startingQuality = 1234;
        int expectedQuality = 1230;
        int amountToDegrade = 2;
        int sellIn = -1;
        RuleQualityDegrades ruleQualityDegrades = new RuleQualityDegrades(amountToDegrade);

        int actualQuality = ruleQualityDegrades.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);

    }
}
