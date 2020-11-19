package com.gildedrose.rule;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void isEqualToItself() {
        RuleQualityImprovesTiered rule = new RuleQualityImprovesTiered();
        assertThat(rule).isEqualTo(rule);
    }

    @Test
    void isNotEqualToNull() {
        RuleQualityImprovesTiered rule = new RuleQualityImprovesTiered();
        assertThat(rule).isNotEqualTo(null);
    }

    @Test
    void isNotEqualToObjectOfDifferentClass() {
        RuleQualityImprovesTiered rule = new RuleQualityImprovesTiered();
        assertThat(rule).isNotEqualTo("object from other class");
    }

    @Test
    void isEqualToAnotherRuleQualityImprovedTieredObject() {
        RuleQualityImprovesTiered rule1 = new RuleQualityImprovesTiered();
        RuleQualityImprovesTiered rule2 = new RuleQualityImprovesTiered();

        assertThat(rule1).isEqualTo(rule2);
    }

}