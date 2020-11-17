package com.gildedrose.rule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RuleQualityImprovesTest {

    @Test
    void run_improvesQuality() {
        int startingQuality = 123;
        int expectedQuality = 124;
        int sellIn = 1;
        int increaseQuality = 1;
        RuleQualityImproves ruleQualityImproves = new RuleQualityImproves(increaseQuality);

        int actualQuality = ruleQualityImproves.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    void run_improvesQualityBySpecifiedAmount() {
        int startingQuality = 1234;
        int expectedQuality = 1244;
        int sellIn = 1;
        int increaseQuality = 10;
        RuleQualityImproves ruleQualityImproves = new RuleQualityImproves(increaseQuality);

        int actualQuality = ruleQualityImproves.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    void run_whenExpiredDoublesImprovedAmount() {
        int startingQuality = 123;
        int expectedQuality = 143;
        int sellIn = -1;
        int increasedQuality = 10;
        RuleQualityImproves ruleQualityImproves = new RuleQualityImproves(increasedQuality);

        int actualQuality = ruleQualityImproves.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    void ruleQualityImproves_isEqualToItself() {
        RuleQualityImproves ruleQualityImproves = new RuleQualityImproves(1);

        assertEquals(ruleQualityImproves, ruleQualityImproves);
    }

    @Test
    void ruleQualityImproves_notEqualToNull() {
        RuleQualityImproves ruleQualityImproves = new RuleQualityImproves(1);

        assertNotEquals(null, ruleQualityImproves);
    }

    @Test
    void ruleQualityImproves_notEqualToObjectOfOtherClass() {
        RuleQualityImproves ruleQualityImproves = new RuleQualityImproves(1);

        assertNotEquals("some class", ruleQualityImproves);
    }

    @Test
    void twoRuleQualityImproves_areEqual_whenTheirFieldsAreEqual() {
        RuleQualityImproves ruleQualityImproves1 = new RuleQualityImproves(1);
        RuleQualityImproves ruleQualityImproves2 = new RuleQualityImproves(1);

        assertEquals(ruleQualityImproves1, ruleQualityImproves2);
    }
    
}
