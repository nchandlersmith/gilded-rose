package com.gildedrose.item;

import com.gildedrose.Item;

public abstract class StoreItem extends Item{

    private int qualityIncrement;

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
        calculateQuality();
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
    
}
