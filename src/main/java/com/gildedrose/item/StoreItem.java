package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.rule.calculatequality.RuleCalculateQuality;

import java.util.Objects;

public class StoreItem extends Item {

    private static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;

    protected int computedSellIn;
    protected int computedQuality;
    private RuleCalculateQuality calculateQualityRuleCalculateQuality;
    private RuleCalculateQuality expirationRuleCalculateQuality;

    protected StoreItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        computedSellIn = sellIn;
        computedQuality = quality;
    }

    public void updateQuality(){
        decrementSellIn();
        if (calculateQualityRuleCalculateQuality != null) {
            computedQuality = calculateQualityRuleCalculateQuality.run(computedSellIn, computedQuality);
        }
        enforceQualityBounds();
        if (expirationRuleCalculateQuality != null) {
            computedQuality = expirationRuleCalculateQuality.run(computedSellIn, computedQuality);
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
        return Objects.hash(computedSellIn, computedQuality, calculateQualityRuleCalculateQuality, expirationRuleCalculateQuality);
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
                calculateQualityRuleCalculateQuality.equals(that.calculateQualityRuleCalculateQuality);
    }

    public static class Builder {

        private String name;
        private int sellIn;
        private int quality;
        private int computedSellIn;
        private int computedQuality;
        private RuleCalculateQuality calculateQualityRuleCalculateQuality;
        private RuleCalculateQuality expirationRuleCalculateQuality;

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

        public Builder ruleCalculateQuality(RuleCalculateQuality calculateQualityRuleCalculateQuality) {
            this.calculateQualityRuleCalculateQuality = calculateQualityRuleCalculateQuality;
            return this;
        }

        public Builder expirationRule(RuleCalculateQuality expirationRuleCalculateQuality) {
            this.expirationRuleCalculateQuality = expirationRuleCalculateQuality;
            return this;
        }

        public StoreItem build() {
            StoreItem storeItem = new StoreItem(name, sellIn, quality);
            storeItem.computedQuality = this.computedQuality;
            storeItem.computedSellIn = this.computedSellIn;
            storeItem.calculateQualityRuleCalculateQuality = this.calculateQualityRuleCalculateQuality;
            storeItem.expirationRuleCalculateQuality = this.expirationRuleCalculateQuality;
            return storeItem;
        }
    }
    
}
