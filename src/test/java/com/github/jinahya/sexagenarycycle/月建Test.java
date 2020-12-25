package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Month;
import java.util.stream.Stream;

import static com.github.jinahya.sexagenarycycle.歲次Test.of2020庚子年;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class 月建Test {

    // --------------------------------------------------------------------------------------------------------- 2020-04
    static 月建 of2020庚子年04辛巳月() { // 경자년 신사월
        return new 月建(干支.ofName("辛巳"), Month.APRIL, of2020庚子年());
    }

    static 月建 of2020庚子年04閏四月() { // 경자년 윤사월
        return 月建.ofLeapMonth(Month.APRIL, of2020庚子年());
    }

    // --------------------------------------------------------------------------------------------------------- 2020-11
    static 月建 of2020庚子年11戊子月() { // 경자년 무자월
        return new 月建(干支.ofName("戊子"), Month.NOVEMBER, of2020庚子年());
    }

    // --------------------------------------------------------------------------------------------------------- 2020-12
    static 月建 of2020庚子年12己丑月() { // 경자년 기축월
        return new 月建(干支.ofName("己丑"), Month.DECEMBER, of2020庚子年());
    }

    // -----------------------------------------------------------------------------------------------------------------
    static Stream<月建> parameters() {
        return Stream.of(
                of2020庚子年04辛巳月(),
                of2020庚子年04閏四月(),
                of2020庚子年11戊子月(),
                of2020庚子年12己丑月()
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void test_of2020庚子04辛巳() {
        final 月建 月建 = of2020庚子年04辛巳月();
        assertThat(月建.干支).isNotNull().isEqualTo(干支.of(天干.valueOf("辛"), 地支.valueOf("巳")));
        assertThat(月建.月).isNotNull().isEqualTo(Month.APRIL);
        assertThat(月建.is閏月()).isFalse();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testToString(final 月建 月建) {
        assertThat(月建.toString()).isNotBlank();
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testEquals(final 月建 月建) throws CloneNotSupportedException {
        assertThat(月建).isEqualTo(月建.clone());
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testHashCode(final 月建 月建) throws CloneNotSupportedException {
        assertThat(月建.hashCode()).satisfies(v -> {
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testCompareTo(final 月建 月建) throws CloneNotSupportedException {
        assertThat(月建.compareTo(月建.clone())).isZero();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testGet干支(final 月建 月建) {
        assertThat(月建.干支).satisfies(v -> {
        });
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testIsLeapMonth(final 月建 月建) {
        assertThat(月建.is閏月()).isEqualTo(月建.干支 == null);
    }
}