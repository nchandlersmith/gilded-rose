package com.gildedrose.rule;

public class RuleCalculateQualityImprovesTiered implements RuleCalculateQuality {

    @Override
    public int run(int sellIn, int quality) {
        quality += 1;
        quality += sellIn < 10 ? 1 : 0;
        quality += sellIn < 5 ? 1 : 0;
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
