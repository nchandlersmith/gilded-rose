package com.gildedrose.rule;

public class RuleQualityDegrades implements Rule {

    private int degradeAmount;

    public RuleQualityDegrades(int degradeAmount) {
        this.degradeAmount = degradeAmount;
    }
    
    @Override
    public int run(int sellIn, int quality) {
        return sellIn < 0 ? quality - (2 * degradeAmount) : quality - degradeAmount;
    }
}
