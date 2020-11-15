package com.gildedrose.item;

public class Pass extends StoreItem {

    public Pass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        computedSellIn = sellIn;
        computedQuality = quality;
    }

    @Override
    public void updateQuality() {
        super.decrementSellIn();
        calculateNonExpiredPassQuality();
        super.enforceQualityBounds();
        enforceExpirationPolicy();
    }

    private void calculateNonExpiredPassQuality() {
        computedQuality += 1;
        computedQuality += computedSellIn < 10 ? 1 : 0;
        computedQuality += computedSellIn < 5 ? 1 : 0;
        quality = computedQuality;
    }

    private void enforceExpirationPolicy() {
        computedQuality = computedSellIn < 0 ? 0 : computedQuality;
        quality = computedQuality;
    }
    
}
