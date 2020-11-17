package com.gildedrose.rule;

public class RuleQualityImproves implements Rule{

    private final int increaseAmount;

    public RuleQualityImproves(int increaseAmount) {
        this.increaseAmount = increaseAmount;
    }

    @Override
    public int run(int sellIn, int quality) {
        return sellIn < 0 ? quality + (2 * increaseAmount) : quality + increaseAmount;
    };
}
