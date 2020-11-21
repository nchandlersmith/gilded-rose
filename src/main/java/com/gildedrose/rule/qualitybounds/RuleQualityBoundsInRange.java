package com.gildedrose.rule.qualitybounds;

import java.util.Objects;

public class RuleQualityBoundsInRange implements RuleQualityBounds{

    private final int minimum;
    private final int maximum;

    public RuleQualityBoundsInRange(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    @Override
    public int run(int quality) {
        int qualityInBounds = Math.max(quality, minimum);
        return Math.min(qualityInBounds, maximum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RuleQualityBoundsInRange that = (RuleQualityBoundsInRange) o;
        return minimum == that.minimum &&
                maximum == that.maximum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minimum, maximum);
    }
}
