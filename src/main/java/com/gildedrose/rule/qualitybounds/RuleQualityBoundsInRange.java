package com.gildedrose.rule.qualitybounds;

public class RuleQualityBoundsInRange implements RuleQualityBounds{

    private final int minimum;
    private final int maximum;

    RuleQualityBoundsInRange(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    @Override
    public int run(int quality) {
        int qualityInBounds = Math.max(quality, minimum);
        return Math.min(qualityInBounds, maximum);
    }
}
