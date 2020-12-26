package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class 일진Test {

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"com.github.jinahya.sexagenarycycle.日辰Test#parameters"})
    @ParameterizedTest
    void from日辰_NonNull(final 日辰 日辰) {
        final 일진 일진 = com.github.jinahya.sexagenarycycle.일진.from(日辰);
        assertThat(일진).isNotNull().satisfies(d -> {
            assertThat(d.월건.월).isSameAs(日辰.月建.月);
            assertThat(d.일).isSameAs(日辰.日);
            assertThat(d.월건).isNotNull().satisfies(m -> {
                assertThat(m.월).isSameAs(日辰.月建.月);
                assertThat(m.세차).isNotNull().satisfies(y -> {
                    assertThat(y.년).isSameAs(日辰.月建.歲次.年);
                });
            });
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    static Stream<일진> parameters() {
        return 日辰Test.parameters().map(일진::from);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("new 일진(,![1..30],) -> IllegalArgumentException")
    @MethodSource({"com.github.jinahya.sexagenarycycle.월건Test#parameters"})
    @ParameterizedTest
    void 일진_IllegalArgumentsException_InvalidDayOfMonth(final 월건 월건) {
        assertThrows(IllegalArgumentException.class, () -> new 일진(월건.세차.간지, 0, 월건));
        assertThrows(IllegalArgumentException.class, () -> new 일진(월건.세차.간지, 31, 월건));
    }

    // ------------------------------------------------------------------------------------------------------------ to日辰
    @MethodSource({"parameters"})
    @ParameterizedTest
    void to日辰_NonNull(final 일진 일진) {
        assertThat(일진.to日辰()).isNotNull().satisfies(d -> {
            assertThat(d.干支).isNotNull().isSameAs(일진.간지.to干支());
            assertThat(d.日).isSameAs(일진.일);
            assertThat(d.月建).isNotNull().satisfies(m -> {
                assertThat(m.干支).isSameAs(ofNullable(일진.월건.간지).map(간지::to干支).orElse(null));
                assertThat(m.月).isSameAs(일진.월건.월);
                assertThat(m.is閏月()).isSameAs(일진.월건.is윤달());
                assertThat(m.歲次).isNotNull().satisfies(y -> {
                    assertThat(y.干支).isNotNull().isSameAs(일진.월건.세차.간지.to干支());
                    assertThat(y.年).isSameAs(일진.월건.세차.년);
                });
            });
        });
    }

    // -------------------------------------------------------------------------------------------------------- toString
    @MethodSource({"parameters"})
    @ParameterizedTest
    void toString_NonBlank(final 일진 일진) {
        assertThat(일진.toString()).isNotBlank();
    }

    // ---------------------------------------------------------------------------------------------------------- equals
    @MethodSource({"parameters"})
    @ParameterizedTest
    void equals_True_Self(final 일진 일진) {
        assertThat(일진.equals(일진)).isTrue();
        assertThat(일진).isEqualTo(일진);
    }

    // ---------------------------------------------------------------------------------------------------------- equals
    @MethodSource({"parameters"})
    @ParameterizedTest
    void equals_True_Clone(final 일진 일진) throws CloneNotSupportedException {
        assertThat(일진.equals(일진.clone())).isTrue();
        assertThat(일진).isEqualTo(일진.clone());
    }

    // -------------------------------------------------------------------------------------------------------- hashCode
    @MethodSource({"parameters"})
    @ParameterizedTest
    void hashCode_NoException_WhatEver(final 일진 일진) {
        final int hashCode = 일진.hashCode();
    }

    // ------------------------------------------------------------------------------------------------------- compareTo
    @MethodSource({"parameters"})
    @ParameterizedTest
    void compareTo_True_Self(final 일진 일진) {
        assertThat(일진.compareTo(일진)).isZero();
        assertThat(일진).isEqualByComparingTo(일진);
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void compareTo_True_Clone(final 일진 일진) throws CloneNotSupportedException {
        assertThat(일진.compareTo(일진.clone())).isZero();
        assertThat(일진).isEqualByComparingTo(일진.clone());
    }
}
