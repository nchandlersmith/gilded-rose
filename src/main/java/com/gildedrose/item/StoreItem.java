package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.rule.Rule;

import java.util.Objects;

public class StoreItem extends Item {

    private static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;

    protected int computedSellIn;
    protected int computedQuality;
    private Rule calculateQualityRule;
    private Rule expirationRule;

    protected StoreItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        computedSellIn = sellIn;
        computedQuality = quality;
    }

    public void updateQuality(){
        decrementSellIn();
        if (calculateQualityRule != null) {
            computedQuality = calculateQualityRule.run(computedSellIn, computedQuality);
        }
        enforceQualityBounds();
        if (expirationRule != null) {
            computedQuality = expirationRule.run(computedSellIn, computedQuality);
            quality = computedQuality;
        }
    }

    protected void decrementSellIn() {
        computedSellIn -= 1;
        sellIn = computedSellIn;
    }

    protected void enforceQualityBounds() {
        computedQuality = Math.max(computedQuality, MINIMUM_QUALITY);
        computedQuality = Math.min(computedQuality, MAXIMUM_QUALITY);
        quality = computedQuality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(computedSellIn, computedQuality, calculateQualityRule, expirationRule);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreItem that = (StoreItem) o;
        return sellIn == that.sellIn &&
                quality == that.quality &&
                computedSellIn == that.computedSellIn &&
                computedQuality == that.computedQuality &&
                name.equals(that.name) &&
                calculateQualityRule.equals(that.calculateQualityRule);
    }

    public static class Builder {

        private String name;
        private int sellIn;
        private int quality;
        private int computedSellIn;
        private int computedQuality;
        private Rule calculateQualityRule;
        private Rule expirationRule;

        public Builder() {
            // blank intentionally
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder sellIn(int sellIn) {
            this.sellIn = sellIn;
            this.computedSellIn = sellIn;
            return this;
        }

        public Builder quality(int quality) {
            this.quality = quality;
            this.computedQuality = quality;
            return this;
        }

        public Builder ruleCalculateQuality(Rule calculateQualityRule) {
            this.calculateQualityRule = calculateQualityRule;
            return this;
        }

        public Builder expirationRule(Rule expirationRule) {
            this.expirationRule = expirationRule;
            return this;
        }

        public StoreItem build() {
            StoreItem storeItem = new StoreItem(name, sellIn, quality);
            storeItem.computedQuality = this.computedQuality;
            storeItem.computedSellIn = this.computedSellIn;
            storeItem.calculateQualityRule = this.calculateQualityRule;
            storeItem.expirationRule = this.expirationRule;
            return storeItem;
        }
    }
    
}
