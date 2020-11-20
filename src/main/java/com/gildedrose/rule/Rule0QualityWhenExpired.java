package com.gildedrose.rule;

public class Rule0QualityWhenExpired implements Rule {
    @Override
    public int run(int sellIn, int quality) {
        if ( sellIn < 0 ) return 0;
        return quality;
    }
}
