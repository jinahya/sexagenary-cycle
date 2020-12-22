package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Month;
import java.time.Year;
import java.util.stream.Stream;

import static com.github.jinahya.sexagenarycycle.歲次Test.of2020庚子年;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class 月建Test { // 月建Test

    // --------------------------------------------------------------------------------------------------------- 2020-04
    static 月建 of2020庚子年04辛巳月() { // 경자년 신사월
        return new 月建(干支.valueOfName("辛巳"), of2020庚子年(), Month.APRIL);
    }

    static 月建 of2020庚子年04閏四月() { // 경자년 윤사월
        return 月建.ofLeapMonth(of2020庚子年(), Month.APRIL);
    }

    // --------------------------------------------------------------------------------------------------------- 2020-12
    static 月建 of2020庚子年12戊子月() { // 경자년 무자월
        return new 月建(干支.valueOfName("戊子"), of2020庚子年(), Month.DECEMBER);
    }

    // -----------------------------------------------------------------------------------------------------------------
    static Stream<月建> parameters() {
        return Stream.of(
                of2020庚子年04辛巳月(),
                of2020庚子年04閏四月(),
                of2020庚子年12戊子月()
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Test
    void test_of2020庚子04辛巳() {
        final 月建 月建 = of2020庚子年04辛巳月();
        assertThat(月建.getGanzhi()).isNotNull().isEqualTo(干支.valueOf(天干.valueOf("辛"), 地支.valueOf("巳")));
        assertThat(月建.getYear()).isNotNull().isEqualTo(Year.of(2020));
        assertThat(月建.getMonth()).isNotNull().isEqualTo(Month.APRIL);
        assertThat(月建.isLeapMonth()).isFalse();
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

//    // -----------------------------------------------------------------------------------------------------------------
//    @Test
//    void testGetPrevious() {
//        {
//            final 月建 current = of2020庚子年04辛巳月();
//            assertThat(current.getPrevious()).isNotNull().satisfies(p -> {
//                assertThat(p.getYear()).isNotNull().isEqualTo(current.getYear());
//                assertThat(p.getMonth()).isNotNull().isEqualTo(current.getMonth().minus(1L));
//            });
//        }
//    }
//
//    @Test
//    void testGetNext() {
//        {
//            final 月建 current = of2020庚子年04辛巳月();
//            assertThat(current.getNext()).isNotNull().satisfies(p -> {
//                assertThat(p.getYear()).isNotNull().isEqualTo(current.getYear());
//                assertThat(p.getMonth()).isNotNull().isEqualTo(current.getMonth().plus(1L));
//            });
//        }
//    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testGet干支(final 月建 月建) {
        assertThat(月建.get干支()).satisfies(v -> {
        });
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testIsLeapMonth(final 月建 月建) {
        assertThat(月建.isLeapMonth()).isEqualTo(月建.get干支() == null);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testGetYear(final 月建 月建) {
        assertThat(月建.getYear()).satisfies(v -> {
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testGetMonth(final 月建 月建) {
        assertThat(月建.getMonth()).satisfies(v -> {
        });
    }
}