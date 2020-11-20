package com.gildedrose.rule;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}