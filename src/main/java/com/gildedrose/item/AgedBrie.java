package com.gildedrose.item;

public class AgedBrie extends StoreItem {

    private static final Integer MAXIMUM_QUALITY = 50;

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        incrementQualityWithinMaximum();
        decrementSellIn();
        incrementWhenExpired();
    }

    private void incrementQualityWithinMaximum() {
        if (quality < MAXIMUM_QUALITY) quality += 1;
    }

    private void decrementSellIn() {
        sellIn -= 1;
    }

    private void incrementWhenExpired() {
        if (hasExpired()) {
            incrementQualityWithinMaximum();
        }
    }

    private boolean hasExpired() {
        return sellIn < 0;
    }
    
}
