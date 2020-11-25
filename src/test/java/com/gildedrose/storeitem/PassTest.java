package com.gildedrose.storeitem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PassTest {

    private final String PASSES = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    void updateQuality_whenInGreaterThan10_thenIncreaseQualityBy1() {
        StoreItem pass = StoreItemFactory.createPass(PASSES, 11, 20);
        pass.updateQuality();
        assertThat(pass.quality).isEqualTo(21);
    }

    @ParameterizedTest(name = "#{index} - sellIn: {0} startingQuality: {1} expectedQuality: {2}")
    @MethodSource("createArguments_whenSellIn6To10Inclusive_increasesQualityBy2")
    void updateQuality_whenSellIn6to10Inclusive_increasesQualityBy2(int sellIn, int startingQuality, int expectedQuality) {
        StoreItem pass = StoreItemFactory.createPass(PASSES, sellIn, startingQuality);
        pass.updateQuality();
        assertThat(pass.quality).isEqualTo(expectedQuality);
    }

    private static Stream<Arguments> createArguments_whenSellIn6To10Inclusive_increasesQualityBy2() {
        return Stream.of(
                // sellIn, startingQuality, expectedQuality
                Arguments.arguments(10, 10, 12),
                Arguments.arguments(9, 10, 12),
                Arguments.arguments(8, 10, 12),
                Arguments.arguments(7, 10, 12),
                Arguments.arguments(6, 10, 12)
        );
    }

    @ParameterizedTest(name = "#{index} - sellIn: {0} startingQuality: {1} expectedQuality: {2}")
    @MethodSource("createArguments_whenSellIn1To5Inclusive_increasesQualityBy3")
    void updateQuality_whenSellIn1To5Inclusive_increasesQualityBy3(int sellIn, int startingQuality, int expectedQuality) {
        StoreItem pass = StoreItemFactory.createPass(PASSES, sellIn, startingQuality);
        pass.updateQuality();
        assertThat(pass.quality).isEqualTo(expectedQuality);
    }

    private static Stream<Arguments> createArguments_whenSellIn1To5Inclusive_increasesQualityBy3() {
        return Stream.of(
                // sellIn, startingQuality, expectedQuality
                Arguments.arguments(5, 10, 13),
                Arguments.arguments(4, 10, 13),
                Arguments.arguments(3, 10, 13),
                Arguments.arguments(2, 10, 13),
                Arguments.arguments(1, 10, 13)
        );
    }

    @ParameterizedTest(name = "#{index} startingSellIn: {0} expectedSellIn: {1}")
    @MethodSource("createArguments_sellInAlwaysDecrements")
    void updateQuality_sellInAlwaysDecrements(int startingSellIn, int expectedSellIn) {
        StoreItem pass = StoreItemFactory.createPass(PASSES, startingSellIn, 12);
        pass.updateQuality();
        assertThat(pass.sellIn).isEqualTo(expectedSellIn);
    }

    private static Stream<Arguments> createArguments_sellInAlwaysDecrements() {
        return Stream.of(
                // startingSellIn, expectedSellIn
                Arguments.arguments(11, 10),
                Arguments.arguments(10, 9),
                Arguments.arguments(9, 8),
                Arguments.arguments(8, 7),
                Arguments.arguments(7, 6),
                Arguments.arguments(6, 5),
                Arguments.arguments(5, 4),
                Arguments.arguments(4, 3),
                Arguments.arguments(3, 2),
                Arguments.arguments(2, 1),
                Arguments.arguments(1, 0),
                Arguments.arguments(0, -1),
                Arguments.arguments(-1, -2)
        );
    }

    @ParameterizedTest(name = "#{index} sellIn: {0} startingQuality: {1} expectedQuality: {2}")
    @MethodSource("createArguments_maximumQualityIs50")
    void updateQuality_maximumQualityIs50(int sellIn, int startingQuality, int expectedQuality) {
        StoreItem pass = StoreItemFactory.createPass(PASSES, sellIn, startingQuality);
        pass.updateQuality();
        assertThat(pass.quality).isEqualTo(expectedQuality);
    }

    private static Stream<Arguments> createArguments_maximumQualityIs50() {
        return Stream.of(
                Arguments.arguments(11 ,50, 50),
                Arguments.arguments(10 ,50, 50),
                Arguments.arguments(9 ,50, 50),
                Arguments.arguments(8 ,50, 50),
                Arguments.arguments(7 ,50, 50),
                Arguments.arguments(6 ,50, 50),
                Arguments.arguments(5 ,50, 50),
                Arguments.arguments(4 ,50, 50),
                Arguments.arguments(3 ,50, 50),
                Arguments.arguments(2 ,50, 50),
                Arguments.arguments(1 ,50, 50)
        );
    }

    @ParameterizedTest(name = "#{index} - sellin: {0} startingQuality: {1} expectedQuality: {2}")
    @MethodSource("createArguments_whenExpired_qualityEquals0")
    void updateQuality_whenExpired_qualityEquals0(int sellIn, int startingQuality, int expectedQuality) {
        StoreItem pass = StoreItemFactory.createPass(PASSES, sellIn, startingQuality);
        pass.updateQuality();
        assertThat(pass.quality).isEqualTo(expectedQuality);
    }

    private static Stream<Arguments> createArguments_whenExpired_qualityEquals0() {
        return Stream.of(
                Arguments.arguments(0, 34, 0),
                Arguments.arguments(-1, 34, 0)
        );
    }
}
