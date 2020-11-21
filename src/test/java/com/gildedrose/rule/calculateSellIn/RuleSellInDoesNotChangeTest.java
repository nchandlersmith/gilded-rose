package com.gildedrose.rule.calculateSellIn;

import com.gildedrose.rule.calculatesellin.RuleCalculateSellIn;
import com.gildedrose.rule.calculatesellin.RuleSellInDoesNotChange;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("squid:S5838")
class RuleSellInDoesNotChangeTest {

    @Test
    void run_doesNotChangeSellIn() {
        RuleCalculateSellIn rule = new RuleSellInDoesNotChange();
        int expectedSellIn = 1234;

        int actualSellIn = rule.run(expectedSellIn);

        assertThat(actualSellIn).isEqualTo(expectedSellIn);
    }

    @Test
    void isEqualToItself() {
        RuleCalculateSellIn rule = new RuleSellInDoesNotChange();
        //noinspection EqualsWithItself
        assertThat(rule.equals(rule)).isTrue();
    }

    @Test
    void isNotEqualToNull() {
        RuleCalculateSellIn rule = new RuleSellInDoesNotChange();
        assertThat(rule.equals(null)).isFalse();
    }

    @Test
    void isNotEqualToObjectOfOtherClass() {
        RuleCalculateSellIn rule = new RuleSellInDoesNotChange();
        //noinspection EqualsBetweenInconvertibleTypes
        assertThat(rule.equals("object of other class")).isFalse();
    }

    @Test
    void isNotEqualToRuleSellInDoesNotChangeObject() {
        RuleCalculateSellIn rule1 = new RuleSellInDoesNotChange();
        RuleCalculateSellIn rule2 = new RuleSellInDoesNotChange();
        assertThat(rule1.equals(rule2)).isTrue();
    }
}