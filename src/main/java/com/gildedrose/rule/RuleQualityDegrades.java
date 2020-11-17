package com.gildedrose.rule;

import java.util.Objects;

public class RuleQualityDegrades implements Rule {

    private int degradeAmount;

    public RuleQualityDegrades(int degradeAmount) {
        this.degradeAmount = degradeAmount;
    }
    
    @Override
    public int run(int sellIn, int quality) {
        return sellIn < 0 ? quality - (2 * degradeAmount) : quality - degradeAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RuleQualityDegrades that = (RuleQualityDegrades) o;
        return degradeAmount == that.degradeAmount;
    }

}
