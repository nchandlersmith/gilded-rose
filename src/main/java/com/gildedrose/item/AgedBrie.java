package com.gildedrose.item;

public class AgedBrie extends StoreItem {

    private static final int MAXIMUM_QUALITY = 50;

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decrementSellIn();
        incrementQualityWithinMax();
        incrementWhenExpired();
    }

    private void decrementSellIn() {
        sellIn -= 1;
    }

    private void incrementQualityWithinMax() {
        if (quality < MAXIMUM_QUALITY) quality += 1;
    }

    private void incrementWhenExpired() {
        if (hasExpired()) {
            incrementQualityWithinMax();
        }
    }

    private boolean hasExpired() {
        return sellIn < 0;
    }
    
}
