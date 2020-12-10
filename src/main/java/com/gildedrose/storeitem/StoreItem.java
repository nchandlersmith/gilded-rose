package com.gildedrose.storeitem;

import com.gildedrose.Item;
import com.gildedrose.rule.calculatequality.RuleCalculateQuality;
import com.gildedrose.rule.calculatesellin.RuleCalculateSellIn;
import com.gildedrose.rule.qualitybounds.RuleQualityBounds;

import java.util.Objects;

public class StoreItem extends Item {

    private int computedSellIn;
    private int computedQuality;
    private RuleCalculateQuality ruleCalculateQuality;
    private RuleQualityBounds ruleQualityBounds;
    private RuleCalculateSellIn ruleCalculateSellIn;

    protected StoreItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        computedSellIn = sellIn;
        computedQuality = quality;
    }

    public void updateQuality(){
        decrementSellIn();
        calculateQuality();
        enforceQualityBounds();
        updatePublicFields();
    }

    void decrementSellIn() {
        computedSellIn = ruleCalculateSellIn.run(computedSellIn);
    }

    void calculateQuality() {
        computedQuality = ruleCalculateQuality.run(computedSellIn, computedQuality);
    }

    void enforceQualityBounds() {
        computedQuality = ruleQualityBounds.run(computedQuality);
    }

    private void updatePublicFields() {
        sellIn = computedSellIn;
        quality = computedQuality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreItem storeItem = (StoreItem) o;
        return  name.equals(storeItem.name) &&
                computedSellIn == storeItem.computedSellIn &&
                computedQuality == storeItem.computedQuality &&
                ruleCalculateQuality.equals(storeItem.ruleCalculateQuality) &&
                ruleQualityBounds.equals(storeItem.ruleQualityBounds) &&
                ruleCalculateSellIn.equals(storeItem.ruleCalculateSellIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, computedSellIn, computedQuality, ruleCalculateQuality, ruleQualityBounds, ruleCalculateSellIn);
    }

    public static class Builder {

        private String name;
        private int sellIn;
        private int quality;
        private int computedSellIn;
        private int computedQuality;
        private RuleCalculateQuality calculateQualityRuleCalculateQuality;
        private RuleQualityBounds ruleQualityBounds;
        private RuleCalculateSellIn ruleCalculateSellIn;

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

        public Builder ruleCalculateSellin(RuleCalculateSellIn ruleCalculateSellIn) {
            this.ruleCalculateSellIn = ruleCalculateSellIn;
            return this;
        }

        public StoreItem build() {
            StoreItem storeItem = new StoreItem(name, sellIn, quality);
            storeItem.computedQuality = this.computedQuality;
            storeItem.computedSellIn = this.computedSellIn;
            storeItem.ruleCalculateQuality = this.calculateQualityRuleCalculateQuality;
            storeItem.ruleQualityBounds = this.ruleQualityBounds;
            storeItem.ruleCalculateSellIn = this.ruleCalculateSellIn;
            return storeItem;
        }
    }
    
}
