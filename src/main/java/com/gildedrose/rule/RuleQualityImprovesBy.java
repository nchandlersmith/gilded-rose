package com.gildedrose.rule;

public class RuleQualityImprovesBy implements Rule{

    private final int amountToIncreaseBy;

    public RuleQualityImprovesBy (int amountToIncreaseBy) {
        this.amountToIncreaseBy = amountToIncreaseBy;
    }

    @Override
    public int run(int sellIn, int quality) {
        return sellIn < 0 ? quality + (2 * amountToIncreaseBy) : quality + amountToIncreaseBy;
    };
}
