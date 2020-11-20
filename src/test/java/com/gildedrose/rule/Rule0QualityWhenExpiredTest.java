package com.gildedrose.rule;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("squid:S5838")
class Rule0QualityWhenExpiredTest {

    @Test
    void whenNotExpired_qualityUnchanged() {
        int nonexpiredSellIn = 0;
        int startingQuality = 5;
        int expectedQuality = 5;
        Rule rule = new Rule0QualityWhenExpired();

        int actualQuality = rule.run(nonexpiredSellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);
    }

    @Test
    void whenSellInExpired_quality0() {
        int sellIn = -1;
        int startingQuality = 5;
        int expectedQuality = 0;
        Rule rule = new Rule0QualityWhenExpired();

        int actualQuality = rule.run(sellIn, startingQuality);

        assertThat(actualQuality).isEqualTo(expectedQuality);
    }

    @Test
    void isEqualToItself() {
        Rule rule = new Rule0QualityWhenExpired();
        //noinspection EqualsWithItself
        assertThat(rule.equals(rule)).isTrue();
    }

    @Test
    void isNotEqualToNull() {
        Rule rule = new Rule0QualityWhenExpired();
        assertThat(rule.equals(null)).isFalse();
    }

    @Test
    void isNotEqualToObjectOfAnotherClass() {
        Rule rule = new Rule0QualityWhenExpired();
        //noinspection EqualsBetweenInconvertibleTypes
        assertThat(rule.equals("some other class")).isFalse();
    }

    @Test
    void isEqualToObjectOfSameClass() {
        Rule rule1 = new Rule0QualityWhenExpired();
        Rule rule2 = new Rule0QualityWhenExpired();
        assertThat(rule1.equals(rule2)).isTrue();
    }
}