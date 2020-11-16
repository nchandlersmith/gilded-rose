package com.gildedrose.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class QualityDegradesRuleTest {
    
    @Test
    public void run_degradesQuality() {
        int startingQuality = 1234;
        int expectedQuality = 1233;
        int amountToDegrade = 1;
        int sellIn = 123;
        RuleQualityDegradesBy qualityDegrades = new RuleQualityDegradesBy(amountToDegrade);

        int actualQuality = qualityDegrades.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    public void run_degradesQualityBySpecifiedAmount() {
        int startingQuality = 1234;
        int expectedQuality = 1232;
        int amountToDegrade = 2;
        int sellIn = 123;
        RuleQualityDegradesBy qualityDegrades = new RuleQualityDegradesBy(amountToDegrade);

        int actualQuality = qualityDegrades.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);

    }

    @Test
    public void run_degradesQualityWhenExpiredDoublesDegradeAmount() {
        int startingQuality = 1234;
        int expectedQuality = 1230;
        int amountToDegrade = 2;
        int sellIn = -1;
        RuleQualityDegradesBy qualityDegrades = new RuleQualityDegradesBy(amountToDegrade);

        int actualQuality = qualityDegrades.run(sellIn, startingQuality);

        assertEquals(expectedQuality, actualQuality);

    }
}
