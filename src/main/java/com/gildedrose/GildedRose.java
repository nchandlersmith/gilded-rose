package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateWhenNotExpired(i);
            updateSellIn(i);
            updateQualityDueToExperation(i);
        }
    }

    private void updateWhenNotExpired(int i) {
        if (itemIsCommon(i)) {
            updateQualityCommonItem(i);
        } else {
            updateQualityUncommonItem(i);
        }
    }

    private boolean itemIsCommon(int i) {
        return !items[i].name.equals(AGED_BRIE)
             && !items[i].name.equals(PASS)
             && !items[i].name.equals(SULFURAS);
    }

    private void updateQualityCommonItem(int i) {
        updateCommonItemQuality(i);
    }

    private void updateQualityUncommonItem(int i) {
        final Integer maxQuality = 50;

        if (items[i].quality < maxQuality) {
            items[i].quality += 1;
            if (items[i].name.equals(PASS)) {
                additionalPassQualityUpdates(i, maxQuality);
            }
        }
    }

    private void additionalPassQualityUpdates(int i, final Integer maxQuality) {
        if (items[i].sellIn < 11) {
            if (items[i].quality < maxQuality) {
                items[i].quality += 1;
            }
        }
        if (items[i].sellIn < 6) {
            if (items[i].quality < maxQuality) {
                items[i].quality += 1;
            }
        }
    }

    private void updateSellIn(int i) {
        if (!items[i].name.equals(SULFURAS)) {
            items[i].sellIn -= 1;
        }
    }

    private void updateQualityDueToExperation(int i) {
        if (items[i].sellIn < 0) {
            if (itemIsCommon(i)) {
                updateCommonItemQuality(i);
            }
            if (!items[i].name.equals(AGED_BRIE)) {
                if (!items[i].name.equals(PASS)) {
                } else {
                    items[i].quality = 0;
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality += 1;
                }
            }
        }
    }

    private void updateCommonItemQuality(int i) {
        if (items[i].quality > 0) {
            items[i].quality -= 1;
        }
    }
}