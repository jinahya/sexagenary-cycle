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
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
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

    // -------------------------------------------------------------------------------- (陰) 2020-11-19 / (陽) 202-01-02
    static 日辰 of2020庚子年11戊子月19庚戌日() { // 경자년 무자월 경술일
        return new 日辰(干支.valueOfName("庚戌"), 19, of2020庚子年11戊子月());
    }

    // -----------------------------------------------------------------------------------------------------------------
    static Stream<日辰> parameters() {
        return Stream.of(
                of2020庚子年04辛巳月01丙申日(),
                of2020庚子年04閏四月01丙寅日(),
                of2020庚子年11戊子月11壬寅日(),
                of2020庚子年11戊子月19庚戌日()
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

    // -------------------------------------------------------------------------------------------------------- toString
    @MethodSource({"parameters"})
    @ParameterizedTest
    void toString_NonBlank(final 日辰 日辰) {
        assertThat(日辰.toString()).isNotBlank();
    }

    // ---------------------------------------------------------------------------------------------------------- equals
    @MethodSource({"parameters"})
    @ParameterizedTest
    void equals_True_Self(final 日辰 日辰) {
        assertThat(日辰).isEqualTo(日辰);
        assertEquals(日辰, 日辰);
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void equals_True_Copy(final 日辰 日辰) {
        assertThat(日辰).isEqualTo(new 日辰(日辰.干支, 日辰.日, 日辰.月建));
    }

    // -------------------------------------------------------------------------------------------------------- hashCode
    @MethodSource({"parameters"})
    @ParameterizedTest
    void testHashCode(final 日辰 日辰) {
        assertDoesNotThrow(日辰::hashCode);
    }

    // ------------------------------------------------------------------------------------------------------- compareTo
    @MethodSource({"parameters"})
    @ParameterizedTest
    void compareTo_Zero_Self(final 日辰 日辰) {
        assertThat(日辰).isEqualByComparingTo(日辰);
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void compareTo_Zero_Copy(final 日辰 日辰) {
        assertThat(日辰).isEqualByComparingTo(new 日辰(日辰.干支, 日辰.日, 日辰.月建));
    }
}