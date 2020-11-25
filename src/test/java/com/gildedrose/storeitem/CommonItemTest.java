package com.gildedrose.storeitem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CommonItemTest {

    private final String COMMON_ITEM = "common item";

    @Test
    void update_whenSellInGreaterThan0_thenDecreaseQualityBy1() {
        StoreItem commonItem = StoreItemFactory.createCommonItem(COMMON_ITEM, 1, 10);
        commonItem.updateQuality();
        assertThat(commonItem.quality).isEqualTo(9);
    }

    @ParameterizedTest(name = "#{index} - sellIn: {0} startingQuality: {1} expectedQuality: {2}")
    @MethodSource("createArguments_whenExpired_decreaseQualityBy2")
    void update_whenExpired_decreaseQualityBy2(int sellIn, int startingQuality, int expectedQuality) {
        StoreItem commonItem = StoreItemFactory.createCommonItem(COMMON_ITEM, sellIn, startingQuality);
        commonItem.updateQuality();
        assertThat(commonItem.quality).isEqualTo(expectedQuality);
    }

    private static Stream<Arguments> createArguments_whenExpired_decreaseQualityBy2() {
        return Stream.of(
                // sellIn, startingQuality, expectedQuality
                Arguments.arguments(0, 10, 8),
                Arguments.arguments(-1, 10, 8)
        );
    }

    @ParameterizedTest(name = "#{index} - startingSellIn: {0} expectedSellIn: {1}")
    @MethodSource("createArguments_sellInAlwaysDecrements")
    void sellInAlwaysDecrements(int startingSellIn, int expectedSellIn) {
        StoreItem commonItem = StoreItemFactory.createCommonItem(COMMON_ITEM, startingSellIn, 12);
        commonItem.updateQuality();
        assertThat(commonItem.sellIn).isEqualTo(expectedSellIn);
    }

    private static Stream<Arguments> createArguments_sellInAlwaysDecrements() {
        return Stream.of(
                // startingSellIn, expectedSellIn
                Arguments.arguments(1, 0),
                Arguments.arguments(0, -1),
                Arguments.arguments(-1, -2)
        );
    }

    @ParameterizedTest(name = "#{index} - sellIn: {0} startingQuality: {1} expectedQuality: {2}")
    @MethodSource("createArguments_qualityCannotBeNegative")
    void qualityCannotBeNegative(int sellIn, int startingQuality, int expectedQuality) {
        StoreItem commonItem = StoreItemFactory.createCommonItem(COMMON_ITEM, sellIn, startingQuality);
        commonItem.updateQuality();
        assertThat(commonItem.quality).isEqualTo(expectedQuality);
    }

    private static Stream<Arguments> createArguments_qualityCannotBeNegative() {
        return Stream.of(
                // sellIn, startingQuality, expectedQuality
                Arguments.arguments(1, 0, 0),
                Arguments.arguments(0, 0, 0),
                Arguments.arguments(-1, 0, 0)
        );
    }
}
