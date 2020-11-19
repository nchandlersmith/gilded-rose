package com.gildedrose.rule;

public class RuleQualityImprovesTiered implements Rule {

    @Override
    public int run(int sellIn, int quality) {
        quality += 1;
        quality += sellIn < 11 ? 1 : 0;
        quality += sellIn < 6 ? 1 : 0;
        return quality;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return (obj != null && this.getClass() == obj.getClass());
    }
}
