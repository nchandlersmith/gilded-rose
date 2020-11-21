package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gildedrose.exception.ObjectIsNotAnInstanceOfStoreItem;
import com.gildedrose.storeitem.StoreItem;
import com.gildedrose.storeitem.StoreItemFactory;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void updateQuality_processesStoreItems() {
        StoreItem[] items = new StoreItem[] {
                StoreItemFactory.createCommonItem("common item", 1, 20),
                StoreItemFactory.createAgedBrie("aged brie", 1, 20),
                StoreItemFactory.createPass("passes to something", 1, 20),
                StoreItemFactory.createSulfuras("sulfuras", 20),
                StoreItemFactory.createConjuredItem("conjured item", 1, 20)
        };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();

        assertThat(items[0].quality).isEqualTo(19);
        assertThat(items[1].quality).isEqualTo(21);
        assertThat(items[2].quality).isEqualTo(23);
        assertThat(items[3].quality).isEqualTo(80);
        assertThat(items[4].quality).isEqualTo(18);

    }

    @Test
    void updateQuality_whenItemNotStoreItem_shouldThrowException() {
        Item[] items = new Item[] { new Item("non store item", 5, 5) };
        GildedRose app = new GildedRose(items);
        String expectedExceptionMessage = "com.gildedrose.Item is not a StoreItem class or subclass.";

        Exception exception = assertThrows(ObjectIsNotAnInstanceOfStoreItem.class, app::updateQuality);

        assertThat(exception.getMessage()).isEqualTo(expectedExceptionMessage);

    }
}
