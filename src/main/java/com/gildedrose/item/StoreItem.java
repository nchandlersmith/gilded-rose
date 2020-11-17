package com.gildedrose.item;

import com.gildedrose.Item;
import com.gildedrose.rule.Rule;

public class StoreItem extends Item {

    private int qualityIncrement;
    private Rule calculateQualityRule;

    private static final int MINIMUM_QUALITY = 0;
    private static final int MAXIMUM_QUALITY = 50;

    protected int computedSellIn;
    protected int computedQuality;

    protected StoreItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        computedSellIn = sellIn;
        computedQuality = quality;
    }

    public void updateQuality(){
        decrementSellIn();
        if (calculateQualityRule != null) {
            computedQuality = calculateQualityRule.run(computedSellIn, computedQuality);
        } else {
            calculateQuality();
        }
        enforceQualityBounds();
    }

    protected void decrementSellIn() {
        computedSellIn -= 1;
        sellIn = computedSellIn;
    }

    private void calculateQuality() {
        computedQuality += computedSellIn < 0 ? 2 * qualityIncrement : qualityIncrement;
        quality = computedQuality;

    }

    protected void enforceQualityBounds() {
        computedQuality = computedQuality < MINIMUM_QUALITY ? MINIMUM_QUALITY : computedQuality;
        computedQuality = computedQuality > MAXIMUM_QUALITY ? MAXIMUM_QUALITY : computedQuality;
        quality = computedQuality;
    }

    protected void setQualityIncrement(int qualityIncrement) {
        this.qualityIncrement = qualityIncrement;
    }

    public Rule getCalculatedQualityRule() {
        return this.calculateQualityRule;
    }

    public static class Builder {

        private String name;
        private int sellIn;
        private int quality;
        private int computedSellIn;
        private int computedQuality;
        private int qualityIncrement;
        private Rule calculateQualityRule;

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

        public Builder qualityIncrement(int qualityIncrement) {
            this.qualityIncrement = qualityIncrement;
            return this;
        }

        public Builder ruleCalculateQuality(Rule calculateQualityRule) {
            this.calculateQualityRule = calculateQualityRule;
            return this;
        }

        public StoreItem build() {
            StoreItem storeItem = new StoreItem(name, sellIn, quality);
            storeItem.computedQuality = this.computedQuality;
            storeItem.computedSellIn = this.computedSellIn;
            storeItem.qualityIncrement = this.qualityIncrement;
            storeItem.calculateQualityRule = this.calculateQualityRule;
            return storeItem;
        }
    }
    
}
