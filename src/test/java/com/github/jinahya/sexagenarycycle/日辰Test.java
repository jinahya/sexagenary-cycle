package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.github.jinahya.sexagenarycycle.月建Test.of2020庚子年04辛巳月;
import static com.github.jinahya.sexagenarycycle.月建Test.of2020庚子年04閏四月;
import static com.github.jinahya.sexagenarycycle.月建Test.of2020庚子年11戊子月;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class 日辰Test {

    // ------------------------------------------------------------------------------------------------------ 2020-04-01
    static 日辰 of2020庚子年04辛巳月01丙申日() { // 경자년 신사월 병신일
        return new 日辰(干支.valueOfName("丙申"), 1, of2020庚子年04辛巳月());
    }

    static 日辰 of2020庚子年04閏四月01丙寅日() { // 경자년 윤사월 병인일
        return new 日辰(干支.valueOfName("丙寅"), 1, of2020庚子年04閏四月());
    }

    // -------------------------------------------------------------------------------- (陰) 2020-11-11 / (陽) 2020-12-25
    static 日辰 of2020庚子年11戊子月11壬寅日() { // 경자년 무자월 을사일
        return new 日辰(干支.valueOfName("壬寅"), 11, of2020庚子年11戊子月());
    }

    // -----------------------------------------------------------------------------------------------------------------
    static Stream<日辰> parameters() {
        return Stream.of(
                of2020庚子年04辛巳月01丙申日(),
                of2020庚子年04閏四月01丙寅日(),
                of2020庚子年11戊子月11壬寅日()
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("new 日辰(,![1..30],) -> IllegalArgumentException")
    @MethodSource({"com.github.jinahya.sexagenarycycle.月建Test#parameters"})
    @ParameterizedTest
    void 日辰_IllegalArgumentsException_日(final 月建 月建) {
        final 干支 干支 = 月建.歲次.干支;
        assertThrows(IllegalArgumentException.class, () -> new 日辰(干支, 0, 月建));
        assertThrows(IllegalArgumentException.class, () -> new 日辰(干支, 31, 月建));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testToString(final 日辰 日辰) {
        assertThat(日辰.toString()).isNotBlank();
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testEquals(final 日辰 日辰) {
        // TODO: fix 
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void testHashCode(final 日辰 日辰) {
        final int hashCode = 日辰.hashCode();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testCompareTo(final 日辰 日辰) {
        // TODO: fix 
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testGet干支(final 日辰 日辰) {
        assertThat(日辰.干支).satisfies(v -> {
        });
    }
}