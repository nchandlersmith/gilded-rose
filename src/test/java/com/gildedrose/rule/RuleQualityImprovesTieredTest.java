package com.gildedrose.rule;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RuleQualityImprovesTieredTest {

    @ParameterizedTest(name="#{index} - tiered quality test with arguments = {0}, {1}, {2}")
    @MethodSource("tieredRuleSpecs")
    void run_tieredQuality(int sellIn, int startingQuality, int expectedQuality) {
        RuleQualityImprovesTiered rule  = new RuleQualityImprovesTiered();
        int actualQuality = rule.run(sellIn, startingQuality);
        assertEquals(expectedQuality, actualQuality);
    }

    private static Stream<Arguments> tieredRuleSpecs() {
        return Stream.of(
                whenSellinGreaterThan10_thenIncreaseQualityBy1(),
                whenSellingBetween5And11IExclusive_thenIncreaseQualityBy2(),
                whenSellInNotNegativeAndLessThan6Exclusive_thenIncreaseQualityBy3()
        );
    }

    private static Arguments whenSellinGreaterThan10_thenIncreaseQualityBy1() {
        return Arguments.arguments(11, 21, 22);
    }

    private static Arguments whenSellingBetween5And11IExclusive_thenIncreaseQualityBy2() {
        return Arguments.arguments(10, 21, 23);
    }

    private static Arguments whenSellInNotNegativeAndLessThan6Exclusive_thenIncreaseQualityBy3() {
        return Arguments.arguments(5, 21, 24);
    }
}