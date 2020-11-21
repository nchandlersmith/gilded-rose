package com.gildedrose.storeitem;

import com.gildedrose.Item;
import com.gildedrose.rule.calculatequality.RuleCalculateQuality;
import com.gildedrose.rule.qualitybounds.RuleQualityBounds;

import java.util.Objects;

public class StoreItem extends Item {

    private int computedSellIn;
    private int computedQuality;
    private RuleCalculateQuality calculateQualityRuleCalculateQuality;
    private RuleQualityBounds ruleQualityBounds;

    protected StoreItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        computedSellIn = sellIn;
        computedQuality = quality;
    }

    public void updateQuality(){
        decrementSellIn();
        computedQuality = calculateQualityRuleCalculateQuality.run(computedSellIn, computedQuality);
        enforceQualityBounds();
    }

    void decrementSellIn() {
        String SULFURAS = "Sulfuras, Hand of Ragnaros";
        if (!name.equals(SULFURAS)) computedSellIn -= 1;
        sellIn = computedSellIn;
    }

    void enforceQualityBounds() {
        computedQuality = ruleQualityBounds.run(computedQuality);
        quality = computedQuality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(computedSellIn, computedQuality, calculateQualityRuleCalculateQuality);
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
                calculateQualityRuleCalculateQuality.equals(that.calculateQualityRuleCalculateQuality) &&
                ruleQualityBounds.equals(that.ruleQualityBounds);
    }

    public static class Builder {

        private String name;
        private int sellIn;
        private int quality;
        private int computedSellIn;
        private int computedQuality;
        private RuleCalculateQuality calculateQualityRuleCalculateQuality;
        private RuleQualityBounds ruleQualityBounds;

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

        public Builder ruleQualityBounds(RuleQualityBounds ruleQualityBounds) {
            this.ruleQualityBounds = ruleQualityBounds;
            return this;
        }

        public StoreItem build() {
            StoreItem storeItem = new StoreItem(name, sellIn, quality);
            storeItem.computedQuality = this.computedQuality;
            storeItem.computedSellIn = this.computedSellIn;
            storeItem.calculateQualityRuleCalculateQuality = this.calculateQualityRuleCalculateQuality;
            storeItem.ruleQualityBounds = this.ruleQualityBounds;
            return storeItem;
        }
    }
    
}
