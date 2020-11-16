package com.gildedrose.rule;

public class RuleQualityDegradesBy implements Rule {

    private int degradeAmount;

    public RuleQualityDegradesBy(int degradeAmount) {
        this.degradeAmount = degradeAmount;
    }
    
    @Override
    public int run(int sellIn, int quality) {
        return sellIn < 0 ? quality - (2 * degradeAmount) : quality - degradeAmount;
    }
}
