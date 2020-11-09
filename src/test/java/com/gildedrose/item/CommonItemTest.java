package com.gildedrose.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CommonItemTest {

    @Test
    void commonItem_whenUpdate_thenDecreaseQualityBy1() {
        CommonItem commonItem = new CommonItem("common item", 1, 10);
        
        commonItem.updateQuality();

        assertEquals(9, commonItem.quality);
    }
}
