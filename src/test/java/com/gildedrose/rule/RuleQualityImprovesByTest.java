package com.gildedrose.rule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RuleQualityImprovesByTest {

    @Test
    public void run_incrementsQuality() {
        int startingQuality = 123;
        int expectedQuality = 124;
        int sellIn = 1;
        int increaseQuality = 1;
        RuleQualityImprovesBy ruleQualityImprovesBy = new RuleQualityImprovesBy(increaseQuality);

        int actualQuality = ruleQualityImprovesBy.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void run_incrementsQualityBySpecifiedAmount() {
        int startingQuality = 1234;
        int expectedQuality = 1244;
        int sellIn = 1;
        int increaseQuality = 10;
        RuleQualityImprovesBy ruleQualityImprovesBy = new RuleQualityImprovesBy(increaseQuality);

        int actualQuality = ruleQualityImprovesBy.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void run_doublesAmountIncreasedWhenSellInIsNegative() {
        int startingQuality = 123;
        int expectedQuality = 143;
        int sellIn = -1;
        int increasedQuality = 10;
        RuleQualityImprovesBy ruleQualityImprovesBy = new RuleQualityImprovesBy(increasedQuality);

        int actualQuality = ruleQualityImprovesBy.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);
    }
    
}
