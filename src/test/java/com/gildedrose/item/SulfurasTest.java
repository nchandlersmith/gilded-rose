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
        Sulfuras sulfuras = new Sulfuras(SULFURAS, sellIn, 80);

        sulfuras.updateQuality();

        assertEquals(80, sulfuras.quality);
    }

    @Test
    void givenSulfuras_whenUpdate_thenSellInDoesNotDecrement() {
        Sulfuras sulfuras = new Sulfuras(SULFURAS, 20, 80);

        sulfuras.updateQuality();

        assertEquals(20, sulfuras.sellIn);
    }

    @Test
    void givenSulfuras_whenUpdate_thenQualityIsAlways80() {
        Sulfuras sulfuras = new Sulfuras(SULFURAS, 20, 5);

        sulfuras.updateQuality();

        assertEquals(80, sulfuras.quality);
    }
}
