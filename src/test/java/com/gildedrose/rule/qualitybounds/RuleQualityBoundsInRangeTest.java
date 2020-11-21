package com.gildedrose.rule.qualitybounds;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RuleQualityBoundsInRangeTest {

    @Test
    void run_doesNotAllowValueLesserThanMinimum() {
        int startingQuality = 123;
        int minimumAllowedValue = 234;
        int maximumAllowedValue = 345;
        RuleQualityBounds rule = new RuleQualityBoundsInRange(minimumAllowedValue, maximumAllowedValue);

        int actualQuality = rule.run(startingQuality);

        assertThat(actualQuality).isEqualTo(minimumAllowedValue);
    }

    @Test
    void run_doesNotAllowValueGreaterThanMaximum() {
        int startingQuality = 456;
        int minimumAllowedValue = 234;
        int maximumAllowedValue = 345;
        RuleQualityBounds rule = new RuleQualityBoundsInRange(minimumAllowedValue, maximumAllowedValue);

        int actualQuality = rule.run(startingQuality);

        assertThat(actualQuality).isEqualTo(maximumAllowedValue);
    }
}
