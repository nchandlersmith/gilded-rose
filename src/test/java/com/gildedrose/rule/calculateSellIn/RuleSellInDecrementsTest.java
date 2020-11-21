package com.gildedrose.rule.calculateSellIn;

import com.gildedrose.rule.calculatesellin.RuleCalculateSellIn;
import com.gildedrose.rule.calculatesellin.RuleSellInDecrements;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("squid:S5838")
class RuleSellInDecrementsTest {

    @Test
    void run_decrementsSellIn() {
        int startingSellIn = 12;
        int expectedSellIn = 11;
        RuleCalculateSellIn rule = new RuleSellInDecrements();

        int actualSellIn = rule.run(startingSellIn);

        assertThat(actualSellIn).isEqualTo(expectedSellIn);
    }

    @Test
    void isEqualToItSelf() {
        RuleCalculateSellIn rule = new RuleSellInDecrements();
        //noinspection EqualsWithItself
        assertThat(rule.equals(rule)).isTrue();
    }

    @Test
    void isNotEqualToNull() {
        RuleCalculateSellIn rule = new RuleSellInDecrements();
        assertThat(rule.equals(null)).isFalse();
    }

    @Test
    void isNotEqualToObjectOfAnotherClass() {
        RuleCalculateSellIn rule = new RuleSellInDecrements();
        //noinspection EqualsBetweenInconvertibleTypes
        assertThat(rule.equals("object of another class")).isFalse();
    }

    @Test
    void isEqualToObjectOfRuleSellInDecrements() {
        RuleCalculateSellIn rule1 = new RuleSellInDecrements();
        RuleCalculateSellIn rule2 = new RuleSellInDecrements();
        assertThat(rule1.equals(rule2)).isTrue();
    }
}