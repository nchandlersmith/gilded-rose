package com.gildedrose.rule.calculatequality;

import com.gildedrose.rule.calculatequality.RuleCalculateQuality;
import com.gildedrose.rule.calculatequality.RuleCalculateQualityDegrades;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("squid:S5838")
class RuleCalculateQualityDegradesTest {
    
    @Test
    void run_degradesQuality() {
        int startingQuality = 1234;
        int expectedQuality = 1233;
        int amountToDegrade = 1;
        int sellIn = 123;
        RuleCalculateQualityDegrades ruleQualityDegrades = new RuleCalculateQualityDegrades(amountToDegrade);

        int actualQuality = ruleQualityDegrades.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);
    }

    @Test
    void run_degradesQualityBySpecifiedAmount() {
        int startingQuality = 1234;
        int expectedQuality = 1232;
        int amountToDegrade = 2;
        int sellIn = 123;
        RuleCalculateQualityDegrades ruleQualityDegrades = new RuleCalculateQualityDegrades(amountToDegrade);

        int actualQuality = ruleQualityDegrades.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);
    }

    @Test
    void run_whenExpiredDoublesDegradeAmount() {
        int startingQuality = 1234;
        int expectedQuality = 1230;
        int amountToDegrade = 2;
        int sellIn = -1;
        RuleCalculateQualityDegrades ruleQualityDegrades = new RuleCalculateQualityDegrades(amountToDegrade);

        int actualQuality = ruleQualityDegrades.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);
    }

    @Test
    void twoRuleQualityDegradesAreEqualWhenTheirAmountToDegradeAreEqual() {
        RuleCalculateQuality ruleCalculateQuality1 = new RuleCalculateQualityDegrades(1);
        RuleCalculateQuality ruleCalculateQuality2 = new RuleCalculateQualityDegrades(1);

        assertThat(ruleCalculateQuality1).isEqualTo(ruleCalculateQuality2);
    }

    @Test
    void ruleQualityDegradesIsEqualToItself() {
        RuleCalculateQuality ruleCalculateQuality = new RuleCalculateQualityDegrades(1);

        assertThat(ruleCalculateQuality).isEqualTo(ruleCalculateQuality);
    }

    @Test
    void ruleQualityDegradesIsNotEqualToNull() {
        RuleCalculateQuality ruleCalculateQuality = new RuleCalculateQualityDegrades(1);

        assertThat(ruleCalculateQuality).isNotEqualTo(null);
    }

    @Test
    void ruleQualityDegradesIsNotEqualAnObjectOfAnotherClass() {
        RuleCalculateQuality ruleCalculateQuality = new RuleCalculateQualityDegrades(1);

        assertThat(ruleCalculateQuality).isNotEqualTo("some obect from other class");
    }
}
