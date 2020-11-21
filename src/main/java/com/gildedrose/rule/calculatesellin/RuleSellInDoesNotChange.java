package com.gildedrose.rule.calculatesellin;

public class RuleSellInDoesNotChange implements RuleCalculateSellIn {

    @Override
    public int run(int sellIn) {
        return sellIn;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        return this.getClass() == obj.getClass();
    }
}
