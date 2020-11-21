package com.gildedrose.rule;

public class RuleCalculateQuality0WhenExpired implements RuleCalculateQuality {

    @Override
    public int run(int sellIn, int quality) {
        if ( sellIn < 0 ) return 0;
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
