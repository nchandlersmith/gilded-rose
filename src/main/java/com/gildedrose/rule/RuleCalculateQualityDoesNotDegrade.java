package com.gildedrose.rule;

public class RuleCalculateQualityDoesNotDegrade implements RuleCalculateQuality {
    @Override
    public int run(int sellIn, int quality) {
        return quality;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        return (this.getClass() == obj.getClass());
    }
}
