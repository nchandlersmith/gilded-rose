package com.gildedrose.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CommonItemTest {

    @Test
    void update_whenSellInGreaterThan0_thenDecreaseQualityBy1() {
        CommonItem commonItem = new CommonItem("common item", 1, 10);
        
        commonItem.updateQuality();

        assertEquals(9, commonItem.quality);
    }

    @Test
    void update_whenSellInGreaterThan0_thenDecreaseSellInBy1() {
        CommonItem commonItem = new CommonItem("common item", 1, 10);

        commonItem.updateQuality();

        assertEquals(0, commonItem.sellIn);
    }

    @Test
    void update_whenSellInEquals0_thenDecreaseQualityBy2() {
        CommonItem commonItem = new CommonItem("common item", 0, 10);

        commonItem.updateQuality();

        assertEquals(8, commonItem.quality);
    }
}
