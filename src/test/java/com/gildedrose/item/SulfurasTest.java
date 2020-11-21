package com.gildedrose.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SulfurasTest {
    private  final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    


    @ParameterizedTest
    @ValueSource(ints = {1, 0, -1})
    void givenSulfurasWithPositiveSellIn_whenUpdate_thenQualityDoesNotDecrease(Integer sellIn) {
        StoreItem sulfuras = StoreItemFactory.createSulfuras(SULFURAS, sellIn);
        sulfuras.updateQuality();
        assertEquals(80, sulfuras.quality);
    }

    @Test
    void givenSulfuras_whenUpdate_thenSellInDoesNotDecrement() {
        StoreItem sulfuras = StoreItemFactory.createSulfuras(SULFURAS, 20);
        sulfuras.updateQuality();
        assertEquals(20, sulfuras.sellIn);
    }

    @Test
    void givenSulfuras_whenUpdate_thenQualityIsAlways80() {
        StoreItem sulfuras = StoreItemFactory.createSulfuras(SULFURAS, 20);
        sulfuras.updateQuality();
        assertEquals(80, sulfuras.quality);
    }
}
