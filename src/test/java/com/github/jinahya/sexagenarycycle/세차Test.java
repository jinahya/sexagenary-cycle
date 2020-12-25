package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class 세차Test {

    // ------------------------------------------------------------------------------------------------------- from(歲次)
    @MethodSource("com.github.jinahya.sexagenarycycle.歲次Test#parameters")
    @ParameterizedTest
    void from歲次_NonNullValid(final 歲次 歲次) {
        assertThat(세차.from(歲次)).isNotNull();
    }

    // -----------------------------------------------------------------------------------------------------------------
    static Stream<세차> parameters() {
        return 歲次Test.parameters()
                .map(세차::from);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void toString_NonBlank(final 세차 세차) {
        assertThat(세차.toString()).isNotBlank();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void equals_True_Self(final 세차 세차) {
        assertThat(세차).isEqualTo(세차);
    }

    @MethodSource({"parameters"})
    @ParameterizedTest
    void equals_True_Clone(final 세차 세차) throws CloneNotSupportedException {
        assertThat(세차).isEqualTo(세차.clone());
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"parameters"})
    @ParameterizedTest
    void hashCode_Valid(final 세차 세차) {
        final int hashCode = 세차.hashCode();
    }

    // ------------------------------------------------------------------------------------------------------- compareTo
    @MethodSource({"parameters"})
    @ParameterizedTest
    void compareTo_Zero(final 세차 세차) throws CloneNotSupportedException {
        assertThat(세차).isEqualByComparingTo(세차);
        assertThat(세차).isEqualByComparingTo(세차.clone());
    }
}
