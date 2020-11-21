package com.gildedrose.rule.calculatesellin;

public class RuleSellInDecrements implements RuleCalculateSellIn {

    @Override
    public int run(int sellIn) {
        return sellIn -1;
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
