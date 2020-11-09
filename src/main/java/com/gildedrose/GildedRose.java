package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final Integer MAXIMUM_QUALITY = 50;
    private static final Integer MINIMUM_QUALITY = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateQualityWhenNotExpired(i);
            updateSellInIfNotSulfuras(i);
            updateQualityDueToExpiration(i);
        }
    }

    private void updateQualityWhenNotExpired(int i) {
        updateUnexpiredQualityIfCommonItem(i);
        updateQualityIfAgedBrie(i);
        updateUnexpiredQualityIfPass(i);
    }

    private void updateUnexpiredQualityIfCommonItem(int i) {
        updateQualityDueToExpirationIfCommonItem(i);
    }

    private boolean itemIsCommon(int i) {
        return !items[i].name.equals(AGED_BRIE)
             && !items[i].name.equals(PASS)
             && !items[i].name.equals(SULFURAS);
    }

    private void updateUnexpiredQualityIfPass(int i) {
        if (items[i].name.equals(PASS)) {
            incrementItemQuality(i);
            additionalPassQualityUpdates(i);
        }
    }

    private void additionalPassQualityUpdates(int i) {
        if (items[i].sellIn < 11) {
            incrementItemQuality(i);
        }
        if (items[i].sellIn < 6) {
            incrementItemQuality(i);
        }
    }

    private void updateSellInIfNotSulfuras(int i) {
        if (!items[i].name.equals(SULFURAS)) {
            items[i].sellIn -= 1;
        }
    }

    private void updateQualityDueToExpiration(int i) {
        if (items[i].sellIn < 0) {
            updateQualityDueToExpirationIfCommonItem(i);
            updateQualityDueToExpirationIfPass(i);
            updateQualityIfAgedBrie(i);
        }
    }

    private void updateQualityDueToExpirationIfCommonItem(int i) {
        if (itemIsCommon(i)) {
            decrementItemQuality(i);
        }
    }

    private void updateQualityDueToExpirationIfPass(int i) {
        if (items[i].name.equals(PASS)) {
            items[i].quality = 0;
        }
    }

    private void updateQualityIfAgedBrie(int i) {
        if (items[i].name.equals(AGED_BRIE)) {
            incrementItemQuality(i);
        }
    }

    private void decrementItemQuality(int i) {
        if (items[i].quality > MINIMUM_QUALITY) {
            items[i].quality -= 1;
        }
    }

    private void incrementItemQuality(int i) {
        if (items[i].quality < MAXIMUM_QUALITY) {
            items[i].quality += 1;
        }
    }
}