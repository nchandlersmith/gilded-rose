package com.gildedrose.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SulfurasTest {
    private  final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    


    @Test
    void givenSulfurasWithPositiveSellIn_whenUpdate_thenQualityDoesNotDecrease() {
        Sulfuras sulfuras = new Sulfuras(SULFURAS, 5, 80);

        sulfuras.updateQuality();

        assertEquals(80, sulfuras.quality);
    }

    @Test
    void givenSulfurasWithSellinEquals0_whenUpdate_thenQualityDoesNotDecrease() {
        Sulfuras sulfuras = new Sulfuras(SULFURAS, 0, 80);

        sulfuras.updateQuality();

        assertEquals(80, sulfuras.quality);
    }

    @Test
    void givenSulfurasWithNegativeSellIn_whenUpdate_thenQualityDoesNotDecrease() {
        Sulfuras sulfuras = new Sulfuras(SULFURAS, -1, 80);

        sulfuras.updateQuality();

        assertEquals(80, sulfuras.quality);
    }

    @Test
    void givenSulfuras_whenUpdate_thenSellInDoesNotDecrement() {
        Sulfuras sulfuras = new Sulfuras(SULFURAS, 20, 80);

        sulfuras.updateQuality();

        assertEquals(20, sulfuras.sellIn);
    }
}
