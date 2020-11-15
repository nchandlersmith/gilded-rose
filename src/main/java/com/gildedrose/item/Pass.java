package com.gildedrose.item;

public class Pass extends StoreItem {

    private static final int MAXIMUM_QUALITY = 50;

    public Pass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decrementSellIn();
        if (hasExpired()) {
            setQualityTo0();
            return ;
        }

        incrementWithinMax();

        if (sellIn < 10) {
            incrementWithinMax();
        }

        if (sellIn < 5 ) {
            incrementWithinMax();
        }
    }

    private void setQualityTo0() {
        quality = 0;
    }

    private boolean hasExpired() {
        return sellIn < 0;
    }

    private void decrementSellIn() {
        sellIn -= 1;
    }

    private void incrementWithinMax() {
        if (quality < MAXIMUM_QUALITY) {
            quality += 1;
        }
    }
    
}
