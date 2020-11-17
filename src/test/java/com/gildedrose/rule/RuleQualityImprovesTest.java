package com.gildedrose.rule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RuleQualityImprovesTest {

    @Test
    public void run_improvesQuality() {
        int startingQuality = 123;
        int expectedQuality = 124;
        int sellIn = 1;
        int increaseQuality = 1;
        RuleQualityImproves ruleQualityImproves = new RuleQualityImproves(increaseQuality);

        int actualQuality = ruleQualityImproves.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void run_improvesQualityBySpecifiedAmount() {
        int startingQuality = 1234;
        int expectedQuality = 1244;
        int sellIn = 1;
        int increaseQuality = 10;
        RuleQualityImproves ruleQualityImproves = new RuleQualityImproves(increaseQuality);

        int actualQuality = ruleQualityImproves.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void run_whenExpiredDoublesImprovedAmount() {
        int startingQuality = 123;
        int expectedQuality = 143;
        int sellIn = -1;
        int increasedQuality = 10;
        RuleQualityImproves ruleQualityImproves = new RuleQualityImproves(increasedQuality);

        int actualQuality = ruleQualityImproves.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);
    }
    
}
