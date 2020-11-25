package com.gildedrose.storeitem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class SulfurasTest {
    private  final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -1})
    void updateQuality_doesNotChangeQuality(Integer sellIn) {
        StoreItem sulfuras = StoreItemFactory.createSulfuras(SULFURAS, sellIn);
        sulfuras.updateQuality();
        assertEquals(80, sulfuras.quality);
        assertThat(sulfuras.quality).isEqualTo(80);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -1})
    void updateQuality_doesNotChangeSellIn(int sellIn) {
        StoreItem sulfuras = StoreItemFactory.createSulfuras(SULFURAS, sellIn);
        sulfuras.updateQuality();
        assertThat(sulfuras.sellIn).isEqualTo(sellIn);
    }
}
