package com.gildedrose.item;

public class CommonItem extends StoreItem {

    private static final Integer MINIMUM_QUALITY = 0;

    public CommonItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
	public void updateQuality() {
        decrementQualityWithinMaximum();
        decrementSellIn();
        decrementWhenExpired();
    }
    
    private void decrementQualityWithinMaximum() {
        if (quality > MINIMUM_QUALITY) quality -= 1;
    }

    private void decrementSellIn() {
        sellIn -= 1;
    }

    private void decrementWhenExpired() {
        if (hasExpired()) {
            decrementQualityWithinMaximum();
        }
    }

    private boolean hasExpired() {
        return sellIn < 0;
    }
    
}
