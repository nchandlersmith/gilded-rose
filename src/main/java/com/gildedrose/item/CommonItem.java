package com.gildedrose.item;

public class CommonItem extends StoreItem {

    private static final int MINIMUM_QUALITY = 0;

    public CommonItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
	public void updateQuality() {
        decrementSellIn();
        decrementQualityWithinMax();
        decrementWhenExpired();
    }
    
    private void decrementQualityWithinMax() {
        if (quality > MINIMUM_QUALITY) quality -= 1;
    }

    private void decrementSellIn() {
        sellIn -= 1;
    }

    private void decrementWhenExpired() {
        if (hasExpired()) {
            decrementQualityWithinMax();
        }
    }

    private boolean hasExpired() {
        return sellIn < 0;
    }
    
}
