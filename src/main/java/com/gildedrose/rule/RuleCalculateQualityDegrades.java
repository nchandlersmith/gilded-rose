package com.gildedrose.rule;

import java.util.Objects;

public class RuleCalculateQualityDegrades implements RuleCalculateQuality {

    private final int degradeAmount;

    public RuleCalculateQualityDegrades(int degradeAmount) {
        this.degradeAmount = degradeAmount;
    }
    
    @Override
    public int run(int sellIn, int quality) {
        return sellIn < 0 ? quality - (2 * degradeAmount) : quality - degradeAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(degradeAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RuleCalculateQualityDegrades that = (RuleCalculateQualityDegrades) o;
        return degradeAmount == that.degradeAmount;
    }

}
