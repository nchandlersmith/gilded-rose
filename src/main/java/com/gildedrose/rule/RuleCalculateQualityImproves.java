package com.gildedrose.rule;

import java.util.Objects;

public class RuleCalculateQualityImproves implements RuleCalculateQuality {

    private final int increaseAmount;

    public RuleCalculateQualityImproves(int increaseAmount) {
        this.increaseAmount = increaseAmount;
    }

    @Override
    public int run(int sellIn, int quality) {
        return sellIn < 0 ? quality + (2 * increaseAmount) : quality + increaseAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(increaseAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RuleCalculateQualityImproves that = (RuleCalculateQualityImproves) o;
        return increaseAmount == that.increaseAmount;
    }
}
